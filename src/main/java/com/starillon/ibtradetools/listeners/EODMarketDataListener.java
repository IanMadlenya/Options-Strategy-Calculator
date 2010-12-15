package com.starillon.ibtradetools.listeners;

import com.starillon.ibtradetools.data.EODMarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 22, 2010
 * Time: 5:17:03 PM
 */
public interface EODMarketDataListener extends DataListener {
    void handleData(EODMarketData eodMarketData);
}
