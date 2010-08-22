package com.starillon.ibtradetools;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.dto.MarketData;
import com.starillon.ibtradetools.util.DateConverter;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategy implements TradeHandler, MarketDataStrategy {
    private ConnectionFactory connectionFactory;
    private RequestIdGenerator requestIdGenerator;
    @Inject
    private Logger logger;
    private Connection connection;
    final private Map<Integer, MarketDataListener> criteriaRequests;
    private static final int HIST_DATA_SERV_CONNECTED = 2106;

    @Inject
    public HistoricalEODDataStrategy(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        this.requestIdGenerator = requestIdGenerator;
        this.connectionFactory = connectionFactory;
        connection = connectionFactory.getConnection(this);
        connection.connect();
        criteriaRequests = Maps.newHashMap();

    }


    @Override
    public void execute(Date date, List<ContractDataCriteria> criteria, MarketDataListener marketDataListener) {
        assert (connection.isConnected()) : "Connection not established";
        checkNotNull(date, "date is null");
        checkNotNull(criteria, "criteria is null");
        checkNotNull(marketDataListener, "marketDataListener is null");

        for (ContractDataCriteria contractDataCriteria : criteria) {
            Integer requestId = requestIdGenerator.nextValue();
            criteriaRequests.put(requestId, marketDataListener);

            connection.getSocket().reqHistoricalData(requestId, contractDataCriteria.getContract(),
                    DateConverter.convert(date), contractDataCriteria.getDuration(), contractDataCriteria.getBarSize(),
                    contractDataCriteria.getMarketDataType(), contractDataCriteria.getRegularTradingHours(),
                    contractDataCriteria.getDateFormat());
        }
    }

    @Override
    public void handleHistoricalData(int id, MarketData marketData) {
        getListener(id).handleData(marketData);
    }

    @Override
    public void handleError(int id, int errorCode, String errorMessage) {
        if (!isWarning(errorCode)) {
            getListener(id).onError(errorCode, errorMessage);
        } else {
            logger.warning("Encountered warning code : " + errorCode + " , mesg: " + errorMessage);
        }
    }

    private boolean isWarning(int errorCode) {
        return errorCode == HIST_DATA_SERV_CONNECTED;
    }

    private MarketDataListener getListener(int id) {
        MarketDataListener listener = criteriaRequests.get(id);

        if (listener == null && id != -1) {
            throw new TradeException("Listener for request id : " + id + " not found");
        } else {
            logger.info("Ignore request for listener with id : " + id);
        }

        return listener;
    }
}
