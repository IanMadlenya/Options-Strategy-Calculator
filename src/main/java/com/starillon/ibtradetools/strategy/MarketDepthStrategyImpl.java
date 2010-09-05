package com.starillon.ibtradetools.strategy;

import com.google.inject.Inject;
import com.ib.client.Contract;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.listeners.MarketDepthListener;
import com.starillon.ibtradetools.util.RequestIdGenerator;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Aug 29, 2010
 * Time: 8:13:54 PM
 */
public class MarketDepthStrategyImpl extends BaseStrategy implements MarketDepthStrategy {

    @Inject
    public MarketDepthStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
    }

    @Override
    protected TradeHandler getTradeHandler() {
        return null;
    }

    @Override
    public void execute(Contract contract, int depth, MarketDepthListener marketDepthListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void cancel(MarketDepthListener marketDepthListener) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
