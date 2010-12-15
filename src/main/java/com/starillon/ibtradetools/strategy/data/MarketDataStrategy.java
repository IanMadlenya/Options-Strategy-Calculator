package com.starillon.ibtradetools.strategy.data;

import com.ib.client.Contract;
import com.starillon.ibtradetools.listeners.MarketDataListener;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 12:18 PM
 */
public interface MarketDataStrategy {
    void execute(Contract contract, boolean snapshot, MarketDataListener listener);

    void cancel(MarketDataListener listener);
}
