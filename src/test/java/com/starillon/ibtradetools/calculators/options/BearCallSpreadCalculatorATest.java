package com.starillon.ibtradetools.calculators.options;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 13/12/10
 * Time: 11:24 AM
 */
@Test(groups = "atomic")
public class BearCallSpreadCalculatorATest {
    private BearCallSpreadCalculator calculator;

    @BeforeTest
    public void setup() {
        calculator = new BearCallSpreadCalculator(35, 40, 6, 100);
    }

    /*
        Suppose XYZ stock is trading at $37 in June. An options trader bearish on XYZ decides to enter a bear call
        spread position by buying a JUL 40 call for $100 and selling a JUL 35 call for $300 at the same time, giving
        him a net $200 credit for entering this trade.
        The price of XYZ stock subsequently drops to $34 at expiration. As both options expire worthless, the options
        trader gets to keep the entire credit of $200 as profit.
     */
    @Test
    public void testCalcSpread() {
        Result result = calculator.calculate(.5, .25);
        assert (result.getMaxProfit().doubleValue() == .19);
        assert (result.getMaxLoss().doubleValue() == 4.81);
        assert (result.getBreakEven().doubleValue() == 35.19);
        assert (result.getMaxProfitPerContract().doubleValue() == 19);
        assert (result.getMaxLossPerContract().doubleValue() == 481);
        assert (result.getBreakEvenPerContract().doubleValue() == 3519);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalcSpreadInvalid() {
        calculator = new BearCallSpreadCalculator(40, 35, 6, 100);
    }
}
