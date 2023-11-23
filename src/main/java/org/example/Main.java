package org.example;

import org.example.alternative.FractionalSystem;
import org.example.optional.Timer;

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

        double b = Math.sqrt(2);
        double n = 126.25;
        Timer timer = new Timer();

        timer.startTimer();
        String num = fractionalSystem.toBase(n, b);
        timer.stopTimer();

        System.out.println(num);
        System.out.println(fractionalSystem.fromBase(num, b));
    }


}