/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools.convertors;

import com.google.inject.AbstractModule;

public class TradeToolsConverterModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Converter.class).to(MetaStockCSVConverter.class);
    }
}
