package com.starillon.ibtradetools;

import com.ib.client.Contract;
import com.ib.client.ContractDetails;

import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 8, 2010
 * Time: 5:21:05 PM
 */
public class ContractServiceImpl implements ContractService {
    @Override
    public List<ContractDetails> listOptionsForUnderlying(Contract underlying) {
        return null;
    }
}
