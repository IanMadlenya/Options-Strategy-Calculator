package com.starillon.ibtradetools.calculators.options;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 10, 2010
 * Time: 12:06:16 PM
 */
public class BullCallSpreadCalculator extends BaseSpreadCalculator {

    public BullCallSpreadCalculator(double shortStrike, double longStrike, double commission, long multiplier) {
        super(shortStrike, longStrike, commission, multiplier);
        checkArgument(this.longStrike.min(this.shortStrike).compareTo(this.longStrike) == 0, "Short strike must be higher then Long.");
    }

    public Result calculate(double shortPremium, double longPremium) {
        BigDecimal maxLoss = commission.add(BigDecimal.valueOf(longPremium).subtract(BigDecimal.valueOf(shortPremium)));
        BigDecimal maxProfit = (spread.subtract(maxLoss));
        BigDecimal breakEven = longStrike.add(maxLoss);

        return new Result(maxProfit, maxLoss, breakEven, maxProfit.multiply(multiplier), maxLoss.multiply(multiplier),
                breakEven.multiply(multiplier));
    }

}
