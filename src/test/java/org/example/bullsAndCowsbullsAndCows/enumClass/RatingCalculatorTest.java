package org.example.bullsAndCowsbullsAndCows.enumClass;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * In this test, we create an instance of the `RatingCalculator` class,
 * then call the `calculateRating()` method with various parameters,
 * and check that the returned value matches what we expected with the `assertEquals()` method.
 * Thus, we check that the returned ratings are correctly calculated depending on the given criteria.
 */
public class RatingCalculatorTest {

    @Test
    public void testCalculateRating() {
        RatingCalculator calculator = new RatingCalculator();

        // Тестирование для случая с bitDepth = 3
        RatingCalculator.Rating rating1 = calculator.calculateRating(3, 1, 60);
        assertEquals(RatingCalculator.Rating.Junior, rating1);

        RatingCalculator.Rating rating2 = calculator.calculateRating(3, 6, 30);
        assertEquals(RatingCalculator.Rating.Middle, rating2);

        RatingCalculator.Rating rating3 = calculator.calculateRating(3, 4, 24);
        assertEquals(RatingCalculator.Rating.Senior, rating3);

        // Тестирование для случая с bitDepth = 4
        RatingCalculator.Rating rating4 = calculator.calculateRating(4, 13, 20);
        assertEquals(RatingCalculator.Rating.Junior, rating4);

        RatingCalculator.Rating rating5 = calculator.calculateRating(4, 8, 60);
        assertEquals(RatingCalculator.Rating.Middle, rating5);

        RatingCalculator.Rating rating6 = calculator.calculateRating(4, 6, 45);
        assertEquals(RatingCalculator.Rating.Senior, rating6);

        // Тестирование для случая с bitDepth = 5
        RatingCalculator.Rating rating7 = calculator.calculateRating(5, 17, 130);
        assertEquals(RatingCalculator.Rating.Junior, rating7);

        RatingCalculator.Rating rating8 = calculator.calculateRating(5, 11, 90);
        assertEquals(RatingCalculator.Rating.Middle, rating8);

        RatingCalculator.Rating rating9 = calculator.calculateRating(5, 9, 55);
        assertEquals(RatingCalculator.Rating.Senior, rating9);

        // Тестирование для случая с bitDepth = 6
        RatingCalculator.Rating rating10 = calculator.calculateRating(6, 17, 130);
        assertEquals(RatingCalculator.Rating.Junior, rating10);

        RatingCalculator.Rating rating11 = calculator.calculateRating(6, 11, 80);
        assertEquals(RatingCalculator.Rating.Middle, rating11);

        RatingCalculator.Rating rating12 = calculator.calculateRating(6, 10, 70);
        assertEquals(RatingCalculator.Rating.Senior, rating12);

        // Тестирование для случая с bitDepth = 7
        RatingCalculator.Rating rating13 = calculator.calculateRating(7, 18, 135);
        assertEquals(RatingCalculator.Rating.Junior, rating13);

        RatingCalculator.Rating rating14 = calculator.calculateRating(7, 13, 110);
        assertEquals(RatingCalculator.Rating.Middle, rating14);

        RatingCalculator.Rating rating15 = calculator.calculateRating(7, 11, 85);
        assertEquals(RatingCalculator.Rating.Senior, rating15);
    }
}