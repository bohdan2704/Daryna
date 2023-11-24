package org.example.ui.windows;

import org.example.fractional.FractionalSystem;
import org.example.nmbased.BaseNM;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForNMSystem extends Panel implements ConversionPanel {
    private final JTextField textField;
    private final JTextField nTextField;
    private final JTextField mTextField;
    private final JLabel resultLabelForFractionalSystem;
    private JButton convertButton;

    public NumeralSystemConversionPanelForNMSystem() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        textField = new HintTextField("Enter number in decimal");
        addComponent(textField, gbc, 0, 0);

        nTextField = new HintTextField("Enter N");
        addComponent(nTextField, gbc,0, 1);

        mTextField = new HintTextField("Enter M");
        addComponent(mTextField, gbc,0, 2);

        resultLabelForFractionalSystem = new JLabel("Number in alternative base: ");
        addComponent(resultLabelForFractionalSystem, gbc, 0,3);

        convertButton = new JButton("Convert");
        addComponent(convertButton, gbc, 0, 4);

        setFontSize(textField, convertButton, resultLabelForFractionalSystem);
        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void performConversion() {
        int inputValue = (int)Double.parseDouble(textField.getText());
        int nValue = (int)Double.parseDouble(nTextField.getText());
        int mValue = (int)Double.parseDouble(mTextField.getText());

        if (nValue <= mValue) {
            resultLabelForFractionalSystem.setText("N must be greater than M. So the base will be > 1");
            return;
        }

        BaseNM baseNM = new BaseNM();
        String numInFractionalSystemBase = baseNM.toBase(inputValue, nValue, mValue);

        double reverseConvert = baseNM.fromBase(numInFractionalSystemBase, nValue, mValue);
        // Setting the result to our beautiful label
        resultLabelForFractionalSystem.setText("Fractional base (" + nValue + "/" + mValue + ") " + numInFractionalSystemBase + " -- " + reverseConvert);
    }
}
