package com.starillon.ibtradetools.listeners;

import com.google.inject.Inject;
import com.starillon.ibtradetools.data.DepthMarketData;

import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 5, 2010
 * Time: 6:25:58 PM
 */
public class UnmatchedRequestMarketDepthListener implements MarketDepthListener {
    @Inject
    private Logger logger;

    @Override
    public void handle(DepthMarketData depthMarketData) {
        logger.warning("Unmatched Market Depth data : " + depthMarketData);
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        logger.severe("Unmatched error message : " + errorCode + " : " + errorMessage);
    }
}
