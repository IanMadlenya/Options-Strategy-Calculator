package com.starillon.ibtradetools.calculators.options;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 13/12/10
 * Time: 9:28 AM
 */
public class BearCallSpreadCalculator extends BaseSpreadCalculator {

    public BearCallSpreadCalculator(double shortStrike, double longStrike, double commission, long multiplier) {
        super(shortStrike, longStrike, commission, multiplier);
        checkArgument(shortStrike < longStrike, "Short strike must be lower than long strike");
    }

    @Override
    public Result calculate(double shortPremium, double longPremium) {
        BigDecimal maxProfit =
                BigDecimal.valueOf(shortPremium).subtract(BigDecimal.valueOf(longPremium)).subtract(commission);
        BigDecimal maxLoss = longStrike.subtract(shortStrike).subtract(maxProfit);
        BigDecimal breakEven = shortStrike.add(maxProfit);

        return new Result(maxProfit, maxLoss, breakEven, maxProfit.multiply(multiplier),
                maxLoss.multiply(multiplier), breakEven.multiply(multiplier));
    }
}
