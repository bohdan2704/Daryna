package org.example.numeric;

public enum NumeralSystem {
    BINARY(2),
    OCTAL(8),
    DECIMAL(10),
    HEXADECIMAL(16),
    QUATERNARY_4(4),
    QUINARY_5(5),
    SENARY_6(6),
    SEPTENARY_7(7),
    NONARY_9(9),
    UNARYDINARY_11(11),
    DUODECIMAL_12(12),
    TRIDECIMAL_13(13),
    TETRADECIMAL_14(14),
    PENTADECIMAL_15(15),
    HEPTADECIMAL_17(17),
    OCTODECIMAL_18(18),
    NONADECIMAL_19(19),
    VIGESIMAL_20(20),
    UNVIGESIMAL_21(21),
    DUOVIGESIMAL_22(22),
    TRIVIGESIMAL_23(23),
    TETRAVIGESIMAL_24(24),
    PENTAVIGESIMAL_25(25),
    HEXAVIGESIMAL_26(26),
    HEPTAVIGESIMAL_27(27),
    OCTOVIGESIMAL_28(28),
    ENNEAVIGESIMAL_29(29),
    TRIGESIMAL_30(30),
    UNTRIGESIMAL_31(31),
    DUOTRIGESIMAL_32(32),
    TRIOTRIGESIMAL_33(33),
    TETRATRIGESIMAL_34(34),
    PENTATRIGESIMAL_35(35),
    HEXATRIGESIMAL_36(36);

    private final int base;

    NumeralSystem(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

}
