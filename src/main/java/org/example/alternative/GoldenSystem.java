package org.example.alternative;

import java.util.ArrayList;
import java.util.List;

public class GoldenSystem implements NumeralSystemInterface {
    public static final double PHI = 1.618033988749894848204586834;
    private static final double PHI_NEGATIVE = 1/PHI;
    private static final double APROXIMATION = 10E-3;
    private static final double UPPER_APROXIMATION = 10E3;

    @Override
    public String toBase(double num) {
        double doubleNum = num;
        List<Integer> powersList = new ArrayList<>();
        while (doubleNum > APROXIMATION) {
            int phiPower = findPhiPowerThanLessOrEqual(doubleNum);
            powersList.add(phiPower);
            doubleNum -= Math.pow(PHI, phiPower);
        }

        return formNumberBasedOnPowers(powersList);
    }

    @Override
    public double fromBase(String num) {
        return FromBase.fromBase(num, PHI);
    }

    private int findPhiPowerThanLessOrEqual(double num) {
        int k = 1; // Starting base power is 1
        double phiInKPower = PHI;
        if (num > PHI) {
            while (phiInKPower*PHI < num) {
                phiInKPower *= PHI;
                k++;
            }
            return k;
        }

        // If we cannot take phi^1 phi^2, phi^3 try subtract just phi^0 then phi^-1 :)

        else if (num < PHI) {
            // Starting base power is 0
            k = 0;
            phiInKPower = 1;
            // Catching 0 power base, then continue to -1
            while ( num - phiInKPower < 0 ) {
                if ((int)(phiInKPower*UPPER_APROXIMATION) == (int)(num*UPPER_APROXIMATION)) {
                    return k;
                }
                phiInKPower *= PHI_NEGATIVE;
                k--;
            }
            return k;
        }
        else {
            return 1;
        }
    }

    public String formNumberBasedOnPowers(List<Integer> listOfPowers) {
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
