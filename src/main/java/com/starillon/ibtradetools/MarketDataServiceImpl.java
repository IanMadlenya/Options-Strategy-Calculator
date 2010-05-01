package com.starillon.ibtradetools;

import com.google.inject.Inject;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:50:20 PM
 */
class MarketDataServiceImpl implements MarketDataService
{
    @Inject
    private Logger logger;

    @Inject
    @HistoricalEODData
    private MarketDataStrategy stockEODStrategy;

    @Override
    public void requestStockEODData(Date date, String... symbols)
    {
        stockEODStrategy.execute(date, symbols);    
    }
}
