package org.example.operations;

import java.util.List;
import java.util.ArrayList;


public class BinaryNumber {
    private List<Byte> bits;

    public BinaryNumber() {
        bits = new ArrayList<>();
    }
    public BinaryNumber(String binaryString) {
        // Validate that the input string only contains 0s and 1s
//        if (binaryString.matches("[01]+")) {
            convertToBits(binaryString);
//        } else {
//            throw new IllegalArgumentException("Invalid binary string. Only 0s and 1s are allowed.");
//        }
    }

    private void convertToBits(String binaryString) {
        bits = new ArrayList<>();
//        bits.add((byte)0);
        for (char c : binaryString.toCharArray()) {
            byte bit = (byte) Character.getNumericValue(c);
            bits.add(bit);
        }
    }

    public byte lastBit() {
        return bits.get(bits.size()-1);
    }

    public void rightShove() {
        bits.remove(bits.size()-1);
    }

    public void leftShove() {
        // zeroToInsertSoBinaryWIllBeShoved
        bits.add((byte)0);
    }

    public void setFirstBit(int bit) {
        bits.add(0, (byte)bit);
    }

    public void fillWithZeros(int len) {
        int currentSize = bits.size();
        int zerosToAdd = len - currentSize;

        if (zerosToAdd > 0) {
            List<Byte> zeroList = new ArrayList<>(zerosToAdd);
            for (int i = 0; i < zerosToAdd; i++) {
                zeroList.add((byte) 0);
            }

            zeroList.addAll(bits);
            bits = zeroList;
        }
    }

    public void invert() {
        for (int i = 0; i < bits.size(); i++) {
            byte n = (byte) (bits.get(i) == 1 ? 0 : 1);
            bits.set(i, n);
        }
        byte k = 1;
        bits.add(0, k);

    }

    public int size() {
        return bits.size();
    }

    public void deleteOverflow() {
        bits.remove(0);
    }

    public String getBinaryString() {
        StringBuilder builder = new StringBuilder();
//        boolean previouslyWereJustZeroes = true;
        for (byte b : bits) {
//            if (previouslyWereJustZeroes && b == 1) {
//                previouslyWereJustZeroes = false;
//            }
//            if ( !previouslyWereJustZeroes) {
                builder.append(b);
//            }
        }
        if (builder.isEmpty()) {
            return "0";
        }
        return builder.toString();
    }

    private static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // Iterate through the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            char digit = binary.charAt(i);

            // Convert the character to an integer
            int bitValue = Character.getNumericValue(digit);

            // Add the bit value multiplied by 2^power to the decimal result
            decimal += (int) (bitValue * Math.pow(2, power));

            // Increment the power for the next iteration
            power++;
        }

        return decimal;
    }

    public int getDecimal(boolean ... showOnlyAbsoluteValue) {
        String binary = getBinaryString();
        // If we passed some value (true or false) -- we provide only absolute value
        if (showOnlyAbsoluteValue.length>0) {
            return binaryToDecimal(binary);
        }

        if (binary.charAt(0) == '0') {
            return binaryToDecimal(binary);
        } else {
            return twoComplementToDecimal(binary);
        }
    }

    private static int twoComplementToDecimal(String binary) {
        int result;

        if (binary.charAt(0) == '0') {
            // Positive number, convert as usual
            result = Integer.parseInt(binary, 2);
        } else {
            // Negative number
            // Invert all bits
            StringBuilder invertedBinary = new StringBuilder();
            for (char bit : binary.toCharArray()) {
                invertedBinary.append(bit == '0' ? '1' : '0');
            }

            // Add 1 to the inverted binary
            StringBuilder incrementedBinary = new StringBuilder();
            int carry = 1;
            for (int i = invertedBinary.length() - 1; i >= 0; i--) {
                char currentBit = invertedBinary.charAt(i);
                int sum = (currentBit - '0') + carry;
                incrementedBinary.insert(0, sum % 2);
                carry = sum / 2;
            }

            // Convert the incremented binary to decimal and apply the negative sign
            result = -Integer.parseInt(incrementedBinary.toString(), 2);
        }

        return result;
    }

    public boolean isLessThan(BinaryNumber compareWith) {
        int a = Integer.parseInt(getBinaryString(), 2);
        int b = Integer.parseInt(compareWith.getBinaryString(), 2);
        return a <= b;
    }
}