package com.starillon.ibtradetools.strategy.contract;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.internal.Lists;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.connection.TradeHandlerAdapter;
import com.starillon.ibtradetools.strategy.BaseStrategy;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * <p/>
 * User: markfrench
 * Date: Dec 8, 2010
 * Time: 5:29:11 PM
 */
public class OptionsDetailsStrategyImpl extends BaseStrategy implements OptionsDetailsStrategy {
    @Inject
    private Logger logger;
    private TradeHandler tradeHandler = new OptionsDetailsTradeHandler();
    private Map<Integer, List<ContractDetails>> resultsMap = Maps.newHashMap();
    private Map<Integer, Boolean> completedRequestsMap = Maps.newHashMap();

    @Inject
    public OptionsDetailsStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        initialiseConnection();
    }

    @Override
    public List<ContractDetails> listOptions(Contract underlying) {
        checkNotNull(underlying, "Underlying contract is null");

        final Integer requestId = requestIdGenerator.nextValue();
        resultsMap.put(requestId, Lists.<ContractDetails>newArrayList());

        getSocket().reqContractDetails(requestId, underlying);

        while (!isComplete(requestId)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                logger.warning("Encountered thread interrupt exception : " + e);
            }
        }

        completedRequestsMap.remove(requestId);
        return resultsMap.remove(requestId);
    }

    private Boolean isComplete(Integer requestId) {
        Boolean completed = completedRequestsMap.get(requestId);
        return completed != null && completed;
    }

    @Override
    protected TradeHandler getTradeHandler() {
        return tradeHandler;
    }

    class OptionsDetailsTradeHandler extends TradeHandlerAdapter {
        @Override
        public void contractDetails(int requestId, ContractDetails contractDetails) {
            List<ContractDetails> details = resultsMap.get(requestId);
            checkNotNull(details, "Contract Details for request id : " + requestId + " is null");
            details.add(contractDetails);

        }

        @Override
        public void contractDetailsEnd(int requestId) {
            completedRequestsMap.put(requestId, Boolean.TRUE);
        }

        @Override
        public void handleError(int requestId, int errorCode, String errorMessage) {
            System.err.println(errorMessage);
        }
    }
}
