
package org.example.numeric;

public class FractionPart implements NumberPart {
    private static final int MAX_FRACTIONAL_DIGITS = 16;
    private final NumeralSystem base;
    private final String fractionPart;
    private final double fractionPartInDecimal;

    public FractionPart(double fractionPartInDecimal) {
        this.base = NumeralSystem.DECIMAL;
        this.fractionPart = String.valueOf(fractionPartInDecimal);
        this.fractionPartInDecimal = fractionPartInDecimal;
    }

    public FractionPart(NumeralSystem base, String fractionPart) {
        this.base = base;
        this.fractionPart = fractionPart;
        this.fractionPartInDecimal = toDecimal();
    }

    @Override
    public double toDecimal() {
        int length = fractionPart.length();
        double sum = 0;

        for (int i = 0; i < length; i++) {
            char digit = fractionPart.charAt(i);
            int decimalValue = getDigitForChar(digit, base.getBase());

            sum += decimalValue * Math.pow(base.getBase(), -(i + 1));
        }
        return sum;
    }

    @Override
    public String toSpecifiedNumeralSystem(NumeralSystem base) {
        // Implementation for converting the fraction part to a specified numeral system
        double decimalFraction = this.fractionPartInDecimal;
        int precision = MAX_FRACTIONAL_DIGITS;
        StringBuilder result = new StringBuilder();
        if (!fractionPart.isEmpty()) {
            result.append('.');

            while (decimalFraction > 0 && precision > 0) {
                decimalFraction *= base.getBase();
                result.append((int) decimalFraction);
                decimalFraction -= (int) decimalFraction;
                precision--;
            }

            return result.toString();
        }
        // Returning zero fractional part
        return result.toString();
    }

    public String getFractionPart() {
        return fractionPart;
    }
}
