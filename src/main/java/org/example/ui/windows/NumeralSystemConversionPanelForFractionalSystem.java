package org.example.ui.windows;

import org.example.fractional.FractionalSystem;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForFractionalSystem extends Panel implements ConversionPanel {
    private final JTextField textField;
    private final JTextField fractionalBase;
    private final JLabel resultLabelForFractionalSystem;
    private final JButton convertButton;

    public NumeralSystemConversionPanelForFractionalSystem() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(textField, gbc, 0, 0);

        fractionalBase = new HintTextField("Enter base (only for fractional system)");
        addComponent(fractionalBase, gbc, 0, 1);

        resultLabelForFractionalSystem = new JLabel("Number in alternative base: ");
        addComponent(resultLabelForFractionalSystem, gbc, 0, 5);

        convertButton = new JButton("Convert");
        addComponent(convertButton, gbc, 0, 6);

        setFontSize(textField, convertButton, resultLabelForFractionalSystem);
        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void performConversion() {
        double inputValue = Double.parseDouble(textField.getText());
        double baseValue = Double.parseDouble(fractionalBase.getText());

        FractionalSystem fractionalSystem = new FractionalSystem();
        String numInFractionalSystemBase = fractionalSystem.toBase(inputValue, baseValue);

        double reverseConvert = fractionalSystem.fromBase(numInFractionalSystemBase, baseValue);
        // Setting the result to our beautiful label
        resultLabelForFractionalSystem.setText("Fractional base (" + baseValue + ") " + numInFractionalSystemBase + " -- " + reverseConvert);
    }
}
