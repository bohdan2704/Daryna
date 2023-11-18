public class BinaryNumber {
    private String binaryString;

    public BinaryNumber(String binaryString) {
        // Validate that the input string only contains 0s and 1s
        if (binaryString.matches("[01]+")) {
            this.binaryString = binaryString;
        } else {
            throw new IllegalArgumentException("Invalid binary string. Only 0s and 1s are allowed.");
        }
    }


}