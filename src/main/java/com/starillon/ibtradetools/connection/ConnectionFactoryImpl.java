package com.starillon.ibtradetools.connection;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:06:04 PM
 */
class ConnectionFactoryImpl implements ConnectionFactory
{
    private final Provider<ConnectionHandler> connectionHandlerProvider;
    private final String host;
    private final int port;

    @Inject
    ConnectionFactoryImpl(Provider<ConnectionHandler> connectionHandlerProvider, @Named("host") String host,
                          @Named("port") int port)
    {
        this.connectionHandlerProvider = connectionHandlerProvider;
        this.host = host;
        this.port = port;
    }

    @Override
    public Connection getConnection(TradeHandler handler)
    {
        checkNotNull(handler, "handler cannot be null");
        return new ConnectionImpl(connectionHandlerProvider.get(), handler, host, port);
    }
}
