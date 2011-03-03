package com.starillon.ibtradetools.strategy.contract;

import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.internal.Lists;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandlerAdapter;
import com.starillon.ibtradetools.contract.ContractPriceComparable;
import com.starillon.ibtradetools.strategy.BaseStrategy;
import com.starillon.ibtradetools.util.RequestIdGenerator;

import java.util.Collections;
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
    private Map<Integer, List<ContractDetails>> resultsMap = Maps.newHashMap();
    private Map<Integer, Boolean> completedRequestsMap = Maps.newHashMap();
    private ContractPriceComparable contractPriceComparable;

    @Inject
    public OptionsDetailsStrategyImpl(RequestIdGenerator requestIdGenerator, ConnectionFactory connectionFactory) {
        super(requestIdGenerator, connectionFactory);
        tradeHandler = new OptionsDetailsTradeHandler();
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

        List<ContractDetails> optionList = resultsMap.remove(requestId);
        contractPriceComparable = new ContractPriceComparable();
        Collections.sort(optionList, contractPriceComparable);
        return optionList;
    }

    private Boolean isComplete(Integer requestId) {
        Boolean completed = completedRequestsMap.get(requestId);
        return completed != null && completed;
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
            logger.warning("Error getting option details for request id : " + requestId + ", code : " + errorCode +
                    " : " + errorMessage);
            completedRequestsMap.put(requestId, Boolean.TRUE);
        }
    }
}
