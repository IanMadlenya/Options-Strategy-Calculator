package com.starillon.ibtradetools.data;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 5:25:58 PM
 */
public class DepthMarketData {
    Side side;
    Operation operation;
    int position;
    double price;
    int size;

    public DepthMarketData(Side side, Operation operation, int position, double price, int size) {
        this.side = side;
        this.operation = operation;
        this.position = position;
        this.price = price;
        this.size = size;
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
}
