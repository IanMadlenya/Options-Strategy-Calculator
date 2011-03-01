/*
 * Created by JFormDesigner on Thu Feb 24 14:15:48 EST 2011
 */

package com.starillon.ibtradetools.ui.spreadcalc;

import com.ib.client.ContractDetails;
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

    public SpreadStrategyTab() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mark French
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
                "389dlu",
                "286dlu"));

        //======== strategyScrollPnl ========
        {

            //---- strategyTbl ----
            strategyTbl.setModel(new DefaultTableModel(1, 0));
            initModels();
            strategyScrollPnl.setViewportView(strategyTbl);
        }
        add(strategyScrollPnl, cc.xy(1, 1));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initModels() {
        strategyTbl.setModel(new SpreadStrategyTableModel());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mark French
    private JScrollPane strategyScrollPnl;
    private JTable strategyTbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void initialise(SpreadStrategyDetails details) {
        this.details = details;
        ASXOption asxOption = new ASXOption(details.getUnderlying());
        asxOption.m_expiry = details.getYear() + details.getMonth();
        List<ContractDetails> optionList = SpreadStrategyCalculator.getContractService().listOptionsForUnderlying(asxOption);
        optionList.isEmpty();
    }
}
