package org.example.ui.windows;

import org.example.operations.BinaryCalculator;
import org.example.operations.BinaryNumber;
import org.example.ui.elements.HintTextField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BinaryCalculatorPanel extends JPanel {
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

        addButton.addActionListener(e -> addOperation());
        subtractButton.addActionListener(e -> subtractOperation());

        setFontSize(addButton, subtractButton, result, aTextField, bTextField);

        setPreferredSize(new Dimension(400, 300));
    }

    private void addComponent(Component c, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(c, gbc);
    }

    private void setFontSize(Component... components) {
        Font defaultFont = new Font("Roboto", Font.PLAIN, 20);

        for (Component component : components) {
            component.setFont(defaultFont);
        }
    }

    public void addOperation() {
        String aValue = aTextField.getText();
        String bValue = bTextField.getText();
        BinaryNumber binaryNumber1 = new BinaryNumber(aValue);
        BinaryNumber binaryNumber2 = new BinaryNumber(bValue);

        BinaryCalculator binaryCalculator = new BinaryCalculator();
        BinaryNumber addResult = binaryCalculator.add(binaryNumber1, binaryNumber2);
        result.setText(addResult.getBinaryString() + " -- " + addResult.getDecimal(true));
    }

    public void subtractOperation() {
        String aValue = aTextField.getText();
        String bValue = bTextField.getText();
        BinaryNumber binaryNumber1 = new BinaryNumber(aValue);
        BinaryNumber binaryNumber2 = new BinaryNumber(bValue);

        BinaryCalculator binaryCalculator = new BinaryCalculator();
        BinaryNumber subtractResult = binaryCalculator.subtract(binaryNumber1, binaryNumber2);
        result.setText(subtractResult.getBinaryString() + " -- " + subtractResult.getDecimal());
    }
}
