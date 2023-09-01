package org.example.bullsAndCowsbullsAndCows.enumClass;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RatingCalculatorTest {

    @Test
    public void testCalculateRating() {
        RatingCalculator calculator = new RatingCalculator();

        // Тестирование для случая с bitDepth = 3
        RatingCalculator.Rating rating1 = calculator.calculateRating(3, 20, 150);
        assertEquals(RatingCalculator.Rating.JUNIOR, rating1);

        RatingCalculator.Rating rating2 = calculator.calculateRating(3, 10, 60);
        assertEquals(RatingCalculator.Rating.MIDDLE, rating2);

        RatingCalculator.Rating rating3 = calculator.calculateRating(3, 4, 40);
        assertEquals(RatingCalculator.Rating.SENIOR, rating3);

        // Тестирование для случая с bitDepth = 4
        RatingCalculator.Rating rating4 = calculator.calculateRating(4, 25, 250);
        assertEquals(RatingCalculator.Rating.JUNIOR, rating4);

        RatingCalculator.Rating rating5 = calculator.calculateRating(4, 12, 120);
        assertEquals(RatingCalculator.Rating.MIDDLE, rating5);

        RatingCalculator.Rating rating6 = calculator.calculateRating(4, 5, 80);
        assertEquals(RatingCalculator.Rating.SENIOR, rating6);

        // Тестирование для случая с bitDepth = 5
        RatingCalculator.Rating rating7 = calculator.calculateRating(5, 30, 300);
        assertEquals(RatingCalculator.Rating.JUNIOR, rating7);

        RatingCalculator.Rating rating8 = calculator.calculateRating(5, 15, 180);
        assertEquals(RatingCalculator.Rating.MIDDLE, rating8);

        RatingCalculator.Rating rating9 = calculator.calculateRating(5, 6, 120);
        assertEquals(RatingCalculator.Rating.SENIOR, rating9);

        // Тестирование для случая с bitDepth = 6
        RatingCalculator.Rating rating10 = calculator.calculateRating(6, 35, 400);
        assertEquals(RatingCalculator.Rating.JUNIOR, rating10);

        RatingCalculator.Rating rating11 = calculator.calculateRating(6, 18, 250);
        assertEquals(RatingCalculator.Rating.MIDDLE, rating11);

        RatingCalculator.Rating rating12 = calculator.calculateRating(6, 8, 180);
        assertEquals(RatingCalculator.Rating.SENIOR, rating12);

        // Тестирование для случая с bitDepth = 7
        RatingCalculator.Rating rating13 = calculator.calculateRating(7, 40, 450);
        assertEquals(RatingCalculator.Rating.JUNIOR, rating13);

        RatingCalculator.Rating rating14 = calculator.calculateRating(7, 23, 300);
        assertEquals(RatingCalculator.Rating.MIDDLE, rating14);

        RatingCalculator.Rating rating15 = calculator.calculateRating(7, 9, 200);
        assertEquals(RatingCalculator.Rating.SENIOR, rating15);
    }
}