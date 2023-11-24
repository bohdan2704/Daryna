package org.example.ui.windows;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.ui.elements.HintTextField;
import org.example.ui.elements.NumeralSystemAlgorithms;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForAlternativeSystem extends Panel implements ConversionPanel {
    private final JTextField textField;
    private final JComboBox<AlternativeNumeralSystem> alternativeNumeralSystemJComboBox;
    private final JLabel resultLabelForAlternativeSystem;
    private final JButton convertButton;

    public NumeralSystemConversionPanelForAlternativeSystem() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(textField, gbc, 0, 0);

        alternativeNumeralSystemJComboBox = new JComboBox<>(AlternativeNumeralSystem.values());
        addComponent(alternativeNumeralSystemJComboBox, gbc, 0, 3);

        resultLabelForAlternativeSystem = new JLabel("Number in alternative base: ");
        addComponent(resultLabelForAlternativeSystem, gbc, 0, 5);

        convertButton = new JButton("Convert");
        addComponent(convertButton, gbc, 0, 6);

        setFontSize(textField, convertButton, resultLabelForAlternativeSystem);
        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void performConversion() {
        double inputValue = Double.parseDouble(textField.getText());

        // Working with alternative numeral system, converting numbers
        AlternativeNumeralSystem alternativeNumeralSystem = (AlternativeNumeralSystem) alternativeNumeralSystemJComboBox.getSelectedItem();

        String numInAlternativeSystem = NumeralSystemAlgorithms.convert(alternativeNumeralSystem, inputValue);
        double reverseConvertForAlternative = NumeralSystemAlgorithms.reverseConvert(alternativeNumeralSystem, numInAlternativeSystem);

        // Setting the result to our beautiful label
        resultLabelForAlternativeSystem.setText(alternativeNumeralSystem + " " + numInAlternativeSystem + " -- " + reverseConvertForAlternative);
    }
}
