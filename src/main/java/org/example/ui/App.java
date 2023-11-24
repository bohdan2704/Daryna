package org.example.ui;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.ui.windows.NumeralSystemConversionPanel;
import org.example.ui.windows.NumeralSystemConversionPanelForAlternativeSystem;
import org.example.ui.windows.NumeralSystemConverterUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException("Error when starting flat", e);
        }

        SwingUtilities.invokeLater(App::createAndShowGUI);
    }

    private static void createAndShowGUI() {
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
