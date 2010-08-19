package com.starillon.ibtradetools.contract;

public enum Duration {
    SECONDS("S"),
    DAYS("D"),
    WEEKS("W"),
    MONTHS("M"),
    YEARS("Y");

    @Override
    public String toString() {
        return duration;
    }

    Duration(String duration) {
        this.duration = duration;
    }

    private final String duration;
}
