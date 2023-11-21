import org.example.operations.BinaryCalculator;
import org.example.operations.BinaryNumber;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryCalculatorTest {

    @Test
    void testAddition() {
        BinaryCalculator binaryCalculator = new BinaryCalculator();

        // Test addition with longer carry and different length binary strings
        BinaryNumber addedWithCarryAndDifferentLength = binaryCalculator.add(new BinaryNumber("1111"), new BinaryNumber("11"));
        assertEquals("10010", addedWithCarryAndDifferentLength.getBinaryString());

        // Test addition with leading zeros and different length binary strings
        BinaryNumber addedWithLeadingZeros = binaryCalculator.add(new BinaryNumber("0011"), new BinaryNumber("111"));
        assertEquals("1010", addedWithLeadingZeros.getBinaryString());

        // Test addition resulting in longer binary string with leading zeros
        BinaryNumber addedLongerResultWithLeadingZeros = binaryCalculator.add(new BinaryNumber("1111"), new BinaryNumber("111"));
        assertEquals("10110", addedLongerResultWithLeadingZeros.getBinaryString());

        // Test addition with zero as the first operand
        BinaryNumber addedWithZeroAsFirstOperand = binaryCalculator.add(new BinaryNumber("0"), new BinaryNumber("1010"));
        assertEquals("1010", addedWithZeroAsFirstOperand.getBinaryString());

        // Test addition with zero as the second operand
        BinaryNumber addedWithZeroAsSecondOperand = binaryCalculator.add(new BinaryNumber("1101"), new BinaryNumber("0"));
        assertEquals("1101", addedWithZeroAsSecondOperand.getBinaryString());

        BinaryNumber addedEqualLength = binaryCalculator.add(new BinaryNumber("1111"), new BinaryNumber("1111"));
        assertEquals("11110", addedEqualLength.getBinaryString());

        // Test addition with different length binary strings
        BinaryNumber addedDifferentLength = binaryCalculator.add(new BinaryNumber("1111"), new BinaryNumber("111"));
        assertEquals("10110", addedDifferentLength.getBinaryString());

        // Test addition with zero
        BinaryNumber addedWithZero = binaryCalculator.add(new BinaryNumber("1101"), new BinaryNumber("0"));
        assertEquals("1101", addedWithZero.getBinaryString());

        // Test addition with longer carry
        BinaryNumber addedWithCarry = binaryCalculator.add(new BinaryNumber("1111"), new BinaryNumber("1"));
        assertEquals("10000", addedWithCarry.getBinaryString());
    }

    @Test
    void testSubtraction() {
        BinaryCalculator binaryCalculator = new BinaryCalculator();

        // Test subtraction with equal length binary strings
        BinaryNumber subtractedEqualLength = binaryCalculator.subtract(new BinaryNumber("1001"), new BinaryNumber("101"));
        assertEquals("100", subtractedEqualLength.getBinaryString());

        // Test subtraction with different length binary strings
        BinaryNumber subtractedDifferentLength = binaryCalculator.subtract(new BinaryNumber("1101"), new BinaryNumber("10"));
        assertEquals("1011", subtractedDifferentLength.getBinaryString());

        // Test subtraction resulting in negative value
        // In two`s complement code
        BinaryNumber subtractedNegative = binaryCalculator.subtract(new BinaryNumber("101"), new BinaryNumber("1101"));
        assertEquals("11000", subtractedNegative.getBinaryString());

        // Test subtraction with borrow
        // In two`s complement code
        BinaryNumber subtractedWithBorrow = binaryCalculator.subtract(new BinaryNumber("100"), new BinaryNumber("101"));
        assertEquals("1111", subtractedWithBorrow.getBinaryString());

        // Test subtraction resulting in zero
        BinaryNumber subtractedToZero = binaryCalculator.subtract(new BinaryNumber("1010"), new BinaryNumber("1010"));
        assertEquals("0", subtractedToZero.getBinaryString());

        // Test subtraction where the second operand is greater
        BinaryNumber subtractedSecondOperandGreater = binaryCalculator.subtract(new BinaryNumber("101"), new BinaryNumber("110"));
        assertEquals("1111", subtractedSecondOperandGreater.getBinaryString());

        // Test subtraction with leading zeros in the result
        BinaryNumber subtractedWithLeadingZeros = binaryCalculator.subtract(new BinaryNumber("1010"), new BinaryNumber("1"));
        assertEquals("1001", subtractedWithLeadingZeros.getBinaryString());
    }

//    @Test
//    void testInvalidInput() {
//        Binary binary = new Binary();
//
//        // Test invalid input for addition
//        try {
//            BinaryNumber addedInvalidInput = binary.add(new BinaryNumber("12"), new BinaryNumber("1101"));
//        } catch (IllegalArgumentException e) {
//            assertEquals("Invalid binary string. Only 0s and 1s are allowed.", e.getMessage());
//        }
//
//        // Test invalid input for subtraction
//        try {
//            BinaryNumber subtractedInvalidInput = binary.subtract(new BinaryNumber("101"), new BinaryNumber("10a"));
//        } catch (IllegalArgumentException e) {
//            assertEquals("Invalid binary string. Only 0s and 1s are allowed.", e.getMessage());
//        }
//    }

    @Test
    void testEdgeCases() {
        BinaryCalculator binaryCalculator = new BinaryCalculator();

        // Test subtraction resulting in zero
        BinaryNumber subtractedToZero = binaryCalculator.subtract(new BinaryNumber("1010"), new BinaryNumber("1010"));
        assertEquals("0", subtractedToZero.getBinaryString());

        // Test addition resulting in longer binary string
        BinaryNumber addedLongerResult = binaryCalculator.add(new BinaryNumber("1111"), new BinaryNumber("1111"));
        assertEquals("11110", addedLongerResult.getBinaryString());
    }
}