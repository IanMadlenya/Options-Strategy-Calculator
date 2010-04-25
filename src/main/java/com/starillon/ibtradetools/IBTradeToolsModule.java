/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.starillon.ibtradetools.convertors.Converter;
import com.starillon.ibtradetools.convertors.MetaStockCSVConverter;

public class IBTradeToolsModule extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Converter.class).to(MetaStockCSVConverter.class);
    }
}
