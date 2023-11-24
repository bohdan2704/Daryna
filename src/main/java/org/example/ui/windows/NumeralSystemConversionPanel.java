package org.example.ui.windows;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;
import org.example.ui.elements.HintTextField;
import org.example.ui.elements.NumeralSystemAlgorithms;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanel extends JPanel {
    private JTextField textField;
    private JTextField textFieldOptionalBase;
    private JComboBox<NumeralSystem> numeralSystemJComboBox1;
    private JComboBox<AlternativeNumeralSystem> numeralSystemJComboBox2;
    private JLabel resultLabel;
    private JLabel resultLabelForAlternativeSystem;

    private JButton convertButton;

    public NumeralSystemConversionPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(textField, gbc, 0, 0);

        textFieldOptionalBase = new HintTextField("Enter base (only for fractional system)");
        addComponent(textFieldOptionalBase, gbc, 0, 1);

        numeralSystemJComboBox1 = new JComboBox<>(NumeralSystem.values());
        numeralSystemJComboBox2 = new JComboBox<>(AlternativeNumeralSystem.values());
        addComponent(numeralSystemJComboBox1, gbc, 0, 2);
        addComponent(numeralSystemJComboBox2, gbc, 0, 3);

        resultLabel = new JLabel("Number in different base: ");
        addComponent(resultLabel, gbc, 0, 4);

        resultLabelForAlternativeSystem = new JLabel("Number in alternative base: ");
        addComponent(resultLabelForAlternativeSystem, gbc, 0, 5);

        convertButton = new JButton("Convert");
        addComponent(convertButton, gbc, 0, 6);

        Font biggerFont = textField.getFont().deriveFont(20f);
        textField.setFont(biggerFont);
        convertButton.setFont(biggerFont);
        resultLabel.setFont(biggerFont);

        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    private void addComponent(Component component, GridBagConstraints gbc, int gridX, int gridY) {
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(component, gbc);
    }

    private void performConversion() {
        double inputValue = Double.parseDouble(textField.getText());

        // Carry out converting in number system with diff base
        NumeralSystem numeralSystemWithDiffBase = (NumeralSystem) numeralSystemJComboBox1.getSelectedItem();
        Number numberFromInput = new Number(inputValue);
        String numberInDiffBase = numberFromInput.toSpecifiedNumeralSystem(numeralSystemWithDiffBase);

        // Reverse convert to check if everything was converted properly
        assert numeralSystemWithDiffBase != null; // Argument won't be null
        Number numberReverseConvert = new Number(numeralSystemWithDiffBase, numberInDiffBase);
        double reverseConvertForNumInDiffBase = numberReverseConvert.getDecimalNumber();

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
        resultLabel.setText(numeralSystemWithDiffBase + " " + numberInDiffBase + " -- " + reverseConvertForNumInDiffBase);
        resultLabelForAlternativeSystem.setText(alternativeNumeralSystem + " " + numInAlternativeSystem + " -- " + reverseConvertForAlternative);
    }
}
