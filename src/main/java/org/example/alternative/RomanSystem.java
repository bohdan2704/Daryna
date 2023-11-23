package org.example.alternative;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanSystem {
    private static final Map<Integer, String> DECIMAL_TO_ROMAN_TABLE = new LinkedHashMap<>();
    static {
        DECIMAL_TO_ROMAN_TABLE.put(1000, "M");
        DECIMAL_TO_ROMAN_TABLE.put(900, "CM");
        DECIMAL_TO_ROMAN_TABLE.put(500, "D");
        DECIMAL_TO_ROMAN_TABLE.put(400, "CD");
        DECIMAL_TO_ROMAN_TABLE.put(100, "C");
        DECIMAL_TO_ROMAN_TABLE.put(90, "XC");
        DECIMAL_TO_ROMAN_TABLE.put(50, "L");
        DECIMAL_TO_ROMAN_TABLE.put(40, "XL");
        DECIMAL_TO_ROMAN_TABLE.put(10, "X");
        DECIMAL_TO_ROMAN_TABLE.put(9, "IX");
        DECIMAL_TO_ROMAN_TABLE.put(5, "V");
        DECIMAL_TO_ROMAN_TABLE.put(4, "IV");
        DECIMAL_TO_ROMAN_TABLE.put(1, "I");
    }

    int getRomanSymbol(char romanSymbol) {
        return switch (romanSymbol) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new ArithmeticException("No such roman number");
        };
    }

    public String toBaseRecursive(int numToRoman) {
       // Checking some base cases
        if (numToRoman < 0) {
            return null;
        }
        if (numToRoman > 3999) {
            return null;
        }

        for (Integer currentNumber : DECIMAL_TO_ROMAN_TABLE.keySet()) {
            if (numToRoman > 0 && numToRoman >= currentNumber) {
                numToRoman -= currentNumber;
                return DECIMAL_TO_ROMAN_TABLE.get(currentNumber) + toBase(numToRoman);
            }
        }
        return "";
    }

    public String toBase(int numToRoman) {
        StringBuilder b = new StringBuilder();
        // Checking some base cases
        if (numToRoman < 0 || numToRoman > 3999) {
            throw new ArithmeticException("Non convertable to imperial system");
        }
        while (numToRoman > 0) {
            for (Integer currentNumber : DECIMAL_TO_ROMAN_TABLE.keySet()) {
                if (numToRoman >= currentNumber) {
                    numToRoman -= currentNumber;
                    b.append(DECIMAL_TO_ROMAN_TABLE.get(currentNumber));
                    break;
                }
            }
        }
        return b.toString();
    }

    public int fromBase(String romanNum) {
        // Initialize result
        int res = 0;

        for (int i = 0; i < romanNum.length(); i++) {
            int decimalOfRomanDigit = getRomanSymbol(romanNum.charAt(i));

            if (i + 1 < romanNum.length()) {
                int decimalOfNextRomanDigit = getRomanSymbol(romanNum.charAt(i + 1));

                // Comparing both values
                if (decimalOfRomanDigit >= decimalOfNextRomanDigit) {
                    // Value of current symbol is greater or equal the next symbol
                    res = res + decimalOfRomanDigit;
                } else {
                    // Value of current symbol is less than the next symbol
                    // Skip the next iteration with symbol (decrementing symbol)
                    res = res + decimalOfNextRomanDigit - decimalOfRomanDigit;
                    i++;
                }
            } else {
                res = res + decimalOfRomanDigit;
            }
        }
        return res;
    }

}
