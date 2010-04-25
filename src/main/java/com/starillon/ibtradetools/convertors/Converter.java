/*
 * Copyright (c) 2010.  Starillon Pty Ltd
 */

package com.starillon.ibtradetools.convertors;

import java.io.IOException;

public interface Converter
{
    void open(Target target) throws Exception;

    void writeLine(String symbol, String date, String open, String high, String low, String close,
                          String volume);

    void close() throws Exception;
}
