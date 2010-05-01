package com.starillon.ibtradetools.connection;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:06:04 PM
 */
class ConnectionFactoryImpl implements ConnectionFactory
{
    @Override
    public Connection getConnection(TradeHandler handler)
    {
        return new ConnectionImpl(handler);
    }
}
