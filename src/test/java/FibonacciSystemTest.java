import org.example.alternative.FibonacciSystem;
import org.example.alternative.GoldenSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSystemTest {
    private static final String FirstThirtyFibonacciBaseNumbers = "1\n" +
            "10\n" +
            "100\n" +
            "101\n" +
            "1000\n" +
            "1001\n" +
            "1010\n" +
            "10000\n" +
            "10001\n" +
            "10010\n" +
            "10100\n" +
            "10101\n" +
            "100000\n" +
            "100001\n" +
            "100010\n" +
            "100100\n" +
            "100101\n" +
            "101000\n" +
            "101001\n" +
            "101010\n" +
            "1000000\n" +
            "1000001\n" +
            "1000010\n" +
            "1000100\n" +
            "1000101\n" +
            "1001000\n" +
            "1001001\n" +
            "1001010\n" +
            "1010000";

    @Test
    void testDecimalToPhiBaseConverting() {
        StringBuilder b = new StringBuilder();
        FibonacciSystem fibonacciSystem = new FibonacciSystem();
        for (int i = 1; i <= 30; i++) {
            b.append(fibonacciSystem.toBase(i)).append("\n");
        }
        String[] phiBaseNumbersFromBook = FirstThirtyFibonacciBaseNumbers.split("\n");
        String[] phiBaseNumbersCalculated = b.toString().split("\n");

        for (int i = 0; i < phiBaseNumbersFromBook.length; i++) {
            System.out.println(phiBaseNumbersFromBook[i] + " -- " + phiBaseNumbersCalculated[i]);
            assertEquals(phiBaseNumbersCalculated[i], phiBaseNumbersFromBook[i]);
        }
    }
}
