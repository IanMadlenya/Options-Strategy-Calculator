package com.starillon.ibtradetools.connection;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.starillon.ibtradetools.data.MarketData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * User: mark
 * Date: May 3, 2010
 * Time: 4:21:50 PM
 */
@Test(groups = "functional")
public class ConnectionFTest {
    private ConnectionFactory connectionFactory;


    @Test
    public void connection_local_success() {
        Connection connection = connectionFactory.getConnection(new TradeHandler() {

            @Override
            public void handleHistoricalData(int id, MarketData marketData) {
                assert (false);
            }

            @Override
            public void handleError(int id, int errorCode, String errorMessage) {
                assert (false) : "Unexpected connection error : " + errorCode + " , " + errorMessage;
            }
        });

        assert (connection != null);
        connection.connect();
        assert (connection.isConnected());
        connection.disconnect();
        assert (!connection.isConnected());
    }


    @Test
    public void connection_local_failure() {
        Connection connection = connectionFactory.getConnection(new TradeHandler() {
            @Override
            public void handleHistoricalData(int id, MarketData marketData) {

            }

            @Override
            public void handleError(int id, int errorCode, String errorMessage) {
                assert (errorCode == 502) : "Incorrect error code : " + errorCode + " , " + errorMessage;
            }
        });

        assert (connection != null);
        connection.connect("", 9999);
        assert (!connection.isConnected());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void connection_local_noHandler() {
        connectionFactory.getConnection(null);
    }


    @BeforeMethod
    protected void setUp() throws Exception {
        Injector injector = Guice.createInjector(new TradeToolsConnectionModule());
        connectionFactory = injector.getInstance(ConnectionFactory.class);
    }
}
