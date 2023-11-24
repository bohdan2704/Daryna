package org.example.ui;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.ui.windows.NumeralSystemConversionPanel;
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
        SwingUtilities.invokeLater(NumeralSystemConverterUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Numeral System Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridBagLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Panel 1", createConversionPanel());
        tabbedPane.addTab("Panel 2", createConversionPanel()); // Add a duplicate panel

        frame.add(tabbedPane);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel createConversionPanel() {
        NumeralSystemConversionPanel conversionPanel = new NumeralSystemConversionPanel();
        conversionPanel.setBackground(new Color(207, 245, 207));
        return conversionPanel;
    }
}
