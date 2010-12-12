package com.starillon.ibtradetools.strategy.data;

import com.ib.client.Contract;
import com.starillon.ibtradetools.listeners.MarketDepthListener;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 8:05:07 PM
 */
public interface MarketDepthStrategy {
    void execute(Contract contract, int depth, MarketDepthListener marketDepthListener);

    void cancel(MarketDepthListener marketDepthListener);
}
