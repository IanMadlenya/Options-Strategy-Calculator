package com.starillon.ibtradetools.convertors;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;


public class MetaStockCSVConverter extends BaseConverter
{
    private CSVWriter csvWriter;


    public void open(Target target) throws Exception
    {
        String file = ((FileNameTarget)target).getFile();
        csvWriter = new CSVWriter(new FileWriter(file));
    }


    @Override
    protected void doWriteLine(String symbol, String date, String open, String high, String low, String close,
                               String volume)
    {
        String[] rowData = {symbol, date, open, high, low, close, volume};
        csvWriter.writeNext(rowData);
    }

    public void close() throws IOException
    {
        csvWriter.flush();
        csvWriter.close();

    }
}
