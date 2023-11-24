package org.example.alternative;

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


    @Override
    public String toBase(int n) {
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

}
