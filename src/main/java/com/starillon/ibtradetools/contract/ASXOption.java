package com.starillon.ibtradetools.contract;

import com.ib.client.Contract;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 14/12/10
 * Time: 1:35 PM
 */
public class ASXOption extends Contract implements ContractConstants {
    public ASXOption(String symbol) {
        m_secType = OPTION;
        m_currency = CURRENCY_AUD;
        m_symbol = symbol;
        m_exchange = EXCHANGE_ASX;
    }
}
