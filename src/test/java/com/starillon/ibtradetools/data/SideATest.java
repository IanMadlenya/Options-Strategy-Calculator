package com.starillon.ibtradetools.data;

import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 6:20:29 PM
 */
@Test(groups = "atomic")
public class SideATest {
    @Test
    public void assertCorrectSide() {
        assert (Side.ASK.equals(Side.valueOf(0)));
        assert (Side.BUY.equals(Side.valueOf(1)));
        assert (Side.UNKNOWN.equals(Side.valueOf(4)));

    }
}
