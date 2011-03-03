package com.starillon.ibtradetools.contract;

import com.ib.client.ContractDetails;

import java.util.Comparator;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 3/03/11
 * Time: 2:21 PM
 */
public class ContractPriceComparable implements Comparator<ContractDetails> {

    @Override
    public int compare(ContractDetails contractDetails1, ContractDetails contractDetails2) {
        double strike1 = contractDetails1.m_summary.m_strike;
        double strike2 = contractDetails2.m_summary.m_strike;
        if (strike1 != strike2) {
            if (strike1 < strike2) {
                return -1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
