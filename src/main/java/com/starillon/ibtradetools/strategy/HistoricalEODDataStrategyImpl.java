package com.starillon.ibtradetools.strategy;

import com.google.inject.Inject;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.connection.TradeHandlerAdapter;
import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.data.MarketData;
import com.starillon.ibtradetools.listeners.MarketDataListener;
import com.starillon.ibtradetools.listeners.UnmatchedMarketData;
import com.starillon.ibtradetools.util.DateConverter;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategyImpl extends BaseStrategy<MarketDataListener> implements MarketDataStrategy {
    private static final int HIST_DATA_SERV_CONNECTED = 2106;
    private final TradeHandler tradeHandler = new HistoricTradeHandler();
    @Inject
    @UnmatchedMarketData
    private MarketDataListener unmatchedRequestListener;

    @Inject
    public HistoricalEODDataStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        initialiseConnection();
    }

    @Override
    public void execute(Date date, ContractDataCriteria criteria, MarketDataListener marketDataListener) {
        checkNotNull(date, "date is null");
        checkNotNull(criteria, "criteria is null");
        checkNotNull(marketDataListener, "marketDataListener is null");

        Integer requestId = requestIdGenerator.nextValue();
        addListener(requestId, marketDataListener);

        getSocket().reqHistoricalData(requestId, criteria.getContract(),
                DateConverter.convert(date), criteria.getDuration(), criteria.getBarSize(),
                criteria.getMarketDataType(), criteria.getRegularTradingHours(),
                criteria.getDateFormat());

    }

    @Override
    public void cancel(MarketDataListener marketDataListener) {
        checkNotNull(marketDataListener, "marketDataListener is null");

        Integer requestId = getRequestId(marketDataListener);
        if (requestId != null) {
            getSocket().cancelHistoricalData(requestId);
            remove(requestId);
        }
    }


    @Override
    protected MarketDataListener getUnmatchedListener() {
        return unmatchedRequestListener;
    }

    @Override
    protected TradeHandler getTradeHandler() {
        return tradeHandler;
    }

    private boolean isWarning(int errorCode) {
        return errorCode == HIST_DATA_SERV_CONNECTED;
    }


    class HistoricTradeHandler extends TradeHandlerAdapter {
        @Override
        public void handleHistoricalData(int id, MarketData marketData) {
            getListener(id).handleData(marketData);
        }

        @Override
        public void handleError(int id, int errorCode, String errorMessage) {
            if (!isWarning(errorCode)) {
                getListener(id).onError(errorCode, errorMessage);
            } else {
                logger.warning("Encountered warning code : " + errorCode + " , mesg: " + errorMessage);
            }
        }
    }
}
