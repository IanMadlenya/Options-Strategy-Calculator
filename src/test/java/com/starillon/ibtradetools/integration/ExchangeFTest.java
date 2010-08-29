package com.starillon.ibtradetools.integration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ib.client.Contract;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 7:39:20 PM
 */
@Test(groups = "functional")
public class ExchangeFTest {
    private Injector injector;

    @Test
    public void exchange_listSymbols_success() {
        Exchange exchange = injector.getInstance(Exchange.class);
        List<Contract> symbols = exchange.listAllSymbols();
        assert (symbols.size() != 0) : "Unexpected size : " + symbols.size();
        assert (symbols.get(0).m_symbol.equalsIgnoreCase("ont"));
    }

    @BeforeClass
    protected void setUp() {
        injector = Guice.createInjector(new TradeToolsIntegrationModule());
    }
}
