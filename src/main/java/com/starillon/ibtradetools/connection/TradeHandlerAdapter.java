package com.starillon.ibtradetools.connection;

import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.data.EODMarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 5, 2010
 * Time: 5:28:04 PM
 */
public class TradeHandlerAdapter implements TradeHandler {
    @Override
    public void handleHistoricalData(int requestId, EODMarketData eodMarketData) {
    }

    @Override
    public void handleError(int requestId, int errorCode, String errorMessage) {
    }

    @Override
    public void updateDepth(int requestId, DepthMarketData depthMarketData) {
    }

    @Override
    public void contractDetails(int requestId, ContractDetails contractDetails) {
    }

    @Override
    public void contractDetailsEnd(int requestId) {
    }

    @Override
    public void handlePrice(int requestId, int fieldId, double price, int canAutoExecute) {
    }

    @Override
    public void handleSize(int requestId, int fieldId, int size) {
    }

    @Override
    public void handleOptionData(int requestId, int fieldId, double impliedVolatility, double delta, double modelPrice,
                                 double pvDividend) {
    }
}
