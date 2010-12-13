package com.starillon.ibtradetools.calculators.options;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 13/12/10
 * Time: 11:57 AM
 */
@Test(groups = "atomic")
public class BearPutSpreadCalculatorATest {
    private BearPutSpreadCalculator calculator;

    @BeforeTest
    public void setup() {
        calculator = new BearPutSpreadCalculator(35, 40, 6, 100);
    }

    /*
        Suppose XYZ stock is trading at $38 in June. An options trader bearish on XYZ decides to enter a bear put
        spread position by buying a JUL 40 put for $300 and sell a JUL 35 put for $100 at the same time, resulting
        in a net debit of $200 for entering this position.

        The price of XYZ stock subsequently drops to $34 at expiration. Both puts expire in-the-money with the
        JUL 40 call bought having $600 in intrinsic value and the JUL 35 call sold having $100 in intrinsic value.
        The spread would then have a net value of $5 (the difference in strike price). Deducting the debit taken when
        he placed the trade, his net profit is $300. This is also his maximum possible profit.
     */
    @Test
    public void testSpreadCalc() {
        Result result = calculator.calculate(.1, .32);
        assert (result.getMaxProfit().doubleValue() == 4.84);
        assert (result.getMaxLoss().doubleValue() == .16);
        assert (result.getBreakEven().doubleValue() == 39.84);
        assert (result.getMaxProfitPerContract().doubleValue() == 484);
        assert (result.getMaxLossPerContract().doubleValue() == 16);
        assert (result.getBreakEvenPerContract().doubleValue() == 3984);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSpreadCalcInvalid() {
        calculator = new BearPutSpreadCalculator(40, 25, 6, 100);
    }
}
