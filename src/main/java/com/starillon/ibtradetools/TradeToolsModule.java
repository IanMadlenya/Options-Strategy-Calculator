package com.starillon.ibtradetools;

import com.google.inject.AbstractModule;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:49:23 PM
 */
public class TradeToolsModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(MarketDataStrategy.class).annotatedWith(HistoricalEODData.class).to(HistoricalEODDataStrategy.class);
    }
}
