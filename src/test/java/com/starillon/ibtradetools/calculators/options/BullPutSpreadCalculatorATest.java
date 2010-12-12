package com.starillon.ibtradetools.calculators.options;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 10/12/10
 * Time: 6:32 PM
 */
@Test(groups = "atomic")
public class BullPutSpreadCalculatorATest {
    private BullPutSpreadCalculator calculator;

    @BeforeTest
    public void setup() {
        calculator = new BullPutSpreadCalculator(45, 40, 10, 100);
    }

    /*
       An options trader believes that XYZ stock trading at $43 is going to rally soon and enters a bull put spread
       by buying a JUL 40 put for $100 and writing a JUL 45 put for $300. Thus, the trader receives a net credit of
       $200 when entering the spread position.
       The stock price of XYZ begins to rise and closes at $46 on expiration date. Both options expire worthless and
       the options trader keeps the entire credit of $200 as profit, which is also the maximum profit possible.
    */
    @Test
    public void testSpreadCalc() {
        Result result = calculator.calculate(.3, .1);
        assert (result.getMaxProfit().doubleValue() == .1);
        assert (result.getBreakEven().doubleValue() == 44.9);
        assert (result.getMaxLoss().doubleValue() == 4.9);
        assert (result.getMaxProfitPerContract().doubleValue() == 10);
        assert (result.getBreakEvenPerContract().doubleValue() == 4490);
        assert (result.getMaxLossPerContract().doubleValue() == 490);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSpreadCalcInvalid() {
        calculator = new BullPutSpreadCalculator(40, 45, 0, 1);
    }
}
