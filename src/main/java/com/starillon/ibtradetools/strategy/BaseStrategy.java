package com.starillon.ibtradetools.strategy;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.ib.client.EClientSocket;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Sep 5, 2010
 * Time: 5:08:12 PM
 */
public abstract class BaseStrategy<L> {
    @Inject
    protected Logger logger;
    protected RequestIdGenerator requestIdGenerator;
    private ConnectionFactory connectionFactory;
    ;
    private Connection connection;
    private final Map<Integer, L> listenerRequests;

    public BaseStrategy(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        this.requestIdGenerator = requestIdGenerator;
        this.connectionFactory = connectionFactory;
        listenerRequests = Maps.newHashMap();
    }

    protected void initialiseConnection() {
        connection = connectionFactory.getConnection(getTradeHandler());
        connection.connect();
    }

    protected EClientSocket getSocket() {
        assert (connection.isConnected()) : "Connection not established";
        return connection.getSocket();
    }

    protected Integer getRequestId(L listener) {
        Integer result = null;
        for (Integer requestId : listenerRequests.keySet()) {
            if (listenerRequests.get(requestId).equals(listener)) {
                result = requestId;
                break;
            }
        }

        return result;
    }

    protected void addListener(Integer requestId, L listener) {
        listenerRequests.put(requestId, listener);
    }

    protected L remove(Integer requestId) {
        return listenerRequests.remove(requestId);
    }

    protected L getListener(Integer requestId) {
        return listenerRequests.get(requestId);
    }

    private L getListener(int id) {
        L listener = listenerRequests.get(id);

        if (listener == null && id != -1) {
            logger.warning("Unmatched marker data listener for request id " + id);
            listener = getUnmatchedListener();
        } else {
            logger.info("Ignore request for listener with id : " + id);
        }

        return listener;
    }

    protected abstract TradeHandler getTradeHandler();

    protected abstract L getUnmatchedListener();
}
