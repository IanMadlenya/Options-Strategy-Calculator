package com.starillon.ibtradetools.calculators.options;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 10, 2010
 * Time: 2:59:37 PM
 */
public abstract class BaseSpreadCalculator {
    protected final BigDecimal shortStrike;
    protected final BigDecimal longStrike;
    protected final BigDecimal commission;
    protected final BigDecimal spread;
    protected final BigDecimal multiplier;

    public BaseSpreadCalculator(double shortStrike, double longStrike, double commission, long multiplier) {
        checkArgument(multiplier > 0, "Multiplier must be greater than zero");
        this.shortStrike = BigDecimal.valueOf(shortStrike);
        this.longStrike = BigDecimal.valueOf(longStrike);
        this.commission = BigDecimal.valueOf(commission).divide(BigDecimal.valueOf(multiplier));
        spread = this.shortStrike.subtract(this.longStrike);
        this.multiplier = BigDecimal.valueOf(multiplier);
    }

    public abstract Result calculate(double shortPremium, double longPremium);
}
