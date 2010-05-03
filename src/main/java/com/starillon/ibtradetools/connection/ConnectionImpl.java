package com.starillon.ibtradetools.connection;

import com.google.inject.Inject;
import com.ib.client.EClientSocket;
import com.starillon.ibtradetools.TradeException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:09:47 PM
 */
public class ConnectionImpl implements Connection
{
    private final ConnectionHandler handler;
    private final EClientSocket connection;
    private final int clientId = System.identityHashCode(this);

    public ConnectionImpl(ConnectionHandler handler, TradeHandler tradeHandler)
    {
        this.handler = handler;
        connection = new EClientSocket(this.handler);
        this.handler.setHandler(tradeHandler);
    }

    @Override
    public void connect(String host, int port)
    {
        checkNotNull(host, "host cannot be null");
        if (connection.isConnected())
        {
            throw new TradeException("Already connected");
        }

        connection.eConnect(host, port, clientId);
    }

    @Override
    public boolean isConnected()
    {
        return connection.isConnected();
    }


    @Override
    public void disconnect()
    {
        if (connection.isConnected())
        {
            connection.eDisconnect();
        }
    }
}
