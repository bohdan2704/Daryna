package org.example.ui.windows;

import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanel extends Panel implements ConversionPanel {
    private final JTextField textField;
    private final JComboBox<NumeralSystem> numeralSystemJComboBox1;
    private final JLabel resultLabel;
    private final JButton convertButton;

    public NumeralSystemConversionPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(textField, gbc, 0, 0);

        numeralSystemJComboBox1 = new JComboBox<>(NumeralSystem.values());
        addComponent(numeralSystemJComboBox1, gbc, 0, 2);

        resultLabel = new JLabel("Number in different base: ");
        addComponent(resultLabel, gbc, 0, 4);

        convertButton = new JButton("Convert");
        addComponent(convertButton, gbc, 0, 6);

        setFontSize(textField, convertButton, resultLabel);
        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void performConversion() {
        double inputValue = Double.parseDouble(textField.getText());

        // Carry out converting in number system with diff base
        NumeralSystem numeralSystemWithDiffBase = (NumeralSystem) numeralSystemJComboBox1.getSelectedItem();
        Number numberFromInput = new Number(inputValue);
        String numberInDiffBase = numberFromInput.toSpecifiedNumeralSystem(numeralSystemWithDiffBase);

        // Reverse convert to check if everything was converted properly
        assert numeralSystemWithDiffBase != null; // Argument won't be null
        Number numberReverseConvert = new Number(numeralSystemWithDiffBase, numberInDiffBase);
        double reverseConvertForNumInDiffBase = numberReverseConvert.getDecimalNumber();

        // Setting the result to our beautiful label
        resultLabel.setText(numeralSystemWithDiffBase + " " + numberInDiffBase + " -- " + reverseConvertForNumInDiffBase);
    }
}
