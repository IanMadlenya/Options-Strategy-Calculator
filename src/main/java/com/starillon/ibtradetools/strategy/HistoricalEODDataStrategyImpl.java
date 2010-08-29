package com.starillon.ibtradetools.strategy;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.data.MarketData;
import com.starillon.ibtradetools.listeners.MarketDataListener;
import com.starillon.ibtradetools.listeners.UnmatchedMarketData;
import com.starillon.ibtradetools.util.DateConverter;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategyImpl implements TradeHandler, MarketDataStrategy {
    private ConnectionFactory connectionFactory;
    private RequestIdGenerator requestIdGenerator;
    @Inject
    private Logger logger;
    @Inject
    @UnmatchedMarketData
    private MarketDataListener unmatchedRequestListener;
    private Connection connection;
    final private Map<Integer, MarketDataListener> criteriaRequests;
    private static final int HIST_DATA_SERV_CONNECTED = 2106;

    @Inject
    public HistoricalEODDataStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        this.requestIdGenerator = requestIdGenerator;
        this.connectionFactory = connectionFactory;
        connection = connectionFactory.getConnection(this);
        connection.connect();
        criteriaRequests = Maps.newHashMap();

    }


    @Override
    public void execute(Date date, ContractDataCriteria criteria, MarketDataListener marketDataListener) {
        assert (connection.isConnected()) : "Connection not established";
        checkNotNull(date, "date is null");
        checkNotNull(criteria, "criteria is null");
        checkNotNull(marketDataListener, "marketDataListener is null");

        Integer requestId = requestIdGenerator.nextValue();
        criteriaRequests.put(requestId, marketDataListener);

        connection.getSocket().reqHistoricalData(requestId, criteria.getContract(),
                DateConverter.convert(date), criteria.getDuration(), criteria.getBarSize(),
                criteria.getMarketDataType(), criteria.getRegularTradingHours(),
                criteria.getDateFormat());

    }

    @Override
    public void cancel(MarketDataListener marketDataListener) {
        checkNotNull(marketDataListener, "marketDataListener is null");

        for (Integer requestId : criteriaRequests.keySet()) {
            if (criteriaRequests.get(requestId).equals(marketDataListener)) {
                connection.getSocket().cancelHistoricalData(requestId);
                criteriaRequests.remove(requestId);
            }
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
            logger.warning("Unmatched marker data listener for request id " + id);
            listener = unmatchedRequestListener;
        } else {
            logger.info("Ignore request for listener with id : " + id);
        }

        return listener;
    }
}
