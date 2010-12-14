package com.starillon.ibtradetools;

import com.google.inject.Inject;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.strategy.contract.OptionsDetailsStrategy;

import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 8, 2010
 * Time: 5:21:05 PM
 */
public class ContractServiceImpl implements ContractService {
    @Inject
    private OptionsDetailsStrategy optionDetailsStrategy;

    @Override
    public List<ContractDetails> listOptionsForUnderlying(Contract underlying) {
        return optionDetailsStrategy.listOptions(underlying);
    }
}
