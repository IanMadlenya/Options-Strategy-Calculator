package com.starillon.ibtradetools.data;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 5:25:58 PM
 */
public class DepthMarketData {
    private Side side;
    private Operation operation;
    private int position;
    private double price;
    private int size;
    private String marketMaker;

    public DepthMarketData(Side side, Operation operation, int position, double price, int size, String marketMaker) {
        this.side = side;
        this.operation = operation;
        this.position = position;
        this.price = price;
        this.size = size;
        this.marketMaker = marketMaker;
    }

    public Side getSide() {
        return side;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getPosition() {
        return position;
    }

    public double getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public String getMarketMaker() {
        return marketMaker;
    }

    @Override
    public String toString() {
        return "DepthMarketData{" +
                "side=" + side +
                ", operation=" + operation +
                ", position=" + position +
                ", price=" + price +
                ", size=" + size +
                ", marketMaker='" + marketMaker + '\'' +
                '}';
    }
}
