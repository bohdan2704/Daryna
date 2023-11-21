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

    public void reverse() {
        bits = bits.reversed();
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
        boolean previouslyWereJustZeroes = true;
        for (byte b : bits) {
            if (previouslyWereJustZeroes && b == 1) {
                previouslyWereJustZeroes = false;
            }
            if ( !previouslyWereJustZeroes) {
                builder.append(b);
            }
        }
        if (builder.isEmpty()) {
            return "0";
        }
        return builder.toString();
    }

    public boolean isLessThan(BinaryNumber compareWith) {
        int a = Integer.parseInt(getBinaryString(), 2);
        int b = Integer.parseInt(compareWith.getBinaryString(), 2);
        return a <= b;
    }
}