package com.starillon.ibtradetools.strategy;

import com.google.inject.Inject;
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
    protected ConnectionFactory connectionFactory;
    protected RequestIdGenerator requestIdGenerator;
    @Inject
    protected Logger logger;
    protected Connection connection;

    public BaseStrategy(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        this.requestIdGenerator = requestIdGenerator;
        this.connectionFactory = connectionFactory;
    }

    protected void initialiseConnection(ConnectionFactory connectionFactory) {
        connection = connectionFactory.getConnection(getTradeHandler());
        connection.connect();
    }

    protected abstract TradeHandler getTradeHandler();
}
