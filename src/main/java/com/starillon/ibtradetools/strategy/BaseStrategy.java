package com.starillon.ibtradetools.strategy;

import com.google.inject.Inject;
import com.ib.client.EClientSocket;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 5, 2010
 * Time: 5:08:12 PM
 */
public abstract class BaseStrategy {
    @Inject
    protected Logger logger;
    protected RequestIdGenerator requestIdGenerator;
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public BaseStrategy(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        this.requestIdGenerator = requestIdGenerator;
        this.connectionFactory = connectionFactory;
    }

    protected void initialiseConnection() {
        connection = connectionFactory.getConnection(getTradeHandler());
        connection.connect();
    }

    protected EClientSocket getSocket() {
        assert (connection.isConnected()) : "Connection not established";
        return connection.getSocket();
    }

    protected abstract TradeHandler getTradeHandler();

}
