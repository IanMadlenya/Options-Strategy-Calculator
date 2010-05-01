package com.starillon.ibtradetools.dto;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: Apr 25, 2010
 * Time: 3:51:42 PM
 */
public class MarketData
{
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private int volume;
    private int count;
    double wap;
    private boolean hasGaps;

    public MarketData(String date, double open, double high, double low, double close, int volume, int count, 
                      double wap, boolean hasGaps)
    {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.count = count;
        this.wap = wap;
        this.hasGaps = hasGaps;
    }

    public String getDate()
    {
        return date;
    }

    public double getOpen()
    {
        return open;
    }

    public double getHigh()
    {
        return high;
    }

    public double getLow()
    {
        return low;
    }

    public double getClose()
    {
        return close;
    }

    public int getVolume()
    {
        return volume;
    }

    public int getCount()
    {
        return count;
    }

    public double getWap()
    {
        return wap;
    }

    public boolean isHasGaps()
    {
        return hasGaps;
    }
}
