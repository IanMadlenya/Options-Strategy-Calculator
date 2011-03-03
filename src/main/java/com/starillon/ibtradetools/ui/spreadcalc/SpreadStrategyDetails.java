package com.starillon.ibtradetools.ui.spreadcalc;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 24/02/11
 * Time: 2:39 PM
 */
public class SpreadStrategyDetails {
    private String underlying;
    private Integer year;
    private String month;
    private Integer strikeGap;
    private SpreadStrategy strategy;

    public void setUnderlying(String underlying) {
        this.underlying = underlying;
    }

    public String getUnderlying() {
        return underlying;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setStrikeGap(Integer strikeGap) {
        this.strikeGap = strikeGap;
    }

    public Integer getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public Integer getStrikeGap() {
        return strikeGap;
    }

    public void setStrategy(SpreadStrategy strategy) {
        this.strategy = strategy;
    }

    public SpreadStrategy getStrategy() {
        return strategy;
    }
}
