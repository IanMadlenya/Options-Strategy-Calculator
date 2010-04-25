/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools.convertors;

import static com.google.common.base.Preconditions.checkNotNull;

public abstract class BaseConverter implements Converter
{
    public void writeLine(String symbol, String date, String open, String high, String low, String close, String volume)
    {
        checkNotNull(symbol, "symbol");
        checkNotNull(date, "date");
        checkNotNull(open, "open");
        checkNotNull(high, "high");
        checkNotNull(low, "low");
        checkNotNull(close, "close");
        checkNotNull(volume, "volume");
        doWriteLine(symbol, date, open, high, low, close, volume);
    }

    protected abstract void doWriteLine(String symbol, String date, String open, String high, String low, String close,
                                        String volume);
}
