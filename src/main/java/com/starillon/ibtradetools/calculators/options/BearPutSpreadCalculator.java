package com.starillon.ibtradetools.calculators.options;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 13/12/10
 * Time: 11:46 AM
 */
public class BearPutSpreadCalculator extends BaseSpreadCalculator {
    public BearPutSpreadCalculator(double shortStrike, double longStrike, double commission, long multiplier) {
        super(shortStrike, longStrike, commission, multiplier);
        checkArgument(longStrike > shortStrike, "Long strike must be higher than the short strike");
    }

    @Override
    public Result calculate(double shortPremium, double longPremium) {
        BigDecimal maxLoss =
                BigDecimal.valueOf(longPremium).subtract(BigDecimal.valueOf(shortPremium)).subtract(commission);
        BigDecimal maxProfit = longStrike.subtract(shortStrike).subtract(maxLoss);
        BigDecimal breakEven = longStrike.subtract(maxLoss);

        return new Result(maxProfit, maxLoss, breakEven, maxProfit.multiply(multiplier), maxLoss.multiply(multiplier),
                breakEven.multiply(multiplier));
    }
}
