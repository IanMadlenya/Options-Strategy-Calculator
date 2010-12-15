package com.starillon.ibtradetools;

import com.starillon.ibtradetools.contract.*;
import com.starillon.ibtradetools.data.EODMarketData;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

@Test(groups = "functional")
public class HistoricalDataFTest extends BaseFTest {

    @Test(timeOut = 5000)
    public void getValidStockData() throws InterruptedException {
        ContractDataCriteria criteria = new ContractDataCriteria();
        criteria.setDuration(Duration.DAYS);
        criteria.setDurationAmount(5);
        criteria.setContract(new ASXStock("BHP"));
        criteria.setBarSize(BarSize.FIVE_MIN);
        criteria.setMarketDataType(MarketDataType.BID_ASK);

        final CountDownLatch latch = new CountDownLatch(1);

        TestEODMarketDataListener listener = new TestEODMarketDataListener(latch) {
            @Override
            public void handleData(EODMarketData marketData) {
                System.err.println("Market data : " + marketData);
                super.handleData(marketData);
            }
        };

        marketDataService.requestStockEODData(new Date(), criteria, listener);
        latch.await();
        assert (!listener.isMarketDataError());
        marketDataService.unsubscribe(listener);
    }
}
