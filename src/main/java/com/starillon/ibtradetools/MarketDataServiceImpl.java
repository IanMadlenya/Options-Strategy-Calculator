package com.starillon.ibtradetools;

import com.google.inject.Inject;
import com.starillon.ibtradetools.contract.ContractDataCriteria;

import java.util.Date;
import java.util.List;

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


    @Override
    public void requestStockEODData(Date date, List<ContractDataCriteria> contracts, MarketDataListener marketDataListener) {
        stockEODStrategy.execute(date, contracts, marketDataListener);
    }
}
