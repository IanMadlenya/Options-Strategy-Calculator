package com.starillon.ibtradetools;

import com.ib.client.Contract;
import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.listeners.EODMarketDataListener;
import com.starillon.ibtradetools.listeners.MarketDataListener;
import com.starillon.ibtradetools.listeners.MarketDepthListener;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:48:56 PM
 */
public interface MarketDataService {
    void requestMarketData(Contract contract, boolean snapshot, MarketDataListener marketDataListener);

    void unsubscribe(MarketDataListener marketDataListener);

    void requestStockEODData(Date date, ContractDataCriteria criteria, EODMarketDataListener eodMarketDataListener);

    void unsubscribe(EODMarketDataListener eodMarketDataListener);

    void requestMarketDepth(Contract contract, int depth, MarketDepthListener marketDepthListener);

    void unsubscribe(MarketDepthListener marketDepthListener);
}
