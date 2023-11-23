package org.example.alternative;

public class FractionalSystem {
    // Working with N/M fractional system
    public static final int N = 3;
    public static final int M = 2;
    private static final int DELTA = N-M;

    public String getNumberInNMAlternativeBase(double doubleNum) {
        int num = (int)doubleNum;
        StringBuilder b = new StringBuilder();
        while (num > 0) {
            int iterator = 0;
            while (num-N >= 0) {
                iterator += N-DELTA;
                num -= N;
            }
            b.insert(0, num);
            num = iterator;
        }
        return b.toString();
    }

    public String toBase(double n, double b, int precision) {
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
