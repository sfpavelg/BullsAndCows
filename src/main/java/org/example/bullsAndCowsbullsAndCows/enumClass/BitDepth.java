package org.example.bullsAndCowsbullsAndCows.enumClass;

import java.util.Arrays;

public enum BitDepth {
    трёхзначное(3),
    четырёхзначное(4),
    пятизначное(5),
    шестизначное(6),
    семизначное(7);
    private int value;

    BitDepth(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BitDepth findByValueBitDepth(int value) {
        return Arrays.stream(values()).filter(item -> item.getValue() == value).findFirst().orElse(null);
    }
}
