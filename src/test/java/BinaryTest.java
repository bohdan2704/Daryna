import org.example.Binary;
import org.example.BinaryNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTest {

    @Test
    void testAddition() {
        Binary binary = new Binary();

        // Test addition with equal length binary strings
        BinaryNumber addedEqualLength = binary.add(new BinaryNumber("1111"), new BinaryNumber("1111"));
        assertEquals("11110", addedEqualLength.getBinaryString());

        // Test addition with different length binary strings
        BinaryNumber addedDifferentLength = binary.add(new BinaryNumber("1111"), new BinaryNumber("111"));
        assertEquals("10110", addedDifferentLength.getBinaryString());

        // Test addition with zero
        BinaryNumber addedWithZero = binary.add(new BinaryNumber("1101"), new BinaryNumber("0"));
        assertEquals("1101", addedWithZero.getBinaryString());

        // Test addition with longer carry
        BinaryNumber addedWithCarry = binary.add(new BinaryNumber("1111"), new BinaryNumber("1"));
        assertEquals("10000", addedWithCarry.getBinaryString());
    }

    @Test
    void testSubtraction() {
        Binary binary = new Binary();

        // Test subtraction with equal length binary strings
        BinaryNumber subtractedEqualLength = binary.subtract(new BinaryNumber("1001"), new BinaryNumber("101"));
        assertEquals("100", subtractedEqualLength.getBinaryString());

        // Test subtraction with different length binary strings
        BinaryNumber subtractedDifferentLength = binary.subtract(new BinaryNumber("1101"), new BinaryNumber("10"));
        assertEquals("11011", subtractedDifferentLength.getBinaryString());

        // Test subtraction resulting in negative value
        BinaryNumber subtractedNegative = binary.subtract(new BinaryNumber("101"), new BinaryNumber("1101"));
        assertEquals("1111", subtractedNegative.getBinaryString());

        // Test subtraction with borrow
        BinaryNumber subtractedWithBorrow = binary.subtract(new BinaryNumber("100"), new BinaryNumber("101"));
        assertEquals("1111", subtractedWithBorrow.getBinaryString());
    }

    @Test
    void testInvalidInput() {
        Binary binary = new Binary();

        // Test invalid input for addition
        try {
            BinaryNumber addedInvalidInput = binary.add(new BinaryNumber("12"), new BinaryNumber("1101"));
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid binary string. Only 0s and 1s are allowed.", e.getMessage());
        }

        // Test invalid input for subtraction
        try {
            BinaryNumber subtractedInvalidInput = binary.subtract(new BinaryNumber("101"), new BinaryNumber("10a"));
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid binary string. Only 0s and 1s are allowed.", e.getMessage());
        }
    }

    @Test
    void testEdgeCases() {
        Binary binary = new Binary();

        // Test subtraction resulting in zero
        BinaryNumber subtractedToZero = binary.subtract(new BinaryNumber("1010"), new BinaryNumber("1010"));
        assertEquals("0", subtractedToZero.getBinaryString());

        // Test addition resulting in longer binary string
        BinaryNumber addedLongerResult = binary.add(new BinaryNumber("1111"), new BinaryNumber("1111"));
        assertEquals("11110", addedLongerResult.getBinaryString());
    }
}