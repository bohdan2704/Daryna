package org.example.nmbased;

import org.example.alternative.FromBase;

public class BaseNM {
    public String toBase(int num, int n, int m) {
        if (n <= m) {
            throw new RuntimeException("Bad values provided, N must be greater than M");
        }
        int delta = n-m;
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

    public double fromBase(String num, int n, int m) {
        return FromBase.fromBase(num, (double)n/m);
    }
}
