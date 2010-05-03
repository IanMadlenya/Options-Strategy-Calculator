package com.starillon.ibtradetools.integration;

import com.ib.client.Contract;

import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 6:49:41 PM
 */
public interface Exchange
{
    List<Contract> listAllSymbols();
}
