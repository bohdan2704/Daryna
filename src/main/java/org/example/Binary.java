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
            a >>= 1;
            b >>= 1;
            bin <<= 1;
        }
        if (cin == 1) {
            // Add if some 1 is left in carry out bit
            bin |= cin;
        } else {
            // Remove redundant shove
            bin >>= 1;
        }
        bin = reverse(bin);
        System.out.println(Integer.toBinaryString(bin));
        return bin;
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
        System.out.println(Integer.toBinaryString(b));
        b = invert(b);
        System.out.println(Integer.toBinaryString(b));
        b = add(b, 0b1);
        System.out.println(Integer.toBinaryString(b));
        return add(a, b);
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
