package com.starillon.ibtradetools.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;

public class DateConverter {
    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    public static String convert(Date date) {
        checkNotNull(date, "Date is null");
        return DATE_FORMAT.format(date);
    }

}
