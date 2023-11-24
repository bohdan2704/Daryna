package org.example.ui.windows;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.alternative.FibonacciSystem;
import org.example.alternative.FractionalSystem;
import org.example.alternative.NumeralSystemInterface;
import org.example.numeric.NumeralSystem;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class NumeralSystemConverterUI {
    private static final HashMap<AlternativeNumeralSystem, NumeralSystemInterface> commandMap = new HashMap<>();

    static {
        commandMap.put(AlternativeNumeralSystem.FIBONACCI_SYSTEM, new FibonacciSystem());
        commandMap.put(AlternativeNumeralSystem.FRACTIONAL_SYSTEM, new FractionalSystem());
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Numeral System Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        NumeralSystemConversionPanel conversionPanel = new NumeralSystemConversionPanel();
        frame.add(conversionPanel, gbc);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


