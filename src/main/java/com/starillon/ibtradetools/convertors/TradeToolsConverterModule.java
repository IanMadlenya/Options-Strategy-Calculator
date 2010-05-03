/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools.convertors;

import com.starillon.ibtradetools.BaseTradeToolsModule;

public class TradeToolsConverterModule extends BaseTradeToolsModule
{
    @Override
    protected void configure()
    {
        bind(Converter.class).to(MetaStockCSVConverter.class);
    }
}
