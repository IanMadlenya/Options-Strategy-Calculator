package com.starillon.ibtradetools.ui.spreadcalc;

import com.google.common.collect.Lists;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 1/03/11
 * Time: 2:47 PM
 */
public class SpreadStrategyTableModel extends DefaultTableModel {
    private static final String STRIKE_RANGE = "Strike Range";
    private static final String MAX_PROFIT = "Max Profit";
    private static final String MAX_LOSS = "Max Loss";
    private static final String BREAK_EVEN = "Break Even";
    private static final String MAX_PROFIT_CONT = "Max Profit / Cont.";
    private static final String MAX_LOSS_CONT = "Max Loss / Cont.";
    private static final String BREAK_EVEN_CONT = "Break Even / Cont.";
    private final List<String> columnNames = Lists.newArrayList();
    private Class<?>[] columnTypes = new Class<?>[]{
            String.class, Double.class, Double.class, Object.class, Object.class, Object.class, Object.class
    };

    public SpreadStrategyTableModel() {
        super();
        columnNames.add(STRIKE_RANGE);
        columnNames.add(MAX_PROFIT);
        columnNames.add(MAX_LOSS);
        columnNames.add(BREAK_EVEN);
        columnNames.add(MAX_PROFIT_CONT);
        columnNames.add(MAX_LOSS_CONT);
        columnNames.add(BREAK_EVEN_CONT);
    }


    @Override
    public String getColumnName(int i) {
        return columnNames.get(i);
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Class<?> getColumnClass
            (
                    int columnIndex) {
        return columnTypes[columnIndex];
    }

    @Override
    public boolean isCellEditable
            (
                    int rowIndex,
                    int columnIndex) {
        return false;
    }
}
