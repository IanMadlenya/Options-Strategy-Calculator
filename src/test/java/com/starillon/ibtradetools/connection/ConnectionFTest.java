package com.starillon.ibtradetools.connection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.starillon.ibtradetools.dto.MarketData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 4:21:50 PM
 */
@Test (groups = "functional")
public class ConnectionFTest
{
    private Injector injector;
    private ConnectionFactory connectionFactory;

    @BeforeTest
    public void setup()
    {
        injector = Guice.createInjector(new TradeToolsConnectionModule());
    }

    @Test
    public void connection_local_success()
    {
        Connection connection = connectionFactory.getConnection(new TradeHandler()
        {
            @Override
            public void handleHistoricalData(MarketData marketData)
            {
                assert(false);
            }

            @Override
            public void handleError(int id, int errorCode, String errorMessage)
            {
                assert(false) : "Unexpected connection error : " + errorCode + " , " + errorMessage;
            }
        });

        assert (connection != null);
        connection.connect("", 7496);
        assert(connection.isConnected());
        connection.disconnect();
        assert(!connection.isConnected());
    }


    @Test
    public void connection_local_failure()
    {
        Connection connection = connectionFactory.getConnection(new TradeHandler() {
            @Override
            public void handleHistoricalData(MarketData marketData)
            {

            }

            @Override
            public void handleError(int id, int errorCode, String errorMessage)
            {
                assert (errorCode == 502) : "Incorrect error code : " + errorCode + " , " + errorMessage;
            }
        });

        assert (connection != null);
        connection.connect("", 7494);
        assert (!connection.isConnected());
    }

    @BeforeMethod
    protected void setUp() throws Exception
    {
        connectionFactory = injector.getInstance(ConnectionFactory.class);
    }
}
