package com.starillon.ibtradetools.connection;

import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.data.EODMarketData;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:39:53 PM
 */
public interface TradeHandler {
    void handleHistoricalData(int requestId, EODMarketData eodMarketData);

    void handleError(int requestId, int errorCode, String errorMessage);

    void updateDepth(int requestId, DepthMarketData depthMarketData);

    void contractDetails(int requestId, ContractDetails contractDetails);

    void contractDetailsEnd(int requestId);

    void handlePrice(int requestId, int fieldId, double price, int canAutoExecute);

    void handleSize(int requestId, int fieldId, int size);

    void handleOptionData(int requestId, int fieldId, double impliedVolatility, double delta, double modelPrice,
                          double pvDividend);
}
