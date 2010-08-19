package com.starillon.ibtradetools.contract;

public enum BarSize {
    ONE_SEC("1 sec"),
    FIVE_SEC("5 secs"),
    FIFTEEN_SEC("15 secs"),
    THIRTY_SEC("30 secs"),
    ONE_MIN("1 min"),
    TWO_MIN("2 mins"),
    THREE_MIN("3 mins"),
    FIVE_MIN("5 mins"),
    FIFTEEN_MIN("15 mins"),
    THIRTY_MIN("30 mins"),
    ONE_HOUR("1 hour"),
    ONE_DAY("1 day"),
    ONE_WEEK("1 week"),
    ONE_MONTH("1 month"),
    THREE_MONTH("3 months"),
    ONE_YEAR("1 year");


    @Override
    public String toString() {
        return barSize;
    }

    BarSize(String barSize) {
        this.barSize = barSize;
    }

    private final String barSize;
}
