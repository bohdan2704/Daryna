package org.example.ui.windows;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.ui.elements.HintTextField;
import org.example.ui.elements.NumeralSystemAlgorithms;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForAlternativeSystem extends JPanel implements ConversionPanel {
    private final JTextField textField;
    private final JComboBox<AlternativeNumeralSystem> alternativeNumeralSystemJComboBox;
    private final JLabel resultLabelForAlternativeSystem;
    private JButton convertButton;

    public NumeralSystemConversionPanelForAlternativeSystem() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(gbc, 0, 0);
        add(textField, gbc);

        alternativeNumeralSystemJComboBox = new JComboBox<>(AlternativeNumeralSystem.values());
        addComponent(gbc, 0,3);
        add(alternativeNumeralSystemJComboBox, gbc);

        resultLabelForAlternativeSystem = new JLabel("Number in alternative base: ");
        addComponent(gbc, 0,5);
        add(resultLabelForAlternativeSystem, gbc);

        convertButton = new JButton("Convert");
        addComponent(gbc, 0, 6);
        add(convertButton, gbc);

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
