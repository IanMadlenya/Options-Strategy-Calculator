/*
 * Created by JFormDesigner on Thu Feb 24 11:56:00 EST 2011
 */

package com.starillon.ibtradetools.ui.spreadcalc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.starillon.ibtradetools.ContractService;
import com.starillon.ibtradetools.MarketDataService;
import com.starillon.ibtradetools.TradeToolsModule;
import com.starillon.ibtradetools.connection.TradeToolsConnectionModule;
import org.guiceyfruit.jsr250.Jsr250Module;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * @author Mark French
 */
public class SpreadStrategyCalculator extends JFrame {
    private SpreadStrategySelector spreadStrategySelector;
    private SpreadStrategyTabPanel spreadStrategyTabPanel;
    private static MarketDataService marketDataService;
    private static ContractService contractService;


    public SpreadStrategyCalculator() {
        initComponents();
    }

    public static MarketDataService getMarketDataService() {
        return marketDataService;
    }

    public static ContractService getContractService() {
        return contractService;
    }

    public static void main(String[] args) {
        Runnable createAndShowGui = new Runnable() {
            public void run() {
                new SpreadStrategyCalculator().setVisible(true);
            }
        };

        EventQueue.invokeLater(createAndShowGui);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Mark French
        ResourceBundle bundle = ResourceBundle.getBundle("com.starillon.ibtradetools.ui.spreadcalc.spreadcalc");

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(bundle.getString("SpreadStrategyCalculator.this.title"));
        Container contentPane = getContentPane();
        contentPane.setLayout(new FormLayout(
                "default",
                "default, $lgap, default"));
        layoutPanels();
        registerListeners();
        initTradeServices();
        setSize(800, 705);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initTradeServices() {
        Injector injector = Guice.createInjector(new Jsr250Module(), new TradeToolsConnectionModule(),
                new TradeToolsModule());
        marketDataService = injector.getInstance(MarketDataService.class);
        contractService = injector.getInstance(ContractService.class);
    }

    private void registerListeners() {
        spreadStrategySelector.registerAddButtonListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SpreadStrategyDetails details = spreadStrategySelector.getSpreadStrategyDetails();
                spreadStrategyTabPanel.createStrategyTab(details);
            }
        });
    }

    private void layoutPanels() {
        spreadStrategySelector = new SpreadStrategySelector();
        spreadStrategyTabPanel = new SpreadStrategyTabPanel();

        CellConstraints cc = new CellConstraints();
        getContentPane().add(spreadStrategySelector, cc.xy(1, 1));
        getContentPane().add(spreadStrategyTabPanel, cc.xy(1, 3));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Mark French
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
