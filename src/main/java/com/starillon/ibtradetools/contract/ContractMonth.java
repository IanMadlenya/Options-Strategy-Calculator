package com.starillon.ibtradetools.contract;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 1/03/11
 * Time: 12:26 PM
 */
public enum ContractMonth {
    JAN("01"),
    FEB("02"),
    MAR("03"),
    APR("04"),
    MAY("05"),
    JUN("06"),
    JUL("07"),
    AUG("08"),
    SEP("09"),
    OCT("10"),
    NOV("11"),
    DEC("12");

    public static final String[] MONTH_LIST = {JAN.toString(), FEB.toString(), MAR.toString(), APR.toString(),
            MAY.toString(), JUN.toString(), JUL.toString(), AUG.toString(), SEP.toString(), OCT.toString(),
            NOV.toString(), DEC.toString()};

    @Override
    public String toString() {
        return month;
    }

    ContractMonth(String month) {
        this.month = month;
    }


    private String month;
}
