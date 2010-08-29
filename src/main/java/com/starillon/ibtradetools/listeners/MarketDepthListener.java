package com.starillon.ibtradetools.listeners;

import com.starillon.ibtradetools.data.DepthMarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 7:59:44 PM
 */
public interface MarketDepthListener extends DataListener {
    void handle(DepthMarketData depthMarketData);
}
