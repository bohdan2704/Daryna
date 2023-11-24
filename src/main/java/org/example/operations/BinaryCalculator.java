package org.example.operations;

public class BinaryCalculator {
    public BinaryCalculator() {
    }

    public BinaryNumber add(BinaryNumber a, BinaryNumber b) {
        if (b.size() > a.size()) {
            a.fillWithZeros(b.size());
        } else if (a.size() > b.size()) {
            b.fillWithZeros(a.size());
        }

        BinaryNumber result = new BinaryNumber("0".repeat(a.size() + 1));
        int cin = 0;
        int len = a.size();
        for (int i = 0; i < len; i++) {
            // Equivalent of 0 OR -- 1 AND
            byte lastBitA = a.lastBit();
            byte lastBitB = b.lastBit();

            a.rightShove();
            b.rightShove();

            // Calculate sum bit
            Pair pair = bitAdder(lastBitA, lastBitB, cin);
            cin = pair.cout();

            // Add it to our integer, shove then to the right
            result.setFirstBit(pair.sum());
            result.rightShove();
        }
        if (cin == 1) {
            result.setFirstBit(cin);
        }
        result.rightShove();
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

        boolean resultIsLessThanZero = !b.isLessThan(a);

        b.invert();
        b = add(b, new BinaryNumber("1"));
        BinaryNumber res = add(a, b);

        // Work with this overflow, delete in some cases
        if (!resultIsLessThanZero) {
            res.deleteOverflow();
            // Add 0 to show that number is positive
            res.setFirstBit(0);
            return res;
        }
        // Keep 1 as first bit to show that number is negative
        return res;
    }
}
