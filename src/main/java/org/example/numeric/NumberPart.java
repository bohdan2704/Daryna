package org.example.numeric;

public interface NumberPart {
    default int getDigitForChar(char ch, int base) {
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

    default char getCharForDigit(int digit) {
        if (digit < 10) {
            return (char) ('0' + digit);
        } else {
            return (char) ('A' + (digit - 10));
        }
    }

    double toDecimal();

    String toSpecifiedNumeralSystem(NumeralSystem base);
}
