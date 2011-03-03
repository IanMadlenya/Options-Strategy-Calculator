package com.starillon.ibtradetools.ui.spreadcalc;

import com.starillon.ibtradetools.contract.ContractConstants;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 3/03/11
 * Time: 1:39 PM
 */
public enum SpreadStrategy {
    BEAR_PUT_SPREAD("Bear Put Spread", ContractConstants.PUT),
    BEAR_CALL_SPREAD("Bear Call Spread", ContractConstants.CALL),
    BULL_CALL_SPREAD("Bull Call Spread", ContractConstants.CALL),
    BULL_PUT_SPREAD("Bull Put Spread", ContractConstants.PUT);


    SpreadStrategy(String strategy, String optionType) {
        this.strategy = strategy;
        this.optionType = optionType;
    }

    private String strategy;
    private String optionType;

    public String getOptionType() {
        return optionType;
    }

    @Override
    public String toString() {
        return strategy;
    }
}
