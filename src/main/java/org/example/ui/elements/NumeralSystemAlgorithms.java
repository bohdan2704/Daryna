package org.example.ui.elements;

import org.example.alternative.*;

import java.util.HashMap;

public class NumeralSystemAlgorithms {
    private static final HashMap<AlternativeNumeralSystem, NumeralSystemInterface> commandMap = new HashMap<>();

    static {
        commandMap.put(AlternativeNumeralSystem.FIBONACCI_SYSTEM, new FibonacciSystem());
        commandMap.put(AlternativeNumeralSystem.GOLDEN_SYSTEM, new GoldenSystem());
        commandMap.put(AlternativeNumeralSystem.UNARY_SYSTEM, new UnarySystem());
        commandMap.put(AlternativeNumeralSystem.SQUARE_ROOT_SYSTEM, new SquareRootBase());
        commandMap.put(AlternativeNumeralSystem.IMPERIAL_SYSTEM, new RomanSystem());
    }

    public static String convert(AlternativeNumeralSystem numeralSystem, double inputValue) {
        return commandMap.get(numeralSystem).toBase(inputValue);
    }

    public static double reverseConvert(AlternativeNumeralSystem numeralSystem, String numInAlternativeSystem) {
        return commandMap.get(numeralSystem).fromBase(numInAlternativeSystem);
    }
}
