package org.example.ui;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.ui.windows.NumeralSystemConverterUI;

import javax.swing.*;

public class App extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException("Error when starting FlatLaf", e);
        }

        SwingUtilities.invokeLater(NumeralSystemConverterUI::createAndShowGUI);
    }
}
