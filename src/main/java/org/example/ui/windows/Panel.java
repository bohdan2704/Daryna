package org.example.ui.windows;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

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

    // Formatting output line for label
    protected String formOutputLine(String s1, String s2, double d1) {
        s1 = s1.substring(0, 1).toUpperCase() + s1.substring(1).toLowerCase();
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String s3 = decimalFormat.format(d1);
        return String.format("<html>%s: %s<br>Decimal: %s</html>", s1.split("_")[0], s2, s3);
    }

    protected String formOutputLineIfDecimalIsResultingBase(String s1, double d1) {
        s1 = s1.substring(0, 1).toUpperCase() + s1.substring(1).toLowerCase();
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        String s3 = decimalFormat.format(d1);
        return String.format("<html>%s: %s</html>", s1.split("_")[0], s3);
    }
}
