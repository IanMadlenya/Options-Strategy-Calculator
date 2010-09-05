package com.starillon.ibtradetools.connection;

import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.data.MarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:39:53 PM
 */
public interface TradeHandler {
    void handleHistoricalData(int requestId, MarketData marketData);

    void handleError(int requestId, int errorCode, String errorMessage);

    void updateDepth(int requestId, DepthMarketData depthMarketData);
}
