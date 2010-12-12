package com.starillon.ibtradetools.calculators.options;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 10, 2010
 * Time: 1:08:51 PM
 */
@Test(groups = "atomic")
public class BullCallSpreadCalculatorATest {
    private BullCallSpreadCalculator calculator;

    /*
    An options trader believes that XYZ stock trading at $42 is going to rally soon and enters a bull call
    spread by buying a JUL 40 call for $300 and writing a JUL 45 call for $100.
    The net investment required to put on the spread is a debit of $200.
    The stock price of XYZ begins to rise and closes at $46 on expiration date.
    Both options expire in-the-money with the JUL 40 call having an intrinsic value of $600 and the JUL 45 call
    having an intrinsic value of $100. This means that the spread is now worth $500 at expiration. Since the trader
    had a debit of $200 when he bought the spread, his net profit is $300.
    If the price of XYZ had declined to $38 instead, both options expire worthless. The trader will lose his entire
    investment of $200, which is also his maximum possible loss.
     */
    @BeforeTest
    public void setup() {
        calculator = new BullCallSpreadCalculator(45, 40, 10, 100);
    }

    @Test
    public void testSpreadCalc() {
        Result result = calculator.calculate(.1, .3);
        assert (result.getBreakEven().doubleValue() == 40.3);
        assert (result.getMaxProfit().doubleValue() == 4.7);
        assert (result.getMaxLoss().doubleValue() == .3);
        assert (result.getBreakEvenPerContract().doubleValue() == 4030);
        assert (result.getMaxProfitPerContract().doubleValue() == 470);
        assert (result.getMaxLossPerContract().doubleValue() == 30);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSpreadCalcInvalid() {
        calculator = new BullCallSpreadCalculator(0, 45, 40, 1);
        calculator.calculate(.1, .3);
    }
}
