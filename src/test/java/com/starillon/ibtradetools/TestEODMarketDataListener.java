package com.starillon.ibtradetools;

import com.starillon.ibtradetools.data.EODMarketData;
import com.starillon.ibtradetools.listeners.EODMarketDataListener;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 22, 2010
 * Time: 5:57:12 PM
 */
public class TestEODMarketDataListener implements EODMarketDataListener {
    private boolean marketDataError = false;
    private final CountDownLatch latch;

    public TestEODMarketDataListener(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void handleData(EODMarketData eodMarketData) {
        latch.countDown();
    }

    @Override
    public void onError(int errorCode, String errorMessage) {
        marketDataError = true;
        latch.countDown();
    }

    public boolean isMarketDataError() {
        return marketDataError;
    }
}
