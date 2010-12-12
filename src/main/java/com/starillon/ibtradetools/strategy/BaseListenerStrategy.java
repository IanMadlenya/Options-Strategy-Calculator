package com.starillon.ibtradetools.strategy;

import com.google.common.collect.Maps;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.Map;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 8, 2010
 * Time: 5:37:15 PM
 */
public abstract class BaseListenerStrategy<L> extends BaseStrategy {
    private final Map<Integer, L> listenerRequests;

    protected BaseListenerStrategy(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        listenerRequests = Maps.newHashMap();
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
        L listener = listenerRequests.get(requestId);

        if (listener == null) {
            logger.warning("Unmatched marker data listener for request id " + requestId);
            listener = getUnmatchedListener();
        }

        return listener;
    }


    protected abstract L getUnmatchedListener();
}
