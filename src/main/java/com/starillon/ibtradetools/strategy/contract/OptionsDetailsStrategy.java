package com.starillon.ibtradetools.strategy.contract;

import com.ib.client.Contract;
import com.ib.client.ContractDetails;

import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 8, 2010
 * Time: 5:28:36 PM
 */
public interface OptionsDetailsStrategy {
    List<ContractDetails> listOptions(Contract underlying);
}
