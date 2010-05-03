package com.starillon.ibtradetools.integration;

import com.starillon.ibtradetools.BaseTradeToolsModule;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 6:54:12 PM
 */
public class TradeToolsIntegrationModule extends BaseTradeToolsModule
{
    @Override
    protected void configure()
    {
        loadProperties();
        bind(Exchange.class).to(ASXExchange.class);
    }
}
