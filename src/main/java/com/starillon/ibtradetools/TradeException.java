package com.starillon.ibtradetools;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 4:25:44 PM
 */
public class TradeException extends RuntimeException
{
    public TradeException(String message)
    {
        super(message);
    }

    public TradeException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
