package com.starillon.ibtradetools.contract;

import com.ib.client.Contract;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 1, 2010
 * Time: 6:43:50 PM
 */
public class ASXStock extends Contract implements ContractConstants
{
    public ASXStock(String symbol)
    {
        m_secType = STOCK;
        m_currency = CURRENCY_AUD;
        m_symbol = symbol;
        m_exchange = EXCHANGE_ASX;
    }
}
