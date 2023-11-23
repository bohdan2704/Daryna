package org.example;

import org.example.alternative.FractionalSystem;
import org.example.numeric.NumeralSystem;
import org.example.numeric.Number;
import org.example.optional.Timer;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Number number1 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "0.MI");
        Number number2 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "AF");
        Number number3 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "AF.K");

        double decimalNumber1 = number1.getDecimalNumber();
        double decimalNumber2 = number2.getDecimalNumber();
        double decimalNumber3 = number2.getDecimalNumber();

        String value1 = number1.getValue();
        String value2 = number2.getValue();
        String value3 = number3.getValue();

        String number1SpecifiedNumeralSystem = number1.toSpecifiedNumeralSystem(NumeralSystem.BINARY);
        String number2SpecifiedNumeralSystem = number2.toSpecifiedNumeralSystem(NumeralSystem.BINARY);
        String number3SpecifiedNumeralSystem = number3.toSpecifiedNumeralSystem(NumeralSystem.BINARY);

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