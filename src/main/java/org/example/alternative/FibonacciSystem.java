package org.example.alternative;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSystem implements NumeralSystemInterface {
    @Override
    public String toBase(double doubleNum) {
        int num = (int) doubleNum;
        List<Integer> fibIndexesList = new ArrayList<>();
        while (num > 0) {
            int fibIndex = getIndexOfFibLessOrEqualThan((int)num);
            fibIndexesList.add(fibIndex);
            int fibNumber = fibonacciRecursive(fibIndex);
            num -= fibNumber;
        }

        return formNumberBasedOnPowers(fibIndexesList);
    }

    @Override
    public double fromBase(String fibNum) {
        StringBuilder fibs = new StringBuilder(fibNum).reverse();
        // Base are not used here
        // Create an array to store Fibonacci numbers
        long prevFib = 1;
        long currentFib = 2;

        // Calculate the decimal equivalent
        long decimalEquivalent = 0;
        int digit = Character.getNumericValue(fibs.charAt(0));
        if (digit == 1) {
            decimalEquivalent+=prevFib;
            fibs.deleteCharAt(0);
            long t = prevFib;
            prevFib = currentFib;
            currentFib = t + currentFib;
        }
        while (!fibs.isEmpty()){
            digit = Character.getNumericValue(fibs.charAt(0));
            if (digit == 1) {
                decimalEquivalent += prevFib;
            }
            fibs.deleteCharAt(0);
            long t = prevFib;
            prevFib = currentFib;
            currentFib = t + currentFib;
        }

        return decimalEquivalent;
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
    private int fibonacciRecursive(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    public static int findFib(int n)
    {
        float fibo = 2.078087F * (float) Math.log(n) + 1.672276F;

        // returning rounded off value of index
        return Math.round(fibo);
    }

    private String formNumberBasedOnPowers(List<Integer> listOfPowers) {
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
