package com.starillon.ibtradetools.connection;

import com.ib.client.EWrapper;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 4:33:56 PM
 */
public interface ConnectionHandler extends EWrapper {
    void addHandler(TradeHandler handler);
}
