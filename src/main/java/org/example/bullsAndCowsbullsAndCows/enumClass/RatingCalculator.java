package org.example.bullsAndCowsbullsAndCows.enumClass;

public class RatingCalculator {
    public enum Rating {
        Junior,
        Middle,
        Senior
    }

    public Rating calculateRating(int bitDepth, int attempts, long times) {
        switch (bitDepth) {
            case 3:
                if (attempts <= 5 && times <= 25) {
                    return Rating.Senior;
                } else if (attempts <= 8 && times <= 45) {
                    return Rating.Middle;
                } else if (attempts > 8 || times > 45) {
                    return Rating.Junior;
                }
                break;
            case 4:
                if (attempts <= 7 && times <= 50) {
                    return Rating.Senior;
                } else if (attempts <= 12 && times <= 80) {
                    return Rating.Middle;
                } else if (attempts > 12 || times > 80) {
                    return Rating.Junior;
                }
                break;
            case 5:
                if (attempts <= 10 && times <= 60) {
                    return Rating.Senior;
                } else if (attempts <= 15 && times < 110) {
                    return Rating.Middle;
                } else if (attempts > 15 && times > 110) {
                    return Rating.Junior;
                }
                break;
            case 6:
                if (attempts <= 11 && times <= 80) {
                    return Rating.Senior;
                } else if (attempts <= 16 && times <= 120) {
                    return Rating.Middle;
                } else if (attempts > 16 || times > 120) {
                    return Rating.Junior;
                }
                break;
            case 7:
                if (attempts <= 12 && times <= 90) {
                    return Rating.Senior;
                } else if (attempts <= 17 && times <= 130) {
                    return Rating.Middle;
                } else if (attempts > 17 && times > 130) {
                    return Rating.Junior;
                }
                break;
        }
        throw new IllegalArgumentException("Invalid criteria");
    }
}
