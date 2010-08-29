package com.starillon.ibtradetools;

import com.starillon.ibtradetools.data.MarketData;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 22, 2010
 * Time: 5:57:12 PM
 */
public class TestMarketDataListener implements MarketDataListener {
    private boolean marketDataError = false;
    private final CountDownLatch latch;

    public TestMarketDataListener(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void handleData(MarketData marketData) {
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
