package org.example;


import java.util.BitSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Number number1 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "0.MI");
        Number number2 = new Number(NumeralSystem.HEXATRIGESIMAL_36, "AF");
        String goldenBaseNumber = GoldenSystem.getGoldenRatioNumber(9);
        System.out.println("! -- " + goldenBaseNumber);


        for (int i = 2; i <= 30; i++) {
            goldenBaseNumber = GoldenSystem.getGoldenRatioNumber(i);
            System.out.println(i + " -- " + goldenBaseNumber);
        }

//        Binary binary = new Binary();
//        BinaryNumber added = binary.add(new BinaryNumber("1111"), new BinaryNumber("1111"));
//        BinaryNumber sunstructed = binary.subtract(new BinaryNumber("1000"), new BinaryNumber("1010"));

        Calculator calculator = new Calculator(number1, number2);
        System.out.println(calculator.add());
    }
}