package com.starillon.ibtradetools.calculators.options;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 10, 2010
 * Time: 2:59:06 PM
 */
public class BullPutSpreadCalculator extends BaseSpreadCalculator {
    public BullPutSpreadCalculator(double shortStrike, double longStrike, double commission, long multiplier) {
        super(shortStrike, longStrike, commission, multiplier);
        checkArgument(this.shortStrike.max(this.longStrike).equals(this.shortStrike), "Short strike must be higher then long");
    }

    @Override
    public Result calculate(double shortPremium, double longPremium) {
        BigDecimal maxProfit =
                BigDecimal.valueOf(shortPremium).subtract(BigDecimal.valueOf(longPremium)).subtract(commission);
        BigDecimal maxLoss = shortStrike.subtract(longStrike).subtract(maxProfit);
        BigDecimal breakEven = shortStrike.subtract(maxProfit);
        return new Result(maxProfit, maxLoss, breakEven, maxProfit.multiply(multiplier), maxLoss.multiply(multiplier),
                breakEven.multiply(multiplier));
    }
}
