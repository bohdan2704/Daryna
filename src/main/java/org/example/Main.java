package org.example;

import org.example.alternative.FibonacciSystem;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Number number1 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "0.MI");
//        Number number2 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "AF");
        FibonacciSystem fibonacciSystem = new FibonacciSystem();
        String numberInFibonacciSystem = fibonacciSystem.getNumber(14);
        System.out.println(numberInFibonacciSystem);
    }
}