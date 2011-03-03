/*
 * Created by JFormDesigner on Thu Feb 24 14:15:48 EST 2011
 */

package com.starillon.ibtradetools.ui.spreadcalc;

import com.ib.client.ContractDetails;
import com.jgoodies.binding.list.ArrayListModel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.starillon.ibtradetools.contract.ASXOption;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * @author Mark French
 */
public class SpreadStrategyTab extends JPanel {
    private SpreadStrategyDetails details;
    private SpreadStrategyTableModel spreadStrategyTableModel;

    public SpreadStrategyTab() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mark French
        panel1 = new JPanel();
        expiryLbl = new JLabel();
        strikeGapLbl = new JLabel();
        strategyScrollPnl = new JScrollPane();
        strategyTbl = new JTable();
        CellConstraints cc = new CellConstraints();

        //======== this ========
        setMinimumSize(new Dimension(780, 780));

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
                "379dlu",
                "default, 212dlu"));

        //======== panel1 ========
        {
            panel1.setLayout(new FormLayout(
                    "center:190dlu, $lcgap, center:184dlu",
                    "default, $lgap"));
            panel1.add(expiryLbl, cc.xy(1, 1));
            panel1.add(strikeGapLbl, cc.xy(3, 1));
        }
        add(panel1, cc.xy(1, 1));

        //======== strategyScrollPnl ========
        {

            //---- strategyTbl ----
            strategyTbl.setModel(new DefaultTableModel(1, 0));
            initModels();
            strategyScrollPnl.setViewportView(strategyTbl);
        }
        add(strategyScrollPnl, cc.xy(1, 2));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initModels() {
        spreadStrategyTableModel = new SpreadStrategyTableModel(new ArrayListModel<SpreadStrategyTableModelRow>());
        strategyTbl.setModel(spreadStrategyTableModel);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mark French
    private JPanel panel1;
    private JLabel expiryLbl;
    private JLabel strikeGapLbl;
    private JScrollPane strategyScrollPnl;
    private JTable strategyTbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void initialise(SpreadStrategyDetails details) {
        this.details = details;
        ASXOption asxOption = new ASXOption(details.getUnderlying());
        asxOption.m_expiry = details.getYear() + details.getMonth();
        asxOption.m_right = details.getStrategy().getOptionType();
        int strikeGap = details.getStrikeGap();
        strikeGapLbl.setText("Strike Gap : " + strikeGap);
        List<ContractDetails> optionList = SpreadStrategyCalculator.getContractService().listOptionsForUnderlying(asxOption);

        String expiryDate = "";
        if (!optionList.isEmpty()) {

            for (int i = 0; i < optionList.size(); ++i) {
                if (i + strikeGap < optionList.size()) {
                    SpreadStrategyTableModelRow row = new SpreadStrategyTableModelRow();

                    ContractDetails contractDetails1 = optionList.get(i);
                    ContractDetails contractDetails2 = optionList.get(i + strikeGap);

                    row.setStrikeRange("" + contractDetails1.m_summary.m_strike + "-" + contractDetails2.m_summary.m_strike);
                    spreadStrategyTableModel.addRow(row);
                    expiryDate = contractDetails1.m_summary.m_expiry;
                }
            }
        }

        expiryLbl.setText("Expiry : " + expiryDate);
    }
}
