package org.example.ui.elements;

import org.example.alternative.AlternativeNumeralSystem;
import org.example.alternative.FibonacciSystem;
import org.example.alternative.FractionalSystem;
import org.example.alternative.NumeralSystemInterface;

import java.util.HashMap;

public class NumeralSystemAlgorithms {
    private static final HashMap<AlternativeNumeralSystem, NumeralSystemInterface> commandMap = new HashMap<>();

    static {
        commandMap.put(AlternativeNumeralSystem.FIBONACCI_SYSTEM, new FibonacciSystem());
        commandMap.put(AlternativeNumeralSystem.FRACTIONAL_SYSTEM, new FractionalSystem());
    }

    public static String convert(AlternativeNumeralSystem numeralSystem, double inputValue, double baseInputValue) {
        return commandMap.get(numeralSystem).toBase(inputValue, baseInputValue);
    }

    public static double reverseConvert(AlternativeNumeralSystem numeralSystem, String numInAlternativeSystem, double baseInputValue) {
        return commandMap.get(numeralSystem).fromBase(numInAlternativeSystem, baseInputValue);
    }
}