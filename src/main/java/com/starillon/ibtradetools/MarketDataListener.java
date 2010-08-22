package com.starillon.ibtradetools;

import com.starillon.ibtradetools.dto.MarketData;

import java.util.EventListener;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 22, 2010
 * Time: 5:17:03 PM
 */
public interface MarketDataListener extends EventListener {
    void handleData(MarketData marketData);

    void onError(int errorCode, String errorMessage);
}
