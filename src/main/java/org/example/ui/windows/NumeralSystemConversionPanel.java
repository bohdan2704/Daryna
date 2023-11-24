package org.example.ui.windows;

import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanel extends JPanel implements ConversionPanel {
    private final JTextField textField;
    private final JComboBox<NumeralSystem> numeralSystemJComboBox1;
    private final JLabel resultLabel;
    private final JButton convertButton;

    public NumeralSystemConversionPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(gbc, 0, 0);
        add(textField, gbc);


        numeralSystemJComboBox1 = new JComboBox<>(NumeralSystem.values());
        addComponent(gbc, 0, 2);
        add(numeralSystemJComboBox1, gbc);

        resultLabel = new JLabel("Number in different base: ");
        addComponent(gbc, 0, 4);
        add(resultLabel, gbc);

        convertButton = new JButton("Convert");
        addComponent(gbc, 0, 6);
        add(convertButton, gbc);

        setFontSize();

        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    private void setFontSize() {
        Font biggerFont = textField.getFont().deriveFont(20f);
        textField.setFont(biggerFont);
        convertButton.setFont(biggerFont);
        resultLabel.setFont(biggerFont);
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
