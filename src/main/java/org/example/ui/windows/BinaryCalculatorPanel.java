package org.example.ui.windows;

import org.example.operations.BinaryCalculator;
import org.example.operations.BinaryNumber;
import org.example.operations.BinaryOperation;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;

public class BinaryCalculatorPanel extends Panel {
    private final JTextField aTextField;
    private final JTextField bTextField;
    private final JLabel result;
    private JButton addButton;
    private JButton subtractButton;


    public BinaryCalculatorPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(207, 245, 207));

        GridBagConstraints gbc = new GridBagConstraints();

        aTextField = new HintTextField("Enter A value");
        addComponent(aTextField, gbc,0, 1);

        bTextField = new HintTextField("Enter B value");
        addComponent(bTextField, gbc,0, 2);

        result = new JLabel("Number in alternative base: ");
        addComponent(result, gbc, 0,3);

        addButton = new JButton("+");
        addComponent(addButton, gbc, 0, 4);

        subtractButton = new JButton("-");
        addComponent(subtractButton, gbc, 0, 5);

        addButton.addActionListener(e -> performOperation(BinaryOperation.ADD));
        subtractButton.addActionListener(e -> performOperation(BinaryOperation.SUBTRACT));

        setFontSize(addButton, subtractButton, result, aTextField, bTextField);

        setPreferredSize(new Dimension(400, 300));
    }

    public void performOperation(BinaryOperation operation) {
        String aValue = aTextField.getText();
        String bValue = bTextField.getText();

        try {
            BinaryNumber binaryNumber1 = new BinaryNumber(aValue);
            BinaryNumber binaryNumber2 = new BinaryNumber(bValue);

            BinaryCalculator binaryCalculator = new BinaryCalculator();
            BinaryNumber resultNumber;

            switch (operation) {
                case BinaryOperation.ADD:
                    resultNumber = binaryCalculator.add(binaryNumber1, binaryNumber2);
                    result.setText(resultNumber.getBinaryString() + " -- " + resultNumber.getDecimal(true));
                    break;

                case BinaryOperation.SUBTRACT:
                    resultNumber = binaryCalculator.subtract(binaryNumber1, binaryNumber2);
                    result.setText(resultNumber.getBinaryString() + " -- " + resultNumber.getDecimal());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operation");
            }
        } catch (IllegalArgumentException e) {
            result.setText("Binary numbers must be composed using only '0' and '1'!");
        }
    }
}
