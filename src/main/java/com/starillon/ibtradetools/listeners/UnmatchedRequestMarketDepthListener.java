package com.starillon.ibtradetools.listeners;

import com.starillon.ibtradetools.data.DepthMarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 5, 2010
 * Time: 6:25:58 PM
 */
public class UnmatchedRequestMarketDepthListener extends BaseDataListener implements MarketDepthListener {
    @Override
    public void handle(DepthMarketData depthMarketData) {
        logger.warning("Unmatched Market Depth data : " + depthMarketData);
    }
}
