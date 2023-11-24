package org.example.alternative;

public class UnarySystem implements NumeralSystemInterface {
    // Convert decimal to unary system
    @Override
    public String toBase(int num) {
        int decimal = (int) num;
        if (decimal < 0) {
            throw new IllegalArgumentException("Unary system does not support negative numbers.");
        }

        return "I".repeat(decimal);
    }

    // Convert unary system to decimal
    @Override
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
