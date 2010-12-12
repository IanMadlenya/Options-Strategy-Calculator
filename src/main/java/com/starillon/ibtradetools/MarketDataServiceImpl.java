package com.starillon.ibtradetools;

import com.google.inject.Inject;
import com.ib.client.Contract;
import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.listeners.MarketDataListener;
import com.starillon.ibtradetools.listeners.MarketDepthListener;
import com.starillon.ibtradetools.strategy.data.HistoricalEODData;
import com.starillon.ibtradetools.strategy.data.MarketDataStrategy;
import com.starillon.ibtradetools.strategy.data.MarketDepthStrategy;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:50:20 PM
 */
class MarketDataServiceImpl implements MarketDataService {
    @Inject
    @HistoricalEODData
    private MarketDataStrategy stockEODStrategy;
    @Inject
    private MarketDepthStrategy marketDepthStrategy;

    @Override
    public void requestStockEODData(Date date, ContractDataCriteria criteria, MarketDataListener marketDataListener) {
        stockEODStrategy.execute(date, criteria, marketDataListener);
    }

    @Override
    public void unsubscribe(MarketDataListener marketDataListener) {
        stockEODStrategy.cancel(marketDataListener);
    }

    @Override
    public void requestMarketDepth(Contract contract, int depth, MarketDepthListener marketDepthListener) {
        marketDepthStrategy.execute(contract, depth, marketDepthListener);
    }

    @Override
    public void unsubscribe(MarketDepthListener marketDepthListener) {
        marketDepthStrategy.cancel(marketDepthListener);
    }
}
