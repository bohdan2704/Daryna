package org.example.numeric;

public class Number {
    private final IntegerPart integerPart;
    private final FractionPart fractionPart;

    public Number(double value) {
        integerPart = new IntegerPart((int) value);
        fractionPart = new FractionPart(value - (int) value);
    }

    public Number(NumeralSystem base, String value) {
        if (base.getBase() < 2 || base.getBase() > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        String[] integerAndFraction = value.split("\\.");
        integerPart = new IntegerPart(base, integerAndFraction[0]);

        if (integerAndFraction.length == 1) {
            fractionPart = new FractionPart(base, "0");
        } else if (integerAndFraction.length == 2) {
            fractionPart = new FractionPart(base, integerAndFraction[1]);
        } else {
            // Should not reach here any time soon
            throw new ArithmeticException("Float number is badly provided");
        }
    }

    public double getDecimalNumber() {
        return integerPart.toDecimal() + fractionPart.toDecimal();
    }

    public String toSpecifiedNumeralSystem(NumeralSystem numeralSystem) {
        String intStr = integerPart.toSpecifiedNumeralSystem(numeralSystem);
        String frStr = fractionPart.toSpecifiedNumeralSystem(numeralSystem);
        String wholeNumber = intStr + frStr;
        if (wholeNumber.charAt(0) == '.') {
            return "0" + wholeNumber;
        } else if (wholeNumber.charAt(wholeNumber.length() - 1) == '.') {
            return wholeNumber + "0";
        } else {
            return wholeNumber;
        }

    }
}