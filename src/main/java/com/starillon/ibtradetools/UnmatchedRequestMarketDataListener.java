package com.starillon.ibtradetools;

import com.google.inject.Inject;
import com.starillon.ibtradetools.data.MarketData;

import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 4:20:04 PM
 */
public class UnmatchedRequestMarketDataListener implements MarketDataListener {
    @Inject
    private Logger logger;

    @Override
    public void handleData(MarketData marketData) {
        logger.warning("Unmatched market data request : " + marketData);
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        logger.warning("Unmatched error for request, error code : " + errorCode + ", message : " + errorMessage);
    }
}
