package com.starillon.ibtradetools;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.starillon.ibtradetools.connection.TradeToolsConnectionModule;
import org.testng.annotations.BeforeMethod;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 13, 2010
 * Time: 9:37:38 PM
 */
public class BaseFTest {
    protected MarketDataService marketDataService;

    @BeforeMethod
    protected void setUp() throws Exception {
        Injector injector = Guice.createInjector(new TradeToolsConnectionModule(),
                new TradeToolsModule());
        marketDataService = injector.getInstance(MarketDataService.class);
    }
}
