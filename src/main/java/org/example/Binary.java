package org.example;

public class Binary {
    private int adderOne;
    private int adderTwo;

    public Binary(int adderOne, int adderTwo) {
        this.adderOne = adderOne;
        this.adderTwo = adderTwo;
    }

    public int add(int a, int b) {
        int cin = 0;
        int c = 0;

        while (a != 0 || b != 0) {
            Pair p = bitAdder(a&1, b&1, cin);
            c |= p.s();
            cin = p.cout();

            // Not like computer works, but still interesting
            // Because in Java there is no binary type, and this work like right and left shift
            a /= 10;
            b /= 10;
            c *= 10;
        }
        if (cin == 1) {
            // Add if some 1 is left in carry out bit
            c |= cin;
        } else {
            // Remove redundant shove
            c /= 10;
        }
        return reverse(c);
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
}
