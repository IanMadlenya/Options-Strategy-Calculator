package com.starillon.ibtradetools.ui.spreadcalc;

import com.starillon.ibtradetools.calculators.options.Result;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 1/03/11
 * Time: 5:05 PM
 */
public class SpreadStrategyTableModelRow {
    private String strikeRange;
    private Result spreadResult;

    public String getStrikeRange() {
        return strikeRange;
    }

    public void setStrikeRange(String strikeRange) {
        this.strikeRange = strikeRange;
    }

    public Result getSpreadResult() {
        return spreadResult;
    }

    public void setSpreadResult(Result spreadResult) {
        this.spreadResult = spreadResult;
    }
}
