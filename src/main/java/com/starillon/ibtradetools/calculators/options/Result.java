package com.starillon.ibtradetools.calculators.options;

import java.math.BigDecimal;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 10, 2010
 * Time: 12:09:01 PM
 */
public class Result {
    private final BigDecimal maxProfit;
    private final BigDecimal maxLoss;
    private final BigDecimal breakEven;
    private final BigDecimal maxProfitPerContract;
    private final BigDecimal maxLossPerContract;
    private final BigDecimal breakEvenPerContract;

    public Result(BigDecimal maxProfit, BigDecimal maxLoss, BigDecimal breakEven,
                  BigDecimal maxProfitPerContract, BigDecimal maxLossPerContract, BigDecimal breakEvenPerContract) {
        this.maxProfit = maxProfit;
        this.maxLoss = maxLoss;
        this.breakEven = breakEven;
        this.breakEvenPerContract = breakEvenPerContract;
        this.maxProfitPerContract = maxProfitPerContract;
        this.maxLossPerContract = maxLossPerContract;
    }

    public BigDecimal getMaxProfit() {
        return maxProfit;
    }

    public BigDecimal getMaxLoss() {
        return maxLoss;
    }

    public BigDecimal getBreakEven() {
        return breakEven;
    }

    public BigDecimal getMaxProfitPerContract() {
        return maxProfitPerContract;
    }

    public BigDecimal getMaxLossPerContract() {
        return maxLossPerContract;
    }

    public BigDecimal getBreakEvenPerContract() {
        return breakEvenPerContract;
    }
}
