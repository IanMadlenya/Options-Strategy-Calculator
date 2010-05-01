package com.starillon.ibtradetools.connection;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:03:54 PM
 */
public interface ConnectionFactory
{
    Connection getConnection(final TradeHandler handler);
}
