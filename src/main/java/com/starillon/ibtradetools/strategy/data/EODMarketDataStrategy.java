package com.starillon.ibtradetools.strategy.data;

import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.listeners.EODMarketDataListener;

import java.util.Date;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:10:32 PM
 */
public interface EODMarketDataStrategy {

    void execute(Date date, ContractDataCriteria criteria, EODMarketDataListener eodMarketDataListener);

    void cancel(EODMarketDataListener eodMarketDataListener);
}
