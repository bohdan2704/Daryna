package org.example.alternative;

public class UnarySystem {
    // Convert decimal to unary system
    public String toBase(int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Unary system does not support negative numbers.");
        }

        return "I".repeat(decimal);
    }

    // Convert unary system to decimal
    public int fromBase(String unary) {
        if (unary == null || unary.isEmpty()) {
            throw new IllegalArgumentException("Invalid unary representation.");
        }

        int length = unary.length();
        if (unary.matches("I*")) {
            return length;
        } else {
            throw new IllegalArgumentException("Invalid unary representation: " + unary);
        }
    }
}
