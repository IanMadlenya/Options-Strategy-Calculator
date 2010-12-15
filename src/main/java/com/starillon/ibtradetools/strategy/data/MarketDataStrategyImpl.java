package com.starillon.ibtradetools.strategy.data;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.ib.client.Contract;
import com.ib.client.TickType;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandlerAdapter;
import com.starillon.ibtradetools.data.MarketData;
import com.starillon.ibtradetools.listeners.MarketDataListener;
import com.starillon.ibtradetools.listeners.UnmatchedMarketDataListener;
import com.starillon.ibtradetools.strategy.BaseListenerStrategy;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 15/12/10
 * Time: 12:21 PM
 */
public class MarketDataStrategyImpl extends BaseListenerStrategy<MarketDataListener> implements MarketDataStrategy {
    private static final String GENERIC_TICKLIST = "104, 106";
    @Inject
    private UnmatchedMarketDataListener listener;

    private Map<Integer, MarketData> marketDataMap = Maps.newHashMap();


    @Inject
    public MarketDataStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        tradeHandler = new MarketDataTradeHandler();
        initialiseConnection();
    }

    @Override
    protected MarketDataListener getUnmatchedListener() {
        return listener;
    }

    @Override
    public void execute(Contract contract, boolean snapshot, MarketDataListener listener) {
        checkNotNull(contract, "Contract is null");
        checkNotNull(listener, "MarketDataListener is null");

        Integer requestId = requestIdGenerator.nextValue();
        addListener(requestId, listener);
        marketDataMap.put(requestId, new MarketData());

        getSocket().reqMktData(requestId, contract, GENERIC_TICKLIST, snapshot);
    }

    @Override
    public void cancel(MarketDataListener listener) {
        checkNotNull(listener, "MarketDataListener is null");

        Integer requestId = getRequestId(listener);
        if (requestId != null) {
            remove(requestId);
            marketDataMap.remove(requestId);
            getSocket().cancelMktData(requestId);
        }
    }

    class MarketDataTradeHandler extends TradeHandlerAdapter {
        private final MarketData marketData = new MarketData();

        @Override
        public void handleError(int requestId, int errorCode, String errorMessage) {
            getListener(requestId).onError(errorCode, errorMessage);
        }

        @Override
        public void handlePrice(int requestId, int fieldId, double price, int canAutoExecute) {
            MarketData data = getMarketData(requestId, fieldId);
            if (data != null) {
                if (fieldId == TickType.BID) {
                    data.setBid(price);
                } else if (fieldId == TickType.ASK) {
                    data.setAsk(price);
                } else if (fieldId == TickType.LAST) {
                    data.setLast(price);
                } else if (fieldId == TickType.HIGH) {
                    data.setHigh(price);
                } else if (fieldId == TickType.LOW) {
                    data.setLow(price);
                } else if (fieldId == TickType.CLOSE) {
                    data.setClose(price);
                } else {
                    logger.severe("Unsupported field : " + fieldId + " = " + TickType.getField(fieldId));
                }

                getListener(requestId).handle(data);
            }
        }

        @Override
        public void handleSize(int requestId, int fieldId, int size) {
            MarketData data = getMarketData(requestId, fieldId);
            if (data != null) {
                if (fieldId == TickType.BID_SIZE) {
                    data.setBidSize(size);
                } else if (fieldId == TickType.ASK_SIZE) {
                    data.setAskSize(size);
                } else if (fieldId == TickType.LAST_SIZE) {
                    data.setLastSize(size);
                } else if (fieldId == TickType.VOLUME) {
                    data.setVolume(size);
                } else {
                    logger.severe("Unsupported field : " + fieldId + " = " + TickType.getField(fieldId));
                }

                getListener(requestId).handle(data);
            }
        }

        @Override
        public void handleOptionData(int requestId, int fieldId, double impliedVolatility, double delta, double modelPrice, double pvDividend) {
            MarketData data = getMarketData(requestId, fieldId);
            if (data != null) {
                logger.info("Option field  : " + fieldId + " = " + TickType.getField(fieldId));
                data.setImpliedVolatility(impliedVolatility);
                data.setDelta(delta);
                data.setModelPrice(modelPrice);
                data.setDividend(pvDividend);
            }
        }

        private MarketData getMarketData(int requestId, int fieldId) {
            MarketData data = marketDataMap.get(requestId);
            if (data == null) {
                logger.severe("Request id doesn't have matching market data record : " + requestId
                        + ",field : " + fieldId + " = " + TickType.getField(fieldId));
            }
            return data;
        }
    }
}
