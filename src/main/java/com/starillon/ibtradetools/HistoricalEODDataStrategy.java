package com.starillon.ibtradetools;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.ib.client.Contract;
import com.starillon.ibtradetools.connection.Connection;
import com.starillon.ibtradetools.connection.ConnectionFactory;
import com.starillon.ibtradetools.connection.TradeHandler;
import com.starillon.ibtradetools.contract.ASXStock;
import com.starillon.ibtradetools.dto.MarketData;

import java.util.Date;
import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:28:04 PM
 */
public class HistoricalEODDataStrategy implements TradeHandler, MarketDataStrategy
{
    @Inject
    private ConnectionFactory connectionFactory;
    private Connection connection;

    public HistoricalEODDataStrategy()
    {
        connection = connectionFactory.getConnection(this);
        // TODO Fix this
        connection.connect("", 7496);
    }

    @Override
    public void execute(Date date, String... symbols)
    {
        Contract[] contracts = createContracts(symbols);


    }

    private Contract[] createContracts(String... symbols)
    {
        List<Contract> contracts = Lists.newArrayList();

        for (String symbol : symbols)
        {
            contracts.add(new ASXStock(symbol));
        }

        return contracts.toArray(new Contract[contracts.size()]);
    }

    @Override
    public void handleHistoricalData(MarketData marketData)
    {

    }

    @Override
    public void handleError(int id, int errorCode, String errorMessage)
    {

    }
}
