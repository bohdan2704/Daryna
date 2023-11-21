package org.example.operations;

import org.example.numeric.Number;

public class Calculator {
    private Number numberOne;
    private Number numberTwo;

    public Calculator(Number numberOne, Number numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }

    public double add() {
        return numberOne.getDecimalNumber() + numberTwo.getDecimalNumber();
    }

    public double subtract() {
        return numberOne.getDecimalNumber() - numberTwo.getDecimalNumber();

    }

    public double multiply() {
        return numberOne.getDecimalNumber() * numberTwo.getDecimalNumber();

    }

    public double divide() {
        return numberOne.getDecimalNumber() / numberTwo.getDecimalNumber();

    }

}
