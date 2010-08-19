package com.starillon.ibtradetools;

import com.google.inject.Inject;
import com.ib.client.Contract;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.dto.MarketData;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategy implements TradeHandler, MarketDataStrategy {
    @Inject
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public HistoricalEODDataStrategy() {
        connection = connectionFactory.getConnection(this);
        connection.connect();
    }


    @Override
    public void execute(Date date, List<Contract> symbols) {
        assert (connection.isConnected()) : "Connection not established";

        // TODO fill in api calls
        //connection.getSocket().reqHistoricalData();
    }

    @Override
    public void handleHistoricalData(MarketData marketData) {

    }

    @Override
    public void handleError(int id, int errorCode, String errorMessage) {

    }
}
