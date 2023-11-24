package org.example.fractional;

import org.example.alternative.FromBase;

public class FractionalSystem {
    private static final int precision = 16; // Precision is pow of 10

    public String toBase(double n, double b) {
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

    public double fromBase(String num, double b) {
        return FromBase.fromBase(num, b);
    }
}
