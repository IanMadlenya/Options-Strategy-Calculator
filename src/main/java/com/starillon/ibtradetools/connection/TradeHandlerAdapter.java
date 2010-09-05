package com.starillon.ibtradetools.connection;

import com.starillon.ibtradetools.TradeException;
import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.data.MarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 5, 2010
 * Time: 5:28:04 PM
 */
public class TradeHandlerAdapter implements TradeHandler {
    @Override
    public void handleHistoricalData(int requestId, MarketData marketData) {
        throw new TradeException("Not Implemented");
    }

    @Override
    public void handleError(int requestId, int errorCode, String errorMessage) {
        throw new TradeException("Not Implemented");
    }

    @Override
    public void updateDepth(int requestId, DepthMarketData depthMarketData) {
        throw new TradeException("Not Implemented");
    }
}
