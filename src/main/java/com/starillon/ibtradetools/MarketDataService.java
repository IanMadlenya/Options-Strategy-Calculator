package com.starillon.ibtradetools;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:48:56 PM
 */
public interface MarketDataService
{
    void requestStockEODData(Date date, String... symbols);
}
