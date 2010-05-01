package com.starillon.ibtradetools;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:10:32 PM
 */
public interface MarketDataStrategy
{

    void execute(Date date, String... symbols);
}
