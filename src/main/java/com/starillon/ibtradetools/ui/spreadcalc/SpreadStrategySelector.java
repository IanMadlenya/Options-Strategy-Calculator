/*
 * Created by JFormDesigner on Thu Feb 24 11:10:08 EST 2011
 */

package com.starillon.ibtradetools.ui.spreadcalc;

import com.google.common.collect.Lists;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.starillon.ibtradetools.contract.ContractMonth;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author unknown
 */
public class SpreadStrategySelector extends JPanel {
    public SpreadStrategySelector() {
        initComponents();
    }

    public void registerAddButtonListener(ActionListener listener) {
        addBtn.addActionListener(listener);
    }


    public SpreadStrategyDetails getSpreadStrategyDetails() {
        SpreadStrategyDetails details = new SpreadStrategyDetails();

        details.setUnderlying(underlyingFld.getText());
        details.setYear((Integer) yearList.getSelectedItem());
        details.setMonth((String) monthList.getSelectedItem());
        details.setStrikeGap(strikeGapFld.getText());

        return details;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mark French
        ResourceBundle bundle = ResourceBundle.getBundle("com.starillon.ibtradetools.ui.spreadcalc.spreadcalc");
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        underlyingLbl = compFactory.createLabel(bundle.getString("SpreadStrategySelector.underlyingLbl.textWithMnemonic"));
        underlyingFld = new JTextField();
        strategyLbl = compFactory.createLabel(bundle.getString("SpreadStrategySelector.strategyLbl.textWithMnemonic"));
        strategyList = new JComboBox();
        yearLbl = compFactory.createLabel(bundle.getString("SpreadStrategySelector.yearLbl.textWithMnemonic"));
        yearList = new JComboBox();
        monthLbl = compFactory.createLabel(bundle.getString("SpreadStrategySelector.monthLbl.textWithMnemonic"));
        monthList = new JComboBox();
        strikeGapLbl = compFactory.createLabel(bundle.getString("SpreadStrategySelector.strikeGapLbl.textWithMnemonic"));
        strikeGapFld = new JTextField();
        clearBtn = new JButton();
        addBtn = new JButton();
        CellConstraints cc = new CellConstraints();

        //======== this ========
        setBackground(new Color(238, 238, 238));
        setBorder(new CompoundBorder(
                new TitledBorder(bundle.getString("SpreadStrategySelector.this.border")),
                Borders.DLU2_BORDER));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new FormLayout(
                "$lcgap, default, $lcgap, $button, 7*($lcgap, default), $lcgap, 20dlu, $lcgap",
                "default, $lgap, default"));
        initForm();
        initModels();
        add(underlyingLbl, cc.xy(2, 1));
        add(underlyingFld, cc.xy(4, 1));
        add(strategyLbl, cc.xy(6, 1));

        //---- strategyList ----
        strategyList.setModel(new DefaultComboBoxModel(new String[]{
                "Bear Call Spread",
                "Bear Put Spread",
                "Bull Call Spread",
                "Bull Put Spread\t"
        }));
        add(strategyList, cc.xy(8, 1));
        add(yearLbl, cc.xy(10, 1));
        add(yearList, cc.xy(12, 1));
        add(monthLbl, cc.xy(14, 1));
        add(monthList, cc.xy(16, 1));
        add(strikeGapLbl, cc.xy(18, 1));
        add(strikeGapFld, cc.xy(20, 1));

        //---- clearBtn ----
        clearBtn.setText(bundle.getString("SpreadStrategySelector.clearBtn.text"));
        add(clearBtn, cc.xy(8, 3));

        //---- addBtn ----
        addBtn.setText(bundle.getString("SpreadStrategySelector.addBtn.text"));
        add(addBtn, cc.xy(12, 3));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initModels() {
        //---- monthList ----
        monthList.setModel(new DefaultComboBoxModel(ContractMonth.MONTH_LIST));
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Integer> years = Lists.newArrayList();
        for (int i = 0; i < 10; ++i) {
            years.add(currentYear + i);
        }
        yearList.setModel(new DefaultComboBoxModel(years.toArray()));
    }

    private void initForm() {
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                clear();
            }
        });
    }

    private void clear() {
        underlyingFld.setText("");
        strikeGapFld.setText("");
        monthList.setSelectedIndex(0);
        yearList.setSelectedIndex(0);
        strategyList.setSelectedIndex(0);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mark French
    private JLabel underlyingLbl;
    private JTextField underlyingFld;
    private JLabel strategyLbl;
    private JComboBox strategyList;
    private JLabel yearLbl;
    private JComboBox yearList;
    private JLabel monthLbl;
    private JComboBox monthList;
    private JLabel strikeGapLbl;
    private JTextField strikeGapFld;
    private JButton clearBtn;
    private JButton addBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
