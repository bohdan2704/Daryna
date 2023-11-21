package org.example.alternative;

import org.example.numeric.Number;
import org.example.numeric.NumeralSystem;
import org.example.operations.BinaryNumber;

public class SquareRootBase {
    public String getNumber(int number) {
        Number num = new Number(number);
        String binaryNumber = num.toSpecifiedNumeralSystem(NumeralSystem.BINARY);
    }
}
