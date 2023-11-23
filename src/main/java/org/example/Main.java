package org.example;

import org.example.alternative.FibonacciSystem;
import org.example.alternative.FractionalSystem;
import org.example.alternative.SquareRootBase;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        Number number1 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "0.MI");
//        Number number2 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "AF");
//        SquareRootBase squareRootBase = new SquareRootBase();
//        String squareRootBaseNumber = squareRootBase.getNumber(12);
//        System.out.println(squareRootBaseNumber);
        FractionalSystem fractionalSystem = new FractionalSystem();

        double b = Math.PI;
        double n = 10;
        String num = fractionalSystem.toBase(n, b, 8);
        System.out.println(num);
        System.out.println(fractionalSystem.fromBase(num, b));
    }


}