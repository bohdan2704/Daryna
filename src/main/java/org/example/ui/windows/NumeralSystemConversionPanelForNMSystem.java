package org.example.ui.windows;

import org.example.fractional.FractionalSystem;
import org.example.nmbased.BaseNM;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class NumeralSystemConversionPanelForNMSystem extends JPanel implements ConversionPanel {
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
        addComponent(gbc, 0, 0);
        add(textField, gbc);

        nTextField = new HintTextField("Enter N");
        addComponent(gbc,0, 1);
        add(nTextField, gbc);

        mTextField = new HintTextField("Enter M");
        addComponent(gbc,0, 2);
        add(mTextField, gbc);

        resultLabelForFractionalSystem = new JLabel("Number in alternative base: ");
        addComponent(gbc, 0,3);
        add(resultLabelForFractionalSystem, gbc);

        convertButton = new JButton("Convert");
        addComponent(gbc, 0, 4);
        add(convertButton, gbc);

        setFontSize(textField, convertButton, resultLabelForFractionalSystem);
        convertButton.addActionListener(e -> performConversion());

        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void performConversion() {
        int inputValue = (int)Double.parseDouble(textField.getText());
        int nValue = Integer.parseInt(nTextField.getText());
        int mValue = Integer.parseInt(mTextField.getText());

        BaseNM baseNM = new BaseNM();
        String numInFractionalSystemBase = baseNM.toBase(inputValue, nValue, mValue);

        double reverseConvert = baseNM.fromBase(numInFractionalSystemBase, nValue, mValue);
        // Setting the result to our beautiful label
        resultLabelForFractionalSystem.setText("Fractional base (" + nValue + "/" + mValue + ") " + numInFractionalSystemBase + " -- " + reverseConvert);
    }
}
