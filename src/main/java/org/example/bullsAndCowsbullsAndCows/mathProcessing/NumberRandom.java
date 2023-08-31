package org.example.bullsAndCowsbullsAndCows.mathProcessing;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;

// Задача класса нарандомить число и вернуть его
public class NumberRandom {
    public NumberRandom(int a, FrameBullsAndCows frameBullsAndCows) {
        //теперь кусок кода рандома!!!!!!!!!!!!!!
        if (a == 3) {
            //генерируем случайное трёхзначное число и закидываем рандомное число в класс данных Data
            frameBullsAndCows.data.setNumberRandom(100 + (int) (Math.random() * 900));
        }
        if (a == 4) {
            //генерируем случайное четырёхзначное число и закидываем рандомное число в класс данных Data
            frameBullsAndCows.data.setNumberRandom(1000 + (int) (Math.random() * 9000));
        }
        if (a == 5) {
            //генерируем случайное пятизначное число и закидываем рандомное число в класс данных Data
            frameBullsAndCows.data.setNumberRandom(10000 + (int) (Math.random() * 90000));
        }
        if (a == 6) {
            //генерируем случайное шестизначное число и закидываем рандомное число в класс данных Data
            frameBullsAndCows.data.setNumberRandom(100000 + (int) (Math.random() * 900000));
        }
        if (a == 7) {
            //генерируем случайное семизначное число и закидываем рандомное число в класс данных Data
            frameBullsAndCows.data.setNumberRandom(1000000 + (int) (Math.random() * 9000000));
        }
        //Закидываем разрядность в класс данных Data
        frameBullsAndCows.data.setBitDepth(a);
    }
}

