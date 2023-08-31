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

        if (numberRandomChar.length == numberEnterChar.length)//проверка разрядности
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
//окно предупреждения о не совпадении разрядности чисел
            /**
             * JOptionPane Тут мы открываем окно с дополнительной информацией warning
             * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
             * Аргументы:
             * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
             * warning - текст сообщения
             * "Сообщение" - заголовок
             * JOptionPane.INFORMATION_MESSAGE -
             */
            String warning = " Проверьте разрядность числа. \n В вашем числе либо больше\n цифр, либо меньше. ";
            JOptionPane.showMessageDialog(frameBullsAndCows, warning, "Ошибка", JOptionPane.INFORMATION_MESSAGE);
        }
//// условие автостопа таймера: это быки == разрядности
//// и значение быков не нулевое как в начале игры, потому что разрядность тоже нулевая в начале игры.
//        if ((frameBullsAndCows.data.getBulls() == frameBullsAndCows.data.getBitDepth()) && (frameBullsAndCows.data.getBulls() != 0)) { // Остановка таймера и окно поздравления с победой
//            frameBullsAndCows.jpTimer.stopTimer(); // Остановка таймера
//            frameBullsAndCows.data.setMis(frameBullsAndCows.jpTimer.getMilliseconds());
//            frameBullsAndCows.data.setSec(frameBullsAndCows.jpTimer.getSeconds());
//            frameBullsAndCows.data.setMin(frameBullsAndCows.jpTimer.getMinutes());
//            frameBullsAndCows.data.setHour(frameBullsAndCows.jpTimer.getHours());
//// окно поздравления с победой
//            new Victory(frameBullsAndCows); // Заполняем переменную Data.victory актуальными данными.
//            /**
//             * JOptionPane Тут мы открываем окно с дополнительной информацией Victory
//             * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
//             * Аргументы:
//             * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
//             * Data.notation - текст сообщения
//             * "Сообщение" - заголовок
//             * JOptionPane.INFORMATION_MESSAGE -
//             */
//            JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getVictory(), "Победа", JOptionPane.INFORMATION_MESSAGE);
//
//            // ..... и тут запись куда-то результата.... нужно дописать код (таблица рекордов!) .....
//        }
    }//конец конструктора
}//конец класса
