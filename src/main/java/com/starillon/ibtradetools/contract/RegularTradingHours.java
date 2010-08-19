package com.starillon.ibtradetools.contract;

public enum RegularTradingHours {
    REGULAR(0),
    OUTSIDE(1);

    public int getRegularHours() {
        return regularHours;
    }

    RegularTradingHours(int regularHours) {
        this.regularHours = regularHours;
    }

    private final int regularHours;
}
