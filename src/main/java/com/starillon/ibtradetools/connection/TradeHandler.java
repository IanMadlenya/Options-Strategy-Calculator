package com.starillon.ibtradetools.connection;

import com.starillon.ibtradetools.dto.MarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:39:53 PM
 */
public interface TradeHandler
{
    void handleHistoricalData(MarketData marketData);
    void handleError(int id, int errorCode, String errorMessage);
}
