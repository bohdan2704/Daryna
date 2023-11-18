package org.example;

public class BinaryNumber {
    private byte[] bits;

    // Constructor
    public BinaryNumber(byte[] bits) {
        this.bits = bits;
    }

    // AND operation
    public BinaryNumber and(BinaryNumber other) {
        byte[] resultBits = new byte[Math.min(bits.length, other.bits.length)];
        for (int i = 0; i < resultBits.length; i++) {
            resultBits[i] = (byte) (bits[i] & other.bits[i]);
        }
        return new BinaryNumber(resultBits);
    }

    // OR operation
    public BinaryNumber or(BinaryNumber other) {
        byte[] resultBits = new byte[Math.max(bits.length, other.bits.length)];
        for (int i = 0; i < resultBits.length; i++) {
            byte operand1 = i < bits.length ? bits[i] : 0;
            byte operand2 = i < other.bits.length ? other.bits[i] : 0;
            resultBits[i] = (byte) (operand1 | operand2);
        }
        return new BinaryNumber(resultBits);
    }

    // XOR operation
    public BinaryNumber xor(BinaryNumber other) {
        byte[] resultBits = new byte[Math.max(bits.length, other.bits.length)];
        for (int i = 0; i < resultBits.length; i++) {
            byte operand1 = i < bits.length ? bits[i] : 0;
            byte operand2 = i < other.bits.length ? other.bits[i] : 0;
            resultBits[i] = (byte) (operand1 ^ operand2);
        }
        return new BinaryNumber(resultBits);
    }

    // Left shift (shove) operation
    public BinaryNumber shoveLeft(int positions) {
        byte[] resultBits = new byte[bits.length + positions];
        System.arraycopy(bits, 0, resultBits, positions, bits.length);
        return new BinaryNumber(resultBits);
    }

    // Bitwise inversion operation
    public BinaryNumber invert() {
        byte[] resultBits = new byte[bits.length];
        for (int i = 0; i < bits.length; i++) {
            resultBits[i] = (byte) ~bits[i];
        }
        return new BinaryNumber(resultBits);
    }
}