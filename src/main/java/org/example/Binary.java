package org.example;

public class Binary {
    public Binary() {
    }

    public int add(int a, int b) {
        int cin = 0;
        int bin = 0;

        while (a != 0 || b != 0) {
            Pair p = bitAdder(a&1, b&1, cin);
            bin |= p.sum();
            cin = p.cout();

            // Not like computer works, but still interesting
            // Because in Java there is no binary type, and this work like right and left shift
            a /= 10;
            b /= 10;
            bin *= 10;
        }
        if (cin == 1) {
            // Add if some 1 is left in carry out bit
            bin |= cin;
        } else {
            // Remove redundant shove
            bin /= 10;
        }
        return reverse(bin);
    }


    private Pair bitAdder(int a, int b, int cin) {
        int sum = a ^ b;
        int cout = sum & cin;
        int temp = a & b;

        sum ^= cin;
        cout = cout | temp;

        return new Pair(sum, cout);
    }

    public int subtract(int a, int b) {
        b = invert(b);
        b = add(b, 1);
        return add(a, b);
    }

    private int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }

        return result;
    }

    public int invert(int binaryNumber) {
        // Convert the decimal binary number to a binary string
        String binaryString = Integer.toBinaryString(binaryNumber);

        // Create a StringBuilder to store the inverted bits
        StringBuilder invertedBits = new StringBuilder();

        // Iterate through each character in the binary string and invert the bit
        for (char bit : binaryString.toCharArray()) {
            if (bit == '0') {
                invertedBits.append('1');
            } else {
                invertedBits.append('0');
            }
        }

        // Convert the inverted bits back to an integer
        int invertedBinaryNumber = Integer.parseInt(invertedBits.toString(), 2);

        return invertedBinaryNumber;
    }
}
