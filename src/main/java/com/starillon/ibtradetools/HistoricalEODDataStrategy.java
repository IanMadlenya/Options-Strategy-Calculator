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

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategy implements TradeHandler, MarketDataStrategy {
    @Inject
    private ConnectionFactory connectionFactory;
    @Inject
    private RequestIdGenerator requestIdGenerator;
    private Connection connection;
    final private Map<ContractDataCriteria, Integer> criteriaRequests;

    public HistoricalEODDataStrategy() {
        connection = connectionFactory.getConnection(this);
        connection.connect();
        criteriaRequests = Maps.newHashMap();

    }


    @Override
    public void execute(Date date, List<ContractDataCriteria> criteria) {
        assert (connection.isConnected()) : "Connection not established";
        checkNotNull(date, "date is null");

        for (ContractDataCriteria contractDataCriteria : criteria) {
            Integer requestId = requestIdGenerator.nextValue();
            criteriaRequests.put(contractDataCriteria, requestId);

            connection.getSocket().reqHistoricalData(requestId, contractDataCriteria.getContract(),
                    DateConverter.convert(date), contractDataCriteria.getDuration(), contractDataCriteria.getBarSize(),
                    contractDataCriteria.getMarketDataType(), contractDataCriteria.getRegularTradingHours(),
                    contractDataCriteria.getDateFormat());
        }
    }

    @Override
    public void handleHistoricalData(MarketData marketData) {

    }

    @Override
    public void handleError(int id, int errorCode, String errorMessage) {

    }
}
