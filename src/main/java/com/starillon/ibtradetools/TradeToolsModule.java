package com.starillon.ibtradetools;

import com.starillon.ibtradetools.listeners.*;
import com.starillon.ibtradetools.strategy.contract.OptionsDetailsStrategy;
import com.starillon.ibtradetools.strategy.contract.OptionsDetailsStrategyImpl;
import com.starillon.ibtradetools.strategy.data.*;
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
        bind(ContractService.class).to(ContractServiceImpl.class);
        bind(OptionsDetailsStrategy.class).to(OptionsDetailsStrategyImpl.class);
        bind(MarketDataService.class).to(MarketDataServiceImpl.class);
        bind(EODMarketDataStrategy.class).annotatedWith(HistoricalEODData.class).to(HistoricalEODDataStrategyImpl.class);
        bind(EODMarketDataListener.class).annotatedWith(UnmatchedEODMarketData.class).to(UnmatchedRequestEODMarketDataListener.class);
        bind(RequestIdGenerator.class).to(RequestIdGeneratorImpl.class);
        bind(MarketDepthStrategy.class).to(MarketDepthStrategyImpl.class);
        bind(MarketDepthListener.class).annotatedWith(UnmatchedMarketDepthData.class).to(UnmatchedRequestMarketDepthListener.class);
        bind(MarketDataListener.class).annotatedWith(UnmatchedMarketData.class).to(UnmatchedMarketDataListener.class);
        bind(MarketDataStrategy.class).to(MarketDataStrategyImpl.class);
    }
}
