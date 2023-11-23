package org.example.numeric;

public class IntegerPart implements NumberPart {
    private final NumeralSystem base;
    private final String integerPart;
    private final int integerPartInDecimal;

    public IntegerPart(int integerPartInDecimal) {
        this.base = NumeralSystem.DECIMAL;
        this.integerPart = String.valueOf(integerPartInDecimal);
        this.integerPartInDecimal = integerPartInDecimal;
    }

    public IntegerPart(NumeralSystem base, String integerPart) {
        this.base = base;
        this.integerPart = integerPart;
        this.integerPartInDecimal = (int) toDecimal();
    }

    public String getIntegerPart() {
        return integerPart;
    }

    @Override
    public double toDecimal() {
        int result = 0;
        int length = integerPart.length();

        for (int i = 0; i < length; i++) {
            char currentChar = integerPart.charAt(i);
            int digitValue = getDigitForChar(currentChar, base.getBase());

            if (digitValue == -1 || digitValue >= base.getBase()) {
                throw new NumberFormatException("Invalid digit in number");
            }

            result = result * base.getBase() + digitValue;
        }

        return result;
    }

    @Override
    public String toSpecifiedNumeralSystem(NumeralSystem base) {
        if (base.getBase() < 2 || base.getBase() > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        int decimalNumber = this.integerPartInDecimal;
        StringBuilder result = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base.getBase();
            result.insert(0, getCharForDigit(remainder));
            decimalNumber /= base.getBase();
        }

        return result.toString();
    }
}
