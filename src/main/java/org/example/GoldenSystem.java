package org.example;

import java.util.ArrayList;
import java.util.List;

public class GoldenSystem {
    private static final double PHI = 1.618033988749894848204586834;
    private static final double APROXIMATION = 10E-6;
    private static final double UPPER_APROXIMATION = 10E6;


    public static String getGoldenRatioNumber(double num) {
        List<Integer> powersList = new ArrayList<>();
        while (num > APROXIMATION) {
            int phiPower = findPhiPowerThanLessOrEqual(num);
            powersList.add(phiPower);
            num -= Math.pow(PHI, phiPower);
        }

        return formNumberInGoldenBase(powersList);
    }

    private static int findPhiPowerThanLessOrEqual(double num) {
        int k = 1; // Starting base power is 1
        double phiInKPower = PHI;
        if (num > PHI) {
            while (phiInKPower*PHI < num) {
                phiInKPower *= PHI;
                k++;
            }
            return k;
        }

        // If we cannot take phi^1 phi^2, phi^3 try subtract just phi^0 or simplest one :)
        if (num - 1 > 0) {
            return 0;
        }

        if (num < PHI) {
            k = -1; // Starting base power is 1
            phiInKPower = 1/PHI;
            double multiplier = 1/PHI;
            while (phiInKPower * multiplier > num) {
                phiInKPower *= multiplier;
                k--;
            }
//            if ((int)(phiInKPower*multiplier*UPPER_APROXIMATION) == (int)(num*UPPER_APROXIMATION)) {
//                return k-1;
//            }
            // Because we are working with fractional numbers, not integers
//            if (k==-1) {
//                return k-1;
//            } else {
//                return k;
//            }
            return k;
        }
        System.out.println("It is just 1 in golden base system");
        return 1;
    }

    private static String formPhiBaseNumberBasedOnPowers(List<Integer> listOfPowers) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < listOfPowers.size()-1; i++) {
            b.append(1);
            int currentPower = listOfPowers.get(i);
            int nextPower = listOfPowers.get(i+1);
            if (currentPower == nextPower) {
                // Catching misleading powers, they are the same because of double approximation
                throw new RuntimeException("Powers are the same, somehow this can lead to an error!");
            } else if (nextPower == 0) {
                b.append("0".repeat(currentPower-1));
                b.append("1");
                b.append(".");
                continue;
            }
            else if (currentPower > 0 && nextPower < 0) {
                // Same times number as power because we have 0 power too
                b.append("0".repeat(currentPower));
                b.append(".");
                // Decrement one from zeroes quantity, because -1 pow does not require 0
                // Still 1 pow require one zero before )
                int numberOfZeroesAfterPoint = Math.abs(nextPower)-1;
                b.append("0".repeat(numberOfZeroesAfterPoint));
                continue;
            }
            int delta = Math.abs(currentPower - nextPower);
            for (int k = 0; k < delta; k++) {
                b.append(0);
            }
        }
        b.append(1);

        return b.toString();
    }

    private static String formNumberInGoldenBase(List<Integer> listOfPowers) {
        StringBuilder b = new StringBuilder();

        // We have the smallest number, lets work with it
        int incrementValueToGetOnlyPositiveIndexes = listOfPowers.getLast();
        if (incrementValueToGetOnlyPositiveIndexes < 0) {
            // Always true because PHI system always has negative powers
            listOfPowers.replaceAll(integer -> integer + -incrementValueToGetOnlyPositiveIndexes);
        }

        for (int i = listOfPowers.getFirst(); i >= 0; i--) {
            // So we have zero index

            if (listOfPowers.contains(i)) {
                b.append(1);
            } else {
                b.append(0);
            }
            if (i == -incrementValueToGetOnlyPositiveIndexes) {
                b.append(".");
            }
        }
        return b.toString();
    }
}
