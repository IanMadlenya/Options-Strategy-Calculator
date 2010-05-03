package com.starillon.ibtradetools.connection;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.ib.client.EWrapper;

import java.io.IOException;
import java.util.Properties;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:15:09 PM
 */
public class TradeToolsConnectionModule extends AbstractModule
{
    private static final String IBTRADETOOLS_PROPERTIES = "/ibtradetools.properties";

    @Override
    protected void configure()
    {
        loadProperties();
        bind(ConnectionFactory.class).to(ConnectionFactoryImpl.class);
        bind(ConnectionHandler.class).to(WrapperAdapter.class);
    }

    private void loadProperties()
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
