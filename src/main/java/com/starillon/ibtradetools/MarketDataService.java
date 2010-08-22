package com.starillon.ibtradetools;

import com.starillon.ibtradetools.contract.ContractDataCriteria;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 5:48:56 PM
 */
public interface MarketDataService {
    void requestStockEODData(Date date, List<ContractDataCriteria> contracts, MarketDataListener marketDataListener);
}
