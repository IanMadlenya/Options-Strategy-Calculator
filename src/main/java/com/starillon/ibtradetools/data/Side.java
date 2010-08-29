package com.starillon.ibtradetools.data;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 6:04:12 PM
 */
public enum Side {
    UNKNOWN(-1),
    ASK(0),
    BUY(1);

    public static Side valueOf(int side) {
        return (side == ASK.side) ? ASK : (side == BUY.side) ? BUY : UNKNOWN;
    }

    Side(int side) {
        this.side = side;
    }


    private int side;

}
