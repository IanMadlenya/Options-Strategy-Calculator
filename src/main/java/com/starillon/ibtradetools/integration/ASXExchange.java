package com.starillon.ibtradetools.integration;

import au.com.bytecode.opencsv.CSVReader;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.ib.client.Contract;
import com.starillon.ibtradetools.contract.ASXStock;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: mark
 * Date: May 3, 2010
 * Time: 6:51:03 PM
 */
public class ASXExchange implements Exchange
{
    @Inject
    private Logger logger;

    @Inject
    @Named("asx.stock.symbols.url")
    private String asxSymbolURL;

    @Override
    public List<Contract> listAllSymbols()
    {
        List<Contract> symbols = Lists.newArrayList();

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(asxSymbolURL);

        try
        {
            HttpResponse response = httpclient.execute(httpget);
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            CSVReader csvReader = new CSVReader(reader);
            List<String[]> rows = csvReader.readAll();

            for (int i = 3; i < rows.size(); ++i)
            {
                symbols.add(new ASXStock(rows.get(i)[1]));
            }
        }
        catch (IOException e)
        {
            logger.log(Level.SEVERE, "Failed downloading asx stock symbols.", e);
        }

        return symbols;
    }
}
