package org.example.ui.windows;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConverterUI {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Numeral Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Number Systems", createConversionPanel());
        tabbedPane.addTab("Alternative Systems", createConversionPanelForAlternativeSystem()); // Add a duplicate panel
        tabbedPane.addTab("Fractional System", createConversionPanelForFractionalSystem()); // Add a duplicate panel
        tabbedPane.addTab("NM System", createConversionPanelForNMSystem()); // Add a duplicate panel
//        tabbedPane.addTab("Calculator", createCalculatorPanel()); // Add a duplicate panel

        frame.add(tabbedPane);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Component createCalculatorPanel() {
        BinaryCalculatorPanel calculatorPanel = new BinaryCalculatorPanel();
        calculatorPanel.setBackground(new Color(192, 176, 234));
        return calculatorPanel;
    }

    private static Component createConversionPanelForNMSystem() {
        NumeralSystemConversionPanelForNMSystem conversionPanel = new NumeralSystemConversionPanelForNMSystem();
        conversionPanel.setBackground(new Color(234, 176, 176));
        return conversionPanel;
    }

    private static Component createConversionPanelForFractionalSystem() {
        NumeralSystemConversionPanelForFractionalSystem conversionPanel = new NumeralSystemConversionPanelForFractionalSystem();
        conversionPanel.setBackground(new Color(176, 234, 176));
        return conversionPanel;
    }

    private static Component createConversionPanelForAlternativeSystem() {
        NumeralSystemConversionPanelForAlternativeSystem conversionPanel = new NumeralSystemConversionPanelForAlternativeSystem();
        conversionPanel.setBackground(new Color(160, 239, 218));
        return conversionPanel;
    }

    private static JPanel createConversionPanel() {
        NumeralSystemConversionPanel conversionPanel = new NumeralSystemConversionPanel();
        conversionPanel.setBackground(new Color(239, 245, 159));
        return conversionPanel;
    }
}


