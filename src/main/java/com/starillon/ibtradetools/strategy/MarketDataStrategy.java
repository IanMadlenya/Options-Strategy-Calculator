package com.starillon.ibtradetools.strategy;

import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.listeners.MarketDataListener;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:10:32 PM
 */
public interface MarketDataStrategy {

    void execute(Date date, ContractDataCriteria criteria, MarketDataListener marketDataListener);

    void cancel(MarketDataListener marketDataListener);
}
