package org.example.ui.windows;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.alternative.FibonacciSystem;
import org.example.alternative.NumeralSystemInterface;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class NumeralSystemConverterUI {
    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Numeral Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Number Systems", createConversionPanel());
        tabbedPane.addTab("Alternative Systems", createConversionPanelForAlternativeSystem()); // Add a duplicate panel

        frame.add(tabbedPane);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Component createConversionPanelForAlternativeSystem() {
        NumeralSystemConversionPanelForAlternativeSystem conversionPanel = new NumeralSystemConversionPanelForAlternativeSystem();
        conversionPanel.setBackground(new Color(207, 245, 207));
        return conversionPanel;
    }

    private static JPanel createConversionPanel() {
        NumeralSystemConversionPanel conversionPanel = new NumeralSystemConversionPanel();
        conversionPanel.setBackground(new Color(207, 245, 207));
        return conversionPanel;
    }
}


