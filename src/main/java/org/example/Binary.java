package org.example;

public class Binary {
    public Binary() {
    }

    public BinaryNumber add(BinaryNumber a, BinaryNumber b) {
        if (b.size() > a.size()) {
            a.fillWithZeros(b.size());
        } else {
            b.fillWithZeros(a.size());
        }

        BinaryNumber result = new BinaryNumber();
        int cin = 0;

        while (a.size() != 0) {
            // Equivalent of 0 OR -- 1 AND
            byte lastBitA = a.lastBit();
            byte lastBitB = b.lastBit();

            // Calculate sum bit
            Pair pair = bitAdder(lastBitA, lastBitB, cin);
            cin = pair.cout();
            result.setLastBit(pair.sum());
            // Trying to implement this functionality using class and OOP points. Is it OK ?

            a.rightShove();
            b.rightShove();
            result.leftShove();
        }
        if (cin == 1) {
            // Add if some 1 is left in carry out bit
            result.setLastBit(cin);
        } else {
            result.rightShove();
        }
        result.reverse();
        return result;
    }

    private Pair bitAdder(int a, int b, int cin) {
        int sum = a ^ b;
        int cout = sum & cin;
        int temp = a & b;

        sum ^= cin;
        cout = cout | temp;

        return new Pair(sum, cout);
    }

    public BinaryNumber subtract(BinaryNumber a, BinaryNumber b) {
        if (b.size() > a.size()) {
            a.fillWithZeros(b.size());
        } else {
            b.fillWithZeros(a.size());
        }
        b.invert();
        b = add(b, new BinaryNumber("1"));
        BinaryNumber res = add(a, b);

        // Work with this overflow, delete in some cases
        res.deleteOverflow();
        return res;
    }

    public static int reverse(int num) {
        int reversed = 0;

        // Iterate through each bit in the binary representation of the number
        while (num > 0) {
            // Shift the reversed bits to the left and add the rightmost bit of the original number
            reversed = (reversed << 1) | (num & 1);

            // Right shift the original number to move to the next bit
            num >>= 1;
        }

        return reversed;
    }

    public int invert(int num) {
        int bitmask = 0b11111;

        // Use bitwise XOR to invert only the last six bits
        return num ^ bitmask;
    }

}
