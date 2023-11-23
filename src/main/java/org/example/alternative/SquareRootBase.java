package org.example.alternative;

import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;

public class SquareRootBase {
    public String getNumber(int number) {
        Number num = new Number(number);
        String binaryNumber = num.toSpecifiedNumeralSystem(NumeralSystem.BINARY);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < binaryNumber.length(); i++) {
            b.append(binaryNumber.charAt(i)).append(0);
        }
        return b.toString();
    }
}
