package com.starillon.ibtradetools;

import com.starillon.ibtradetools.contract.ASXStock;
import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.listeners.MarketDepthListener;
import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 13, 2010
 * Time: 9:39:18 PM
 */
@Test(groups = "functional")
public class MarketDepthFTest extends BaseFTest {
    @Test(timeOut = 5000)
    public void getMarketDepthData() throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        TestMarketDepthListener listener = new TestMarketDepthListener(latch);

        marketDataService.requestMarketDepth(new ASXStock("BHP"), 10, listener);
        latch.await();

        assert (!listener.isError());
        marketDataService.unsubscribe(listener);
    }

    class TestMarketDepthListener implements MarketDepthListener {
        boolean isError = false;
        private final CountDownLatch latch;

        TestMarketDepthListener(CountDownLatch latch) {
            this.latch = latch;
        }

        public boolean isError() {
            return isError;
        }

        @Override
        public void handle(DepthMarketData depthMarketData) {
            latch.countDown();
        }

        @Override
        public void onError(int errorCode, String errorMessage) {
            isError = true;
            latch.countDown();
        }
    }
}
