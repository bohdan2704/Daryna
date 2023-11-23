import org.junit.Assert;
import org.junit.Test;
import org.example.alternative.RomanSystem;

import static org.junit.Assert.assertEquals;


public class RomanSystemTest {

    private final RomanSystem romanSystem = new RomanSystem();

    @Test
    public void testOne() {
        assertEquals("I", romanSystem.toBase(1));
    }

    @Test
    public void testTwo() {
        assertEquals("II", romanSystem.toBase(2));
    }

    @Test
    public void testThree() {
        assertEquals("III", romanSystem.toBase(3));
    }

    @Test
    public void testFour() {
        assertEquals("IV", romanSystem.toBase(4));
    }

    @Test
    public void testFive() {
        assertEquals("V", romanSystem.toBase(5));
    }

    @Test
    public void testSix() {
        assertEquals("VI", romanSystem.toBase(6));
    }

    @Test
    public void testNine() {
        assertEquals("IX", romanSystem.toBase(9));
    }

    @Test
    public void testTen() {
        assertEquals("X", romanSystem.toBase(10));
    }

    @Test
    public void testThirtyNine() {
        assertEquals("XXXIX", romanSystem.toBase(39));
    }

    @Test
    public void testForty() {
        assertEquals("XL", romanSystem.toBase(40));
    }

    @Test
    public void testFifty() {
        assertEquals("L", romanSystem.toBase(50));
    }

    @Test
    public void testFiftyOne() {
        assertEquals("LI", romanSystem.toBase(51));
    }

    @Test
    public void testNinety() {
        assertEquals("XC", romanSystem.toBase(90));
    }

    @Test
    public void testOneHundred() {
        assertEquals("C", romanSystem.toBase(100));
    }

    @Test
    public void testOneHundredSixty() {
        assertEquals("CLX", romanSystem.toBase(160));
    }

    @Test
    public void testTwoHundredSeven() {
        assertEquals("CCVII", romanSystem.toBase(207));
    }

    @Test
    public void testTwoHundredFortySix() {
        assertEquals("CCXLVI", romanSystem.toBase(246));
    }

    @Test
    public void testFourHundred() {
        assertEquals("CD", romanSystem.toBase(400));
    }

    @Test
    public void testFiveHundred() {
        assertEquals("D", romanSystem.toBase(500));
    }

    @Test
    public void testSevenHundredEightyNine() {
        assertEquals("DCCLXXXIX", romanSystem.toBase(789));
    }

    @Test
    public void testNineHundred() {
        assertEquals("CM", romanSystem.toBase(900));
    }

    @Test
    public void testOneThousand() {
        assertEquals("M", romanSystem.toBase(1000));
    }

    @Test
    public void testOneThousandNine() {
        assertEquals("MIX", romanSystem.toBase(1009));
    }

    @Test
    public void testOneThousandSixtySix() {
        assertEquals("MLXVI", romanSystem.toBase(1066));
    }

    @Test
    public void testOneThousandSevenHundredSeventySix() {
        assertEquals("MDCCLXXVI", romanSystem.toBase(1776));
    }

    @Test
    public void testOneThousandNineHundredEighteen() {
        assertEquals("MCMXVIII", romanSystem.toBase(1918));
    }

    @Test
    public void testOneThousandFiftyFour() {
        assertEquals("MCMLIV", romanSystem.toBase(1954));
    }

    @Test
    public void testTwoThousandFourteen() {
        assertEquals("MMXIV", romanSystem.toBase(2014));
    }

    @Test
    public void testTwoThousandFourHundredTwentyOne() {
        assertEquals("MMCDXXI", romanSystem.toBase(2421));
    }

    @Test
    public void testRomanMax() {
        assertEquals("MMMCMXCIX", romanSystem.toBase(3999));
    }

    @Test
    public void testRomanToArabic() {
        // Test cases for Roman to Arabic conversion
        assertEquals(1, romanSystem.fromBase("I"));
        assertEquals(4, romanSystem.fromBase("IV"));
        assertEquals(9, romanSystem.fromBase("IX"));
        assertEquals(49, romanSystem.fromBase("XLIX"));
        assertEquals(3999, romanSystem.fromBase("MMMCMXCIX"));

        // Additional test cases
        assertEquals(399,romanSystem.fromBase("CCCXCIX"));
        assertEquals(2021, romanSystem.fromBase("MMXXI"));
    }

    @Test
    public void testArabicToRoman() {
        // Test cases for Arabic to Roman conversion
        assertEquals("I", romanSystem.toBase(1));
        assertEquals("IV", romanSystem.toBase(4));
        assertEquals("IX", romanSystem.toBase(9));
        assertEquals("XLIX", romanSystem.toBase(49));
        assertEquals("MMMCMXCIX", romanSystem.toBase(3999));

        // Additional test cases
        assertEquals("CDXCIX", romanSystem.toBase(499));
        assertEquals("MMCMXCIX", romanSystem.toBase(2999));
    }
}
