package org.example.alternative;

public class FromBase {
    private static final int ACCURACY = 1_000;
    public static double fromBase(String num, double base) {
        String[] numberSplit = num.split("\\.");
        int numberLength = numberSplit[0].length();

        double output = 0;
        String digits = String.join("", numberSplit);

        for (int i = 0; i < digits.length(); i++) {
            output += Character.getNumericValue(digits.charAt(i)) * Math.pow(base, numberLength - i - 1);
        }

        return (int)(output*ACCURACY)/(double)ACCURACY;
    }
}
