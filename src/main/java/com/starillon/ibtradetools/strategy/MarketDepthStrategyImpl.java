package com.starillon.ibtradetools.strategy;

import com.google.inject.Inject;
import com.ib.client.Contract;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.connection.TradeHandlerAdapter;
import com.starillon.ibtradetools.data.DepthMarketData;
import com.starillon.ibtradetools.listeners.MarketDepthListener;
import com.starillon.ibtradetools.listeners.UnmatchedMarketDepthData;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 8:13:54 PM
 */
public class MarketDepthStrategyImpl extends BaseStrategy<MarketDepthListener> implements MarketDepthStrategy {
    private final TradeHandler tradeHandler = new DepthTradeHandler();
    @Inject
    @UnmatchedMarketDepthData
    private MarketDepthListener marketDepthListener;

    @Inject
    public MarketDepthStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        initialiseConnection();
    }

    @Override
    protected TradeHandler getTradeHandler() {
        return tradeHandler;
    }

    @Override
    public void execute(Contract contract, int depth, MarketDepthListener marketDepthListener) {
        checkNotNull(contract, "Contract is null");
        checkNotNull(marketDepthListener, "MarketDepthListener is null");

        int requestId = requestIdGenerator.nextValue();
        addListener(requestId, marketDepthListener);
        getSocket().reqMktDepth(requestId, contract, depth);
    }

    @Override
    public void cancel(MarketDepthListener marketDepthListener) {
        checkNotNull(marketDepthListener, "MarketDepthListener is null");

        Integer requestId = getRequestId(marketDepthListener);
        if (requestId != null) {
            remove(requestId);
            getSocket().cancelMktDepth(requestId);
        }
    }

    @Override
    protected MarketDepthListener getUnmatchedListener() {
        return marketDepthListener;
    }

    private class DepthTradeHandler extends TradeHandlerAdapter {
        @Override
        public void updateDepth(int requestId, DepthMarketData depthMarketData) {
            getListener(requestId).handle(depthMarketData);
        }

        @Override
        public void handleError(int requestId, int errorCode, String errorMessage) {
            getListener(requestId).onError(errorCode, errorMessage);
        }
    }
}
