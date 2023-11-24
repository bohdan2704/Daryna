package org.example.ui.windows;

import org.example.fractional.FractionalSystem;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForFractionalSystem extends JPanel implements ConversionPanel {
    private final JTextField textField;
    private final JTextField fractionalBase;
    private final JLabel resultLabelForFractionalSystem;
    private JButton convertButton;

    public NumeralSystemConversionPanelForFractionalSystem() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(gbc, 0, 0);
        add(textField, gbc);

        fractionalBase = new HintTextField("Enter base (only for fractional system)");
        addComponent(gbc,0, 1);
        add(fractionalBase, gbc);

        resultLabelForFractionalSystem = new JLabel("Number in alternative base: ");
        addComponent(gbc, 0,5);
        add(resultLabelForFractionalSystem, gbc);

        convertButton = new JButton("Convert");
        addComponent(gbc, 0, 6);
        add(convertButton, gbc);

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
