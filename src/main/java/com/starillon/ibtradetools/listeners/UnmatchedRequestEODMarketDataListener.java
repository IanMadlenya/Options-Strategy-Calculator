package com.starillon.ibtradetools.listeners;

import com.starillon.ibtradetools.data.EODMarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 4:20:04 PM
 */
public class UnmatchedRequestEODMarketDataListener extends BaseDataListener implements EODMarketDataListener {
    @Override
    public void handleData(EODMarketData eodMarketData) {
        logger.warning("Unmatched market data request : " + eodMarketData);
    }
}
