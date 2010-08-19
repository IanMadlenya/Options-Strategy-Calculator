package com.starillon.ibtradetools.contract;


public enum DateFormat {
    FULL_TEXT(0),
    TIME_IN_MILLIS(2);

    public int getDateFormat() {
        return dateFormat;
    }

    DateFormat(int dateFormat) {
        this.dateFormat = dateFormat;
    }

    private int dateFormat;
}
