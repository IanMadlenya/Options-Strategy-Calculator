package com.starillon.ibtradetools.data;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 11:33 AM
 */
public class MarketData {
    private double bid;
    private long bidSize;
    private double ask;
    private long askSize;
    private double last;
    private long lastSize;
    private long volume;
    private double high;
    private double low;
    private double close;
    private double impliedVolatility;
    private double delta;
    private double modelPrice;
    private double dividend;

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public long getBidSize() {
        return bidSize;
    }

    public void setBidSize(long bidSize) {
        this.bidSize = bidSize;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public long getAskSize() {
        return askSize;
    }

    public void setAskSize(long askSize) {
        this.askSize = askSize;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public long getLastSize() {
        return lastSize;
    }

    public void setLastSize(long lastSize) {
        this.lastSize = lastSize;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getImpliedVolatility() {
        return impliedVolatility;
    }

    public void setImpliedVolatility(double impliedVolatility) {
        this.impliedVolatility = impliedVolatility;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(double modelPrice) {
        this.modelPrice = modelPrice;
    }

    public double getDividend() {
        return dividend;
    }

    public void setDividend(double dividend) {
        this.dividend = dividend;
    }

    @Override
    public String toString() {
        return "MarketData{" +
                "bid=" + bid +
                ", bidSize=" + bidSize +
                ", ask=" + ask +
                ", askSize=" + askSize +
                ", last=" + last +
                ", lastSize=" + lastSize +
                ", volume=" + volume +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", impliedVolatility=" + impliedVolatility +
                ", delta=" + delta +
                ", modelPrice=" + modelPrice +
                ", dividend=" + dividend +
                '}';
    }
}
