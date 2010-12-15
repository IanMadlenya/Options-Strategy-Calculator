package com.starillon.ibtradetools.strategy.data;

import com.google.inject.Inject;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandlerAdapter;
import com.starillon.ibtradetools.contract.ContractDataCriteria;
import com.starillon.ibtradetools.data.EODMarketData;
import com.starillon.ibtradetools.listeners.EODMarketDataListener;
import com.starillon.ibtradetools.listeners.UnmatchedEODMarketData;
import com.starillon.ibtradetools.strategy.BaseListenerStrategy;
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
public class HistoricalEODDataStrategyImpl extends BaseListenerStrategy<EODMarketDataListener> implements EODMarketDataStrategy {
    private static final int HIST_DATA_SERV_CONNECTED = 2106;
    @Inject
    @UnmatchedEODMarketData
    private EODMarketDataListener unmatchedEODRequestListener;

    @Inject
    public HistoricalEODDataStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        tradeHandler = new HistoricTradeHandler();
        initialiseConnection();
    }

    @Override
    public void execute(Date date, ContractDataCriteria criteria, EODMarketDataListener eodMarketDataListener) {
        checkNotNull(date, "date is null");
        checkNotNull(criteria, "criteria is null");
        checkNotNull(eodMarketDataListener, "eodMarketDataListener is null");

        Integer requestId = requestIdGenerator.nextValue();
        addListener(requestId, eodMarketDataListener);

        getSocket().reqHistoricalData(requestId, criteria.getContract(),
                DateConverter.convert(date), criteria.getDuration(), criteria.getBarSize(),
                criteria.getMarketDataType(), criteria.getRegularTradingHours(),
                criteria.getDateFormat());

    }

    @Override
    public void cancel(EODMarketDataListener eodMarketDataListener) {
        checkNotNull(eodMarketDataListener, "eodMarketDataListener is null");

        Integer requestId = getRequestId(eodMarketDataListener);
        if (requestId != null) {
            getSocket().cancelHistoricalData(requestId);
            remove(requestId);
        }
    }


    @Override
    protected EODMarketDataListener getUnmatchedListener() {
        return unmatchedEODRequestListener;
    }


    private boolean isWarning(int errorCode) {
        return errorCode == HIST_DATA_SERV_CONNECTED;
    }


    class HistoricTradeHandler extends TradeHandlerAdapter {
        @Override
        public void handleHistoricalData(int id, EODMarketData eodMarketData) {
            getListener(id).handleData(eodMarketData);
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
