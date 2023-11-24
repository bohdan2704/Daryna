package org.example.ui.windows;

import javax.swing.*;
import java.awt.*;

public interface ConversionPanel {
    default void addComponent(GridBagConstraints gbc, int gridX, int gridY) {
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    default void setFontSize(JTextField text, JButton button, JLabel label) {
        Font defaultFont = new Font("Arial", Font.PLAIN, 20);
        text.setFont(defaultFont);
        button.setFont(defaultFont);
        label.setFont(defaultFont);
    }

    void performConversion();
}
