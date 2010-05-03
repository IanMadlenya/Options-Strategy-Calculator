package com.starillon.ibtradetools.connection;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:06:04 PM
 */
class ConnectionFactoryImpl implements ConnectionFactory
{
    private final Provider<ConnectionHandler> connectionHandlerProvider;

    @Inject
    ConnectionFactoryImpl(Provider<ConnectionHandler> connectionHandlerProvider)
    {
        this.connectionHandlerProvider = connectionHandlerProvider;
    }

    @Override
    public Connection getConnection(TradeHandler handler)
    {
        return new ConnectionImpl(connectionHandlerProvider.get(), handler);
    }
}
