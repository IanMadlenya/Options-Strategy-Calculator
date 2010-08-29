package com.starillon.ibtradetools.data;

import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 6:30:11 PM
 */
@Test(groups = "atomic")
public class OperationATest {
    @Test
    public void valeOfCorrect() {
        assert (Operation.DELETE.equals(Operation.valueOf(2)));
        assert (Operation.UPDATE.equals(Operation.valueOf(1)));
        assert (Operation.INSERT.equals(Operation.valueOf(0)));
        assert (Operation.UNKNOWN.equals(Operation.valueOf(22)));
    }
}
