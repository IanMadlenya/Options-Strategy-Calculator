package com.starillon.ibtradetools.connection;

import com.starillon.ibtradetools.BaseTradeToolsModule;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:15:09 PM
 */
public class TradeToolsConnectionModule extends BaseTradeToolsModule
{

    @Override
    protected void configure()
    {
        loadProperties();
        bind(ConnectionFactory.class).to(ConnectionFactoryImpl.class);
        bind(ConnectionHandler.class).to(WrapperAdapter.class);
    }
}
