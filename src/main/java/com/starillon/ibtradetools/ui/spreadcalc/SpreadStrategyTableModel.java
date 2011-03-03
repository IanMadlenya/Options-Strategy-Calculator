package com.starillon.ibtradetools.ui.spreadcalc;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.binding.list.SelectionInList;

import javax.swing.*;

/**
 * Copyright 2010 Starillon Pty Ltd
 * User: markfrench
 * Date: 1/03/11
 * Time: 2:47 PM
 */
public class SpreadStrategyTableModel extends AbstractTableAdapter<SpreadStrategyTableModelRow> {
    private static final String STRIKE_RANGE = "Strike Range";
    private static final String MAX_PROFIT = "Max Profit";
    private static final String MAX_LOSS = "Max Loss";
    private static final String BREAK_EVEN = "Break Even";
    private static final String MAX_PROFIT_CONT = "Max Profit / Cont.";
    private static final String MAX_LOSS_CONT = "Max Loss / Cont.";
    private static final String BREAK_EVEN_CONT = "Break Even / Cont.";
    private final static String[] columnNames = {STRIKE_RANGE, MAX_PROFIT, MAX_LOSS, BREAK_EVEN, MAX_PROFIT_CONT,
            MAX_LOSS_CONT, BREAK_EVEN_CONT};
    private ArrayListModel<SpreadStrategyTableModelRow> rows;

    public SpreadStrategyTableModel(ArrayListModel<SpreadStrategyTableModelRow> rows) {
        super(new SelectionInList((ListModel) rows), columnNames);
        this.rows = rows;
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SpreadStrategyTableModelRow row = getRow(rowIndex);
        if (columnIndex == 0) {
            return row.getStrikeRange();
        }

        return Double.MAX_VALUE;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addRow(SpreadStrategyTableModelRow row) {
        rows.add(row);
    }
}
