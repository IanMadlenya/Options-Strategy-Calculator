package com.starillon.ibtradetools;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.starillon.ibtradetools.connection.TradeToolsConnectionModule;

import java.io.IOException;
import java.util.Properties;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 6:54:56 PM
 */
public abstract class BaseTradeToolsModule extends AbstractModule
{
    private static final String IBTRADETOOLS_PROPERTIES = "/ibtradetools.properties";

    protected void loadProperties()
    {
        Properties props = new Properties();
        try
        {
            props.load(TradeToolsConnectionModule.class.getResourceAsStream(IBTRADETOOLS_PROPERTIES));
            Names.bindProperties(binder(), props);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
