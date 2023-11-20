import org.example.Binary;
import org.example.BinaryNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTest {

    @Test
    void testAddition() {
        Binary binary = new Binary();

        // Test addition with longer carry and different length binary strings
        BinaryNumber addedWithCarryAndDifferentLength = binary.add(new BinaryNumber("1111"), new BinaryNumber("11"));
        assertEquals("10010", addedWithCarryAndDifferentLength.getBinaryString());

        // Test addition with leading zeros and different length binary strings
        BinaryNumber addedWithLeadingZeros = binary.add(new BinaryNumber("0011"), new BinaryNumber("111"));
        assertEquals("1010", addedWithLeadingZeros.getBinaryString());

        // Test addition resulting in longer binary string with leading zeros
        BinaryNumber addedLongerResultWithLeadingZeros = binary.add(new BinaryNumber("1111"), new BinaryNumber("111"));
        assertEquals("10110", addedLongerResultWithLeadingZeros.getBinaryString());

        // Test addition with zero as the first operand
        BinaryNumber addedWithZeroAsFirstOperand = binary.add(new BinaryNumber("0"), new BinaryNumber("1010"));
        assertEquals("1010", addedWithZeroAsFirstOperand.getBinaryString());

        // Test addition with zero as the second operand
        BinaryNumber addedWithZeroAsSecondOperand = binary.add(new BinaryNumber("1101"), new BinaryNumber("0"));
        assertEquals("1101", addedWithZeroAsSecondOperand.getBinaryString());

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
        assertTrue("0100".equals(subtractedEqualLength.getBinaryString())
                || "00100".equals(subtractedEqualLength.getBinaryString()));

        // Test subtraction with different length binary strings
        BinaryNumber subtractedDifferentLength = binary.subtract(new BinaryNumber("1101"), new BinaryNumber("10"));
        assertEquals("01011", subtractedDifferentLength.getBinaryString());

        // Test subtraction resulting in negative value
        BinaryNumber subtractedNegative = binary.subtract(new BinaryNumber("101"), new BinaryNumber("1101"));
        assertEquals("10010", subtractedNegative.getBinaryString());

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