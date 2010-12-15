package com.starillon.ibtradetools;

import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.contract.ASXOption;
import com.starillon.ibtradetools.data.MarketData;
import com.starillon.ibtradetools.listeners.MarketDataListener;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 2:23 PM
 */
@Test(groups = "functional")
public class MarketDataFTest extends BaseFTest {
    @Test(timeOut = 5000)
    public void testOptionMarketDataValid() throws InterruptedException {
        ASXOption asxOption = new ASXOption("CBA");
        CountDownLatch latch = new CountDownLatch(1);
        List<ContractDetails> optionDetails = contractService.listOptionsForUnderlying(asxOption);
        assert (!optionDetails.isEmpty());

        ContractDetails details = optionDetails.get(0);
        TestMarketDatatListener listener = new TestMarketDatatListener(latch);
        marketDataService.requestMarketData(details.m_summary, false, listener);
        latch.await();

        assert (!listener.isError());
        marketDataService.unsubscribe(listener);
    }

    class TestMarketDatatListener implements MarketDataListener {
        boolean isError = false;
        private final CountDownLatch latch;

        TestMarketDatatListener(CountDownLatch latch) {
            this.latch = latch;
        }

        public boolean isError() {
            return isError;
        }

        @Override
        public void handle(MarketData marketData) {
            isError = marketData == null;
            System.out.println("Market Data : " + marketData);
            latch.countDown();
        }

        @Override
        public void onError(int errorCode, String errorMessage) {
            isError = true;
            latch.countDown();
        }
    }

}
