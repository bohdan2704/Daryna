package org.example.alternative;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSystem {
    public String getNumber(int num) {
        List<Integer> fibIndexesList = new ArrayList<>();
        while (num > 0) {
            int fibIndex = getIndexOfFibLessOrEqualThan(num);
            fibIndexesList.add(fibIndex);
            int fibNumber = fibonacciRecursive(fibIndex);
            num -= fibNumber;
        }

        return formNumberBasedOnPowers(fibIndexesList);
    }

    private int getIndexOfFibLessOrEqualThan(int num) {
        int k = 0;
        int fib = fibonacciRecursive(k);
        while (fib < num) {
            k++;
            fib = fibonacciRecursive(k);
        }

        if ( fib == num ) {
            return k;
        } else {
            return k-1;
        }
    }
    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static String formNumberBasedOnPowers(List<Integer> listOfPowers) {
        StringBuilder b = new StringBuilder();

        for (int i = listOfPowers.getFirst(); i >= 0; i--) {
            // So we have zero index

            if (listOfPowers.contains(i)) {
                b.append(1);
            } else {
                b.append(0);
            }
        }
        return b.toString();
    }
}
