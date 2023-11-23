package org.example.alternative;

import org.example.numeric.NumeralSystem;
import org.example.numeric.Number;

public class FractionalSystem implements NumeralSystemInterface {
    private static final int precision = 16; // Precision is pow of 10

    public String getNumberInNM(double doubleNum, int n, int m) {
        int delta = n-m;
        int num = (int)doubleNum;
        StringBuilder b = new StringBuilder();
        while (num > 0) {
            int iterator = 0;
            while (num-n >= 0) {
                iterator += n-delta;
                num -= n;
            }
            b.insert(0, num);
            num = iterator;
        }
        return b.toString();
    }

    public String squareRootToBase(double number) {
        Number num = new Number(number);
        String binaryNumber = num.toSpecifiedNumeralSystem(NumeralSystem.BINARY);
        System.out.println(binaryNumber);

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) == '.') {
                b.deleteCharAt(b.length() - 1);
                b.deleteCharAt(b.length() - 1);
                b.deleteCharAt(b.length() - 1);
                // Remove zero that was added right before point
                // Because SQRT^0 is 1 in any system, we don't need to double this buddy
            }
            b.append(binaryNumber.charAt(i)).append(0);
        }
        return b.toString();
    }

    @Override
    public String toBase(double n, double b) {
        // Checking if base nearly equals SQRT(2)
        // Then use special formula
        if ( Math.abs(b - Math.sqrt(2)) < 10E3) {
            return squareRootToBase(n);
        }
        int k = (int) Math.floor(Math.log(n) / Math.log(b)) + 1;
        StringBuilder result = new StringBuilder();

        for (int i = k - 1; i > -precision - 1; i--) {
            if (result.length() == k) {
                result.append(".");
            }

            int digit = (int) Math.floor((n / Math.pow(b, i)) % b);
            n -= digit * Math.pow(b, i);
            result.append(digit);
        }

        return result.toString();
    }

    @Override
    public double fromBase(String num, double base) {
        String[] numberSplit = num.split("\\.");
        int numberLength = numberSplit[0].length();

        double output = 0;
        String digits = String.join("", numberSplit);

        for (int i = 0; i < digits.length(); i++) {
            output += Character.getNumericValue(digits.charAt(i)) * Math.pow(base, numberLength - i - 1);
        }

        return output;
    }

}
