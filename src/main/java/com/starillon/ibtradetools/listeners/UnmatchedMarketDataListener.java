package com.starillon.ibtradetools.listeners;

import com.starillon.ibtradetools.data.MarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 12:30 PM
 */
public class UnmatchedMarketDataListener extends BaseDataListener implements MarketDataListener {
    @Override
    public void handle(MarketData marketData) {
        logger.warning("Unmatched market data : " + marketData);
    }
}
