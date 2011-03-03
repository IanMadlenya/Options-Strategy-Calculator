/*
 * Created by JFormDesigner on Thu Feb 24 11:51:44 EST 2011
 */

package com.starillon.ibtradetools.ui.spreadcalc;

import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;

/**
 * @author Mark French
 */
public class SpreadStrategyTabPanel extends JPanel {
    public SpreadStrategyTabPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mark French
        strategyTabPane = new JTabbedPane();
        CellConstraints cc = new CellConstraints();

        //======== this ========

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
                "395dlu",
                "271dlu"));
        add(strategyTabPane, cc.xywh(1, 1, 1, 1, CellConstraints.FILL, CellConstraints.FILL));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mark French
    private JTabbedPane strategyTabPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public void createStrategyTab(SpreadStrategyDetails details) {
        SpreadStrategyTab tab = new SpreadStrategyTab();
        tab.initialise(details);
        strategyTabPane.addTab(details.getUnderlying().toUpperCase() + " - " + details.getStrategy().toString(), tab);
        strategyTabPane.setSelectedComponent(tab);
    }
}
