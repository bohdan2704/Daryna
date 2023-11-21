package org.example;

public enum AlternativeNumeralSystem {

    GOLDEN_SYSTEM(1+Math.sqrt(5)/2 ),
    BINARY_ROOT_SYSTEM(Math.sqrt(2)),
    ONE_SECOND_SYSTEM(1/2.0),
    THREE_SECOND_SYSTEM(3/2.0),
    FIBONACCI_SYSTEM(0);

    private final double base;

    AlternativeNumeralSystem(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

}
