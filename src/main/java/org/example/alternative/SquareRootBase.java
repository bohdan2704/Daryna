package org.example.alternative;

import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;

public class SquareRootBase implements NumeralSystemInterface {
    @Override
    public String toBase(double number) {
        Number num = new Number(number);
        String binaryNumber = num.toSpecifiedNumeralSystem(NumeralSystem.BINARY);
        System.out.println(binaryNumber);

        StringBuilder b = new StringBuilder();

        for (int i = 0; i < binaryNumber.length(); i++) {
            // Remove zero that was added right before the point
            // Because SQRT^0 is 1 in any system, we don't need to double this buddy
            if (i + 1 < binaryNumber.length() && binaryNumber.charAt(i + 1) == '.') {
                b.append(binaryNumber.charAt(i));
            } else if (binaryNumber.charAt(i) == '.') {
                b.append(binaryNumber.charAt(i));
            } else {
                b.append(binaryNumber.charAt(i)).append(0);
            }
        }
        // Now we shoud refactor the number a little
        return b.toString();
    }

    @Override
    public double fromBase(String num) {
        return FromBase.fromBase(num, Math.sqrt(2));
    }
}
