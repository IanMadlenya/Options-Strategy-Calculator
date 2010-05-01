package com.starillon.ibtradetools.connection;

import com.google.inject.AbstractModule;
import com.ib.client.EWrapper;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:15:09 PM
 */
public class TradeToolsConnectionModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(ConnectionFactory.class).to(ConnectionFactoryImpl.class);
        bind(EWrapper.class).to(WrapperAdapter.class);
    }
}
