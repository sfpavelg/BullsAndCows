package org.example.bullsAndCowsbullsAndCows.enumClass;

import java.util.Arrays;

public enum HighScoreTableName {
    highScoreBitDepth3(3),
    highScoreBitDepth4(4),
    highScoreBitDepth5(5),
    highScoreBitDepth6(6),
    highScoreBitDepth7(7);
    private int value;

    HighScoreTableName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HighScoreTableName findByValueHighScoreTableName(int value) {
        return Arrays.stream(values()).filter(item -> item.getValue() == value).findFirst().orElse(null);
    }
}
