package org.example.numeric;

public class Number {
    private static final int MAX_FRACTIONAL_DIGITS = 16;
    private final NumeralSystem base;
    private final String number;
    private final int decimalNumber;
    private FractionNumber fractionNumber;

    public Number(double value) {
        base = NumeralSystem.DECIMAL;
        number = String.valueOf(value);
        decimalNumber = (int)value;
        fractionNumber = new FractionNumber(value - decimalNumber);
    }

    public Number(NumeralSystem base, String value) {
        this.base = base;

        String[] integerAndFraction = value.split("\\.");
        this.number = integerAndFraction[0];
        if (integerAndFraction.length == 1) {
            this.decimalNumber = toDecimal();
            this.fractionNumber = new FractionNumber(base, "0");
        }
        else if (integerAndFraction.length == 2) {
            this.decimalNumber = toDecimal();
            this.fractionNumber = new FractionNumber(base, integerAndFraction[1]);
        } else {
            throw new ArithmeticException("Float number is badly provided");
        }
    }

    private int toDecimal() {
        if (base.getBase() < 2 || base.getBase() > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        int result = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char currentChar = number.charAt(i);
            int digitValue = getDigitForChar(currentChar, base.getBase());

            if (digitValue == -1 || digitValue >= base.getBase()) {
                throw new NumberFormatException("Invalid digit in number");
            }

            result = result * base.getBase() + digitValue;
        }

        return result;
    }

    public String toSpecifiedNumeralSystem(NumeralSystem base) {
        int decimalNumber = this.decimalNumber;
        if (base.getBase() < 2 || base.getBase() > 36) {
            throw new IllegalArgumentException("Base must be between 2 and 36");
        }

        StringBuilder result = new StringBuilder();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base.getBase();
            result.insert(0, getCharForDigit(remainder));
            decimalNumber /= base.getBase();
        }

        return result.append(fractionNumber.toSpecifiedNumeralSystem(base)).toString();
    }

    public static int getDigitForChar(char ch, int base) {
        if (base <= 10) {
            // For bases less than or equal to 10
            if ('0' <= ch && ch <= '9') {
                return ch - '0';
            } else {
                // Handle invalid characters for the given base
                throw new IllegalArgumentException("Invalid character for base " + base);
            }
        } else {
            // For bases greater than 10 (hexadecimal, for example)
            if ('0' <= ch && ch <= '9') {
                return ch - '0';
            } else if ('A' <= ch && ch <= 'Z') {
                return ch - 'A' + 10; // A is 10 in hexadecimal
            } else {
                // Handle invalid characters for the given base
                throw new IllegalArgumentException("Invalid character for base " + base);
            }
        }
    }

    private static char getCharForDigit(int digit) {
        if (digit < 10) {
            return (char) ('0' + digit);
        } else {
            return (char) ('A' + (digit - 10));
        }
    }

    public double getDecimalNumber() {
        return decimalNumber +fractionNumber.decimalFraction;
    }

    public String getValue() {
        return number + "." + fractionNumber.fraction;
    }

    private static class FractionNumber {
        private final String fraction;
        private final double decimalFraction;

        public FractionNumber(double fraction) {
            this.fraction = String.valueOf(fraction);
            this.decimalFraction = fraction;
        }

        public FractionNumber(NumeralSystem base, String fraction) {
            this.fraction = fraction;
            decimalFraction = toDecimal(base.getBase());
        }

        private double toDecimal(int base) {
            int length = fraction.length();
            double sum = 0;

            for (int i = 0; i < length; i++) {
                char digit = fraction.charAt(i);
                int decimalValue = getDigitForChar(digit, base);

                sum += decimalValue * Math.pow(base, -(i + 1));
            }
            return sum;
        }

        private String toSpecifiedNumeralSystem(NumeralSystem base) {
            double decimalFraction = this.decimalFraction;
            int precision = MAX_FRACTIONAL_DIGITS;
            StringBuilder result = new StringBuilder();
            if (!fraction.isEmpty()) {
                result.append('.');

                while (decimalFraction > 0 && precision > 0) {
                    decimalFraction *= base.getBase();
                    result.append((int) decimalFraction);
                    decimalFraction -= (int) decimalFraction;
                    precision--;
                }

                return result.toString();
            }
            return result.toString();
        }
    }
}
