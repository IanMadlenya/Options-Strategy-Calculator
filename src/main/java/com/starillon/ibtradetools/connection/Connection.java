package com.starillon.ibtradetools.connection;

import com.ib.client.EClientSocket;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:05:10 PM
 */
public interface Connection {
    void connect();

    void connect(String host, int port);

    boolean isConnected();

    void disconnect();

    EClientSocket getSocket();
}
