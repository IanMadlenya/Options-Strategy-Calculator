/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools.convertors;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.starillon.ibtradetools.IBTradeToolsModule;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

@Test (groups = "functional")
public class MetaStockCSVConverterFTest
{
    private Injector injector;
    private static final String META_STOCK_CSV_FILE = "MetaStock.csv";

    @BeforeTest
    public void setup()
    {
        injector = Guice.createInjector(new IBTradeToolsModule());
    }

    @AfterTest
    public void cleanUp()
    {
        assert(new File(META_STOCK_CSV_FILE).delete());
    }

    @Test
    public void covert_oneLine_success() throws Exception
    {
        Converter converter = injector.getInstance(Converter.class);
        assert(converter != null);

        converter.open(new FileNameTarget(META_STOCK_CSV_FILE));
        converter.writeLine("sym", "date", "open", "high", "low", "close", "volume");
        converter.close();

        File csvFile = new File(META_STOCK_CSV_FILE);
        assert(csvFile.exists());
        assert(csvFile.isFile());
    }
}
