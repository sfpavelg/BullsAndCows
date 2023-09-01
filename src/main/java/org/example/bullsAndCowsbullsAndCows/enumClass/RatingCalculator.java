package org.example.bullsAndCowsbullsAndCows.enumClass;

public class RatingCalculator {
    public enum Rating {
        JUNIOR,
        MIDDLE,
        SENIOR
    }

    public Rating calculateRating(int bitDepth, int attempts, int times) {
        switch (bitDepth) {
            case 3:
                if (attempts > 15 && times > 100) {
                    return Rating.JUNIOR;
                } else if (attempts > 5 && attempts < 15 && times > 50 && times < 100) {
                    return Rating.MIDDLE;
                } else if (attempts < 5 && times < 50) {
                    return Rating.SENIOR;
                }
                break;
            case 4:
                if (attempts > 20 && times > 150) {
                    return Rating.JUNIOR;
                } else if (attempts > 7 && attempts < 20 && times > 100 && times < 150) {
                    return Rating.MIDDLE;
                } else if (attempts < 7 && times < 100) {
                    return Rating.SENIOR;
                }
                break;
            case 5:
                if (attempts > 25 && times > 200) {
                    return Rating.JUNIOR;
                } else if (attempts > 8 && attempts < 25 && times > 150 && times < 200) {
                    return Rating.MIDDLE;
                } else if (attempts < 8 && times < 150) {
                    return Rating.SENIOR;
                }
                break;
            case 6:
                if (attempts > 30 && times > 300) {
                    return Rating.JUNIOR;
                } else if (attempts > 9 && attempts < 30 && times > 200 && times < 300) {
                    return Rating.MIDDLE;
                } else if (attempts < 9 && times < 200) {
                    return Rating.SENIOR;
                }
                break;
            case 7:
                if (attempts > 35 && times > 350) {
                    return Rating.JUNIOR;
                } else if (attempts > 10 && attempts < 35 && times > 250 && times < 350) {
                    return Rating.MIDDLE;
                } else if (attempts < 10 && times < 250) {
                    return Rating.SENIOR;
                }
                break;
        }

        throw new IllegalArgumentException("Invalid criteria");
    }
}
