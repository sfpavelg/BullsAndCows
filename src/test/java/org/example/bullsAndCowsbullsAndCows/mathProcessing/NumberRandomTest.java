package org.example.bullsAndCowsbullsAndCows.mathProcessing;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This test verifies that when a `NumberRandom` instance is created for a given bit depth,
 * the value of `NumberRandom` in the `Data` class is in the correct range for the given bit depth.
 * It also checks that the bit depth value (`BitDepth`) in `Data` matches the given bit depth.
 *
 * Note that this example uses the `FrameBullsAndCows` object created with the `setUp()` method before each test.
 */
public class NumberRandomTest {
    private FrameBullsAndCows frameBullsAndCows;

    @Before
    public void setUp() {
        frameBullsAndCows = new FrameBullsAndCows();
    }

    @Test
    public void testNumberRandomWithThreeDigits() {
        NumberRandom numberRandom = new NumberRandom(3, frameBullsAndCows);
        int numberRandomValue = frameBullsAndCows.data.getNumberRandom();
        assertEquals(3, frameBullsAndCows.data.getBitDepth());
        assertTrue(numberRandomValue >= 100 && numberRandomValue <= 999);
        System.out.println("A three-digit number is guessed: " + numberRandomValue);
    }

    @Test
    public void testNumberRandomWithFourDigits() {
        NumberRandom numberRandom = new NumberRandom(4, frameBullsAndCows);
        int numberRandomValue = frameBullsAndCows.data.getNumberRandom();
        assertEquals(4, frameBullsAndCows.data.getBitDepth());
        assertTrue(numberRandomValue >= 1000 && numberRandomValue <= 9999);
        System.out.println("A four-digit number is guessed: " + numberRandomValue);
    }

    @Test
    public void testNumberRandomWithFiveDigits() {
        NumberRandom numberRandom = new NumberRandom(5, frameBullsAndCows);
        int numberRandomValue = frameBullsAndCows.data.getNumberRandom();
        assertEquals(5, frameBullsAndCows.data.getBitDepth());
        assertTrue(numberRandomValue >= 10000 && numberRandomValue <= 99999);
        System.out.println("A five-digit number is guessed: " + numberRandomValue);
    }

    @Test
    public void testNumberRandomWithSixDigits() {
        NumberRandom numberRandom = new NumberRandom(6, frameBullsAndCows);
        int numberRandomValue = frameBullsAndCows.data.getNumberRandom();
        assertEquals(6, frameBullsAndCows.data.getBitDepth());
        assertTrue(numberRandomValue >= 100000 && numberRandomValue <= 999999);
        System.out.println("A six-digit number is guessed: " + numberRandomValue);
    }

    @Test
    public void testNumberRandomWithSevenDigits() {
        NumberRandom numberRandom = new NumberRandom(7, frameBullsAndCows);
        int numberRandomValue = frameBullsAndCows.data.getNumberRandom();
        assertEquals(7, frameBullsAndCows.data.getBitDepth());
        assertTrue(numberRandomValue >= 1000000 && numberRandomValue <= 9999999);
        System.out.println("A seven-digit number is guessed: " + numberRandomValue);
    }

}
