package org.example.ui;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.alternative.AlternativeNumeralSystem;
import org.example.alternative.FibonacciSystem;
import org.example.alternative.FractionalSystem;
import org.example.alternative.NumeralSystemInterface;
import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.HashMap;

public class App {
    // Set the Command Pattern
    private static final HashMap<AlternativeNumeralSystem, NumeralSystemInterface> commandMap = new HashMap<>();

    static {
        commandMap.put(AlternativeNumeralSystem.FIBONACCI_SYSTEM, new FibonacciSystem());
        commandMap.put(AlternativeNumeralSystem.FRACTIONAL_SYSTEM, new FractionalSystem());

    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException("Error when starting flat", e);
        }
        SwingUtilities.invokeLater(App::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create and set up the frame
        JFrame frame = new JFrame("Zungenbrecher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Increased frame size

        // Use GridBagLayout for centering components
        frame.setLayout(new GridBagLayout());
        // Set background color
        frame.getContentPane().setBackground(new Color(207, 245, 207)); // Light green background

        GridBagConstraints gbc = new GridBagConstraints();

        // Create components
        JTextField textField = new JTextField(15);
        addHint(textField, "Enter number in decimal");

        // Should be filled only when using Fractional DB
        JTextField textFieldOptionalBase = new JTextField(15);
        addHint(textFieldOptionalBase, "Enter base (only for fractional system)");

        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Result:");


        // Set up constraints for text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL; // Make components expand horizontally
        frame.add(textField, gbc);

        gbc.gridy = 1;
        frame.add(textFieldOptionalBase, gbc);

        gbc.gridy = 2;
        // Create a JComboBox for the enum
        JComboBox<NumeralSystem> numeralSystemJComboBox1 = new JComboBox<>(NumeralSystem.values());
        JComboBox<AlternativeNumeralSystem> numeralSystemJComboBox2 = new JComboBox<>(AlternativeNumeralSystem.values());

        // Set up constraints for the combo box
        gbc.gridy = 3;
        frame.add(numeralSystemJComboBox1, gbc);
        gbc.gridy = 4;
        frame.add(numeralSystemJComboBox2, gbc);

        // Set up constraints for label
        gbc.gridy = 5;
        frame.add(label, gbc);

        // Set up constraints for button
        gbc.gridy = 6;
        frame.add(button, gbc);





        // Make all elements bigger
        Font biggerFont = textField.getFont().deriveFont(20f);
        textField.setFont(biggerFont);
        button.setFont(biggerFont);
        label.setFont(biggerFont);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get text from the text field and set it to the label
                label.setText("Result: " + textField.getText());

                // Get selected value from the combo box
                NumeralSystem numeralSystem1 = (NumeralSystem) numeralSystemJComboBox1.getSelectedItem();
                System.out.println("Selected Color: " + numeralSystem1);

                AlternativeNumeralSystem numeralSystem2 = (AlternativeNumeralSystem) numeralSystemJComboBox2.getSelectedItem();
                double inputValue = Double.parseDouble(textField.getText());
                double baseInputValue = 0;
                if (!textFieldOptionalBase.getText().isEmpty()) {
                    baseInputValue = Double.parseDouble(textFieldOptionalBase.getText());
                }

                String numInAlternativeSystem = commandMap.get(numeralSystem2).toBase(inputValue, baseInputValue);
                double outputValue = commandMap.get(numeralSystem2).fromBase(numInAlternativeSystem, baseInputValue);
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private static void addHint(final JTextField textField, final String hint) {
        textField.setText(hint);
        textField.setForeground(Color.GRAY);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(hint)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(hint);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
}