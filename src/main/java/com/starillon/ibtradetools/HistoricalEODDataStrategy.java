package com.starillon.ibtradetools;

import com.google.inject.Inject;
import com.ib.client.Contract;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.dto.MarketData;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategy implements TradeHandler, MarketDataStrategy
{
    @Inject
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public HistoricalEODDataStrategy()
    {
        connection = connectionFactory.getConnection(this);
        // TODO Fix this
        connection.connect("", 9999);
    }

    @Override
    public void execute(Date date, String... symbols)
    {
        // TODO sort this out
        Contract contract = new Contract();
    }

    @Override
    public void handleHistoricalData(MarketData marketData)
    {

    }

    @Override
    public void handleError(int id, int errorCode, String errorMessage)
    {

    }
}
