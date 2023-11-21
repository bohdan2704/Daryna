import org.example.alternative.GoldenSystem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenSystemTest {
    private static final String FirstThirtyPhiBaseNumbers = "10.01\n" +
            "100.01\n" +
            "101.01\n" +
            "1000.1001\n" +
            "1010.0001\n" +
            "10000.0001\n" +
            "10001.0001\n" +
            "10010.0101\n" +
            "10100.0101\n" +
            "10101.0101\n" +
            "100000.101001\n" +
            "100010.001001\n" +
            "100100.001001\n" +
            "100101.001001\n" +
            "101000.100001\n" +
            "101010.000001\n" +
            "1000000.000001\n" +
            "1000001.000001\n" +
            "1000010.010001\n" +
            "1000100.010001\n" +
            "1000101.010001\n" +
            "1001000.100101\n" +
            "1001010.000101\n" +
            "1010000.000101\n" +
            "1010001.000101\n" +
            "1010010.010101\n" +
            "1010100.010101\n" +
            "1010101.010101\n" +
            "10000000.10101001\n";

    @Test
    void testDecimalToPhiBaseConverting() {
        StringBuilder b = new StringBuilder();
        GoldenSystem goldenSystem = new GoldenSystem();
        for (int i = 2; i <= 30; i++) {
            b.append(goldenSystem.getNumber(i)).append("\n");
        }
        String[] phiBaseNumbersFromBook = FirstThirtyPhiBaseNumbers.split("\n");
        String[] phiBaseNumbersCalculated = b.toString().split("\n");

        for (int i = 0; i < phiBaseNumbersFromBook.length; i++) {
            System.out.println(phiBaseNumbersFromBook[i] + " -- " + phiBaseNumbersCalculated[i]);
            assertEquals(phiBaseNumbersCalculated[i], phiBaseNumbersFromBook[i]);
        }
    }
}
