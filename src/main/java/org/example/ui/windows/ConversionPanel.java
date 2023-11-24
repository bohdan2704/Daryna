package org.example.ui.windows;

import java.awt.*;

public interface ConversionPanel {
    default void addComponent(GridBagConstraints gbc, int gridX, int gridY) {
        gbc.gridx = gridX;
        gbc.gridy = gridY;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
    }

    void performConversion();
}
