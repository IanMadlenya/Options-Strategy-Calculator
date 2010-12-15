package com.starillon.ibtradetools.connection;

import com.ib.client.EClientSocket;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:09:47 PM
 */
public class ConnectionImpl implements Connection {
    private final ConnectionHandler handler;
    private final EClientSocket connection;
    private final String host;
    private final int port;
    private final int clientId = System.identityHashCode(this);

    public ConnectionImpl(ConnectionHandler handler, TradeHandler tradeHandler, String host, int port) {
        this(handler, host, port);
        this.handler.addHandler(tradeHandler);
    }

    public ConnectionImpl(ConnectionHandler handler, String host, int port) {
        this.host = host;
        this.port = port;
        this.handler = handler;
        connection = new EClientSocket(this.handler);
    }

    public void addTradHandler(TradeHandler tradeHandler) {
        handler.addHandler(tradeHandler);
    }

    @Override
    public void connect() {
        if (!connection.isConnected()) {
            connection.eConnect(host, port, clientId);
        }
    }

    @Override
    public void connect(String host, int port) {
        if (!connection.isConnected()) {
            connection.eConnect(host, port, clientId);
        }
    }

    @Override
    public boolean isConnected() {
        return connection.isConnected();
    }

    @Override
    public void disconnect() {
        if (connection.isConnected()) {
            connection.eDisconnect();
        }
    }

    @Override
    public EClientSocket getSocket() {
        return connection;
    }
}
