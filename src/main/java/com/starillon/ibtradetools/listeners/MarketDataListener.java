package com.starillon.ibtradetools.listeners;

import com.starillon.ibtradetools.data.MarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 12:14 PM
 */
public interface MarketDataListener extends DataListener {
    void handle(MarketData marketData);
}
