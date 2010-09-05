package com.starillon.ibtradetools;

import com.starillon.ibtradetools.listeners.MarketDataListener;
import com.starillon.ibtradetools.listeners.UnmatchedMarketData;
import com.starillon.ibtradetools.listeners.UnmatchedRequestMarketDataListener;
import com.starillon.ibtradetools.strategy.*;
import com.starillon.ibtradetools.util.RequestIdGenerator;
import com.starillon.ibtradetools.util.RequestIdGeneratorImpl;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:49:23 PM
 */
public class TradeToolsModule extends BaseTradeToolsModule {
    @Override
    protected void configure() {
        bind(MarketDataService.class).to(MarketDataServiceImpl.class);
        bind(MarketDataStrategy.class).annotatedWith(HistoricalEODData.class).to(HistoricalEODDataStrategyImpl.class);
        bind(MarketDataListener.class).annotatedWith(UnmatchedMarketData.class).to(UnmatchedRequestMarketDataListener.class);
        bind(RequestIdGenerator.class).to(RequestIdGeneratorImpl.class);
        bind(MarketDepthStrategy.class).to(MarketDepthStrategyImpl.class);
    }
}
