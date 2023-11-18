package org.example;


import java.util.BitSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Number number1 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "0.MI");
        Number number2 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "AF");

        Binary binarySum = new Binary();

        int sum = binarySum.add(1111, 1010);
        int subs = binarySum.subtract(1111, 1010);

        Calculator calculator = new Calculator(number1, number2);
        System.out.println(calculator.add());
    }
}