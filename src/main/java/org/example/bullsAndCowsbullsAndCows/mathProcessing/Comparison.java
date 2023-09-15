package org.example.bullsAndCowsbullsAndCows.mathProcessing;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;

import javax.swing.*;

//Класс сравнения рандомного числа и введенного числа
public class Comparison {

    //Поле
    private int numberRandom; //число рандома
    private String numberEnter;   //вводимое число в строчном типе
    private String stringNumberRandom; //число рандома строчного типа
    private int cows;   //собираем  посчитанных коров через цикл
    private int bulls;  //собираем посчитанных Быков через цикл
    private char[] numberRandomChar; //массив для рандомного числа
    private char[] numberEnterChar; //массив для вводимого числа
    private FrameBullsAndCows frameBullsAndCows; // Основной класс. Нужен здесь для привязки как к основному фрейму дополнительного окна "Победа"

    public Comparison(String numberEnter, FrameBullsAndCows frameBullsAndCows) { //конструктор с вводимым числом на входе и с объектом основного фрейма.
        this.numberEnter = numberEnter;
        this.frameBullsAndCows = frameBullsAndCows;

//нужна ещё проверка, что это цифры, но это позже!!!!!!!!!!!!!!!

        numberRandom = frameBullsAndCows.data.getNumberRandom();//тащим рандом из Data
        stringNumberRandom = "" + numberRandom; //конвертировали число рандома в String
        numberRandomChar = stringNumberRandom.toCharArray(); //загнали рандом в массив
        numberEnterChar = numberEnter.toCharArray(); //загнали вводимое число в массив
        bulls = 0;//обнуляем старые данные быков и коров
        cows = 0;

        if (numberRandomChar.length == numberEnterChar.length && numberRandomChar.length >= 3) //проверка разрядности
        {
            for (int i = 0; i < numberRandomChar.length; i++) {
                for (int j = 0; j < numberEnterChar.length; j++) //ищем быков
                {
                    //ищем быков
                    if ((numberRandomChar[i] == numberEnterChar[j]) && (i == j)) //Ищем совпадение значения ячеек и их индекса
                    {
                        bulls++;
                        //и затираем посчитанного быка путём замены на букву
                        numberRandomChar[i] = 'B';
                    }
                }//конец вложенного цикла
            }//конец цикла

            for (int i = 0; i < numberRandomChar.length; i++) {
                for (int j = 0; j < numberEnterChar.length; j++) {
                    //ищем коров
                    if ((numberRandomChar[i] == numberEnterChar[j]) && (i != j)) //Ищем совпадение значения ячеек без совпадения индекса
                    {
                        cows++;
                        //и затираем посчитанную корову путём замены на букву
                        numberRandomChar[i] = 'C';
                    }
                }//конец  цикла
            }//конец цикла

//тут мы закинем в data быков
            frameBullsAndCows.data.setBulls(bulls);
//тут мы закинем в data коров
            frameBullsAndCows.data.setCows(cows);
        } else {
//окно предупреждения о не совпадении разрядности чисел. Оно не совпадёт в том случае, если не была выбрана разрядность и в этом случае не будет загадано число рандома.
            /**
             * JOptionPane Тут мы открываем окно с дополнительной информацией warning
             * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
             * Аргументы:
             * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
             * warning - текст сообщения
             * "Сообщение" - заголовок
             * JOptionPane.INFORMATION_MESSAGE -
             */
            String warning = " Проверьте разрядность числа. \n В вашем числе либо больше\n цифр, либо меньше.\n Либо вы его ещё не загадали. ";
            JOptionPane.showMessageDialog(frameBullsAndCows, warning, "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
    }//конец конструктора
}//конец класса
