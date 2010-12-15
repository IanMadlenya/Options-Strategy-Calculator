package com.starillon.ibtradetools;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.starillon.ibtradetools.connection.TradeToolsConnectionModule;
import org.guiceyfruit.jsr250.Jsr250Module;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 13, 2010
 * Time: 9:37:38 PM
 */
public class BaseFTest {
    protected final static Injector injector = Guice.createInjector(new Jsr250Module(), new TradeToolsConnectionModule(),
            new TradeToolsModule());
    protected final static MarketDataService marketDataService = injector.getInstance(MarketDataService.class);
    protected final static ContractService contractService = injector.getInstance(ContractService.class);
}
