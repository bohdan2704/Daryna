package org.example.ui.windows;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.ui.elements.HintTextField;
import org.example.ui.elements.NumeralSystemAlgorithms;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForAlternativeSystem extends JPanel {
    private JTextField textField;
    private JTextField textFieldOptionalBase;
    private JComboBox<AlternativeNumeralSystem> numeralSystemJComboBox2;
    private JLabel resultLabelForAlternativeSystem;
    private JButton convertButton;

    public NumeralSystemConversionPanelForAlternativeSystem() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(textField, gbc, 0);

        textFieldOptionalBase = new HintTextField("Enter base (only for fractional system)");
        addComponent(textFieldOptionalBase, gbc, 1);

        numeralSystemJComboBox2 = new JComboBox<>(AlternativeNumeralSystem.values());
        addComponent(numeralSystemJComboBox2, gbc, 3);

        resultLabelForAlternativeSystem = new JLabel("Number in alternative base: ");
        addComponent(resultLabelForAlternativeSystem, gbc, 5);

        convertButton = new JButton("Convert");
        addComponent(convertButton, gbc, 6);

        Font biggerFont = textField.getFont().deriveFont(20f);
        textField.setFont(biggerFont);
        convertButton.setFont(biggerFont);

        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    private void addComponent(Component component, GridBagConstraints gbc, int gridY) {
        gbc.gridx = 0;
        gbc.gridy = gridY;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(component, gbc);
    }

    private void performConversion() {
        double inputValue = Double.parseDouble(textField.getText());

        // Working with alternative numeral system, converting numbers
        AlternativeNumeralSystem alternativeNumeralSystem = (AlternativeNumeralSystem) numeralSystemJComboBox2.getSelectedItem();

        // Getting base (only for fractional system)
        double baseInputValue = 0;
        if (alternativeNumeralSystem == AlternativeNumeralSystem.FRACTIONAL_SYSTEM) {
            baseInputValue = Double.parseDouble(textFieldOptionalBase.getText());
        }

        String numInAlternativeSystem = NumeralSystemAlgorithms.convert(alternativeNumeralSystem, inputValue, baseInputValue);
        double reverseConvertForAlternative = NumeralSystemAlgorithms.reverseConvert(alternativeNumeralSystem, numInAlternativeSystem, baseInputValue);

        // Setting the result to our beautiful label
        resultLabelForAlternativeSystem.setText(alternativeNumeralSystem + " " + numInAlternativeSystem + " -- " + reverseConvertForAlternative);
    }
}
