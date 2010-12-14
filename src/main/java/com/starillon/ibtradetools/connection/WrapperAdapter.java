package com.starillon.ibtradetools.connection;

import com.google.inject.Inject;
import com.google.inject.internal.Lists;
import com.ib.client.*;
import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.data.MarketData;
import com.starillon.ibtradetools.data.Operation;
import com.starillon.ibtradetools.data.Side;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: Apr 25, 2010
 * Time: 2:26:09 PM
 */
class WrapperAdapter implements ConnectionHandler {
    @Inject
    private Logger logger;
    private List<TradeHandler> handlers = Lists.newArrayList();

    @Override
    public void tickPrice(int i, int i1, double v, int i2) {
    }

    @Override
    public void tickSize(int i, int i1, int i2) {
    }

    @Override
    public void tickOptionComputation(int i, int i1, double v, double v1, double v2, double v3) {
    }

    @Override
    public void tickGeneric(int i, int i1, double v) {
    }

    @Override
    public void tickString(int i, int i1, String s) {
    }

    @Override
    public void tickEFP(int i, int i1, double v, String s, double v1, int i2, String s1, double v2, double v3) {
    }

    @Override
    public void orderStatus(int i, String s, int i1, int i2, double v, int i3, int i4, double v1, int i5, String s1) {
    }

    @Override
    public void openOrder(int i, Contract contract, Order order, OrderState orderState) {
    }

    @Override
    public void openOrderEnd() {
    }

    @Override
    public void updateAccountValue(String s, String s1, String s2, String s3) {
    }

    @Override
    public void updatePortfolio(Contract contract, int i, double v, double v1, double v2, double v3, double v4, String s) {
    }

    @Override
    public void updateAccountTime(String s) {
    }

    @Override
    public void accountDownloadEnd(String s) {
    }

    @Override
    public void nextValidId(int i) {
    }

    @Override
    public void contractDetails(int requestId, ContractDetails contractDetails) {
        for (TradeHandler handler : handlers) {
            handler.contractDetails(requestId, contractDetails);
        }
    }

    @Override
    public void bondContractDetails(int i, ContractDetails contractDetails) {
    }

    @Override
    public void contractDetailsEnd(int requestId) {
        for (TradeHandler handler : handlers) {
            handler.contractDetailsEnd(requestId);
        }
    }

    @Override
    public void execDetails(int i, Contract contract, Execution execution) {
    }

    @Override
    public void execDetailsEnd(int i) {
    }

    @Override
    public void updateMktDepth(int requestId, int rowId, int operation, int side, double price, int size) {
        for (TradeHandler handler : handlers) {
            handler.updateDepth(requestId, new DepthMarketData(Side.valueOf(side), Operation.valueOf(operation),
                    rowId, price, size, null));
        }
    }

    @Override
    public void updateMktDepthL2(int requestId, int rowId, String marketMaker, int operation, int side, double price,
                                 int size) {
        for (TradeHandler handler : handlers) {
            handler.updateDepth(requestId, new DepthMarketData(Side.valueOf(side), Operation.valueOf(operation),
                    rowId, price, size, marketMaker));
        }
    }

    @Override
    public void updateNewsBulletin(int i, int i1, String s, String s1) {
    }

    @Override
    public void managedAccounts(String s) {
    }

    @Override
    public void receiveFA(int i, String s) {
    }

    @Override
    public void historicalData(int reqId, String date, double open, double high, double low, double close,
                               int volume, int count, double wap, boolean hasGaps) {
        for (TradeHandler handler : handlers) {
            handler.handleHistoricalData(reqId, new MarketData(date, open, high, low, close, volume, count, wap, hasGaps));

        }
    }

    @Override
    public void scannerParameters(String s) {
    }

    @Override
    public void scannerData(int i, int i1, ContractDetails contractDetails, String s, String s1, String s2, String s3) {
    }

    @Override
    public void scannerDataEnd(int i) {
    }

    @Override
    public void realtimeBar(int i, long l, double v, double v1, double v2, double v3, long l1, double v4, int i1) {
    }

    @Override
    public void currentTime(long l) {
    }

    @Override
    public void fundamentalData(int i, String s) {
    }

    @Override
    public void deltaNeutralValidation(int i, UnderComp underComp) {
    }

    @Override
    public void tickSnapshotEnd(int i) {
    }

    @Override
    public void error(Exception e) {
        logger.log(Level.SEVERE, "Error encountered : " + e, e);
        for (TradeHandler handler : handlers) {
            handler.handleError(0, 0, e.toString());
        }
    }

    @Override
    public void error(String s) {
        logger.log(Level.SEVERE, "Error encountered : " + s);
        for (TradeHandler handler : handlers) {
            handler.handleError(0, 0, s);
        }
    }

    @Override
    public void error(int i, int i1, String s) {
        logger.log(Level.SEVERE, "Error encountered, id : " + i + ", code : " + i1 + " mesg : " + s);
        for (TradeHandler handler : handlers) {
            handler.handleError(i, i1, s);
        }
    }

    @Override
    public void connectionClosed() {
    }

    @Override
    public void addHandler(TradeHandler handler) {
        handlers.add(handler);
    }
}
