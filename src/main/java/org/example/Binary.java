package org.example;

public class Binary {
    public Binary() {
    }

    public BinaryNumber add(BinaryNumber a, BinaryNumber b) {
        if (b.size() > a.size()) {
            a.fillWithZeros(b.size());
        } else if (a.size() > b.size()) {
            b.fillWithZeros(a.size());
        }

        BinaryNumber result = new BinaryNumber();
        int cin = 0;

        while (a.size() != 0) {
            // Equivalent of 0 OR -- 1 AND
            byte lastBitA = a.lastBit();
            byte lastBitB = b.lastBit();

            a.rightShove();
            b.rightShove();
            result.leftShove();

            // Calculate sum bit
            Pair pair = bitAdder(lastBitA, lastBitB, cin);
            cin = pair.cout();
            result.setLastBit(pair.sum());
            // Trying to implement this functionality using class and OOP points. Is it OK ?


        }
        if (cin == 1) {
            // Add if some 1 is left in carry out bit
            result.leftShove();
            result.setLastBit(cin);
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
        } else if (a.size() > b.size()) {
            b.fillWithZeros(a.size());
        }
        b.invert();
        b = add(b, new BinaryNumber("1"));
        BinaryNumber res = add(a, b);

        // Work with this overflow, delete in some cases
        res.deleteOverflow();
        return res;
    }

}
