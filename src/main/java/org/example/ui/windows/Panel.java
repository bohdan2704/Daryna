package org.example.ui.windows;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    protected void addComponent(Component c, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(c, gbc);
    }

    protected void setFontSize(Component... components) {
        Font defaultFont = new Font("Roboto", Font.PLAIN, 20);

        for (Component component : components) {
            component.setFont(defaultFont);
        }
    }
}
