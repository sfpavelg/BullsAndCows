package org.example.bullsAndCowsbullsAndCows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

//Класс сравнения рандомного числа и введенного числа
public class Comparsion {

    //Поле
    int numberRandom; //число рандома
    String numberEnter;   //вводимое число в строчном типе
    String stringNumberRandom; //число рандома строчного типа
    int cows;   //собираем  посчитанных коров через цикл
    int bulls;  //собираем посчитанных Быков через цикл
    char[] numberRandomChar; //массив для рандомного числа
    char[] numberEnterChar; //массив для вводимого числа

    public Comparsion(String numberEnter){ //конструктор с вводимым числом на входе
        this.numberEnter=numberEnter;
//нужна ещё проверка что это цифры,но это позже!!!!!!!!!!!!!!!

        numberRandom=Data.numberRandom;//тащим рандом из Data
        stringNumberRandom = ""+numberRandom; //конвертировали число рандома в String
        numberRandomChar = stringNumberRandom.toCharArray(); //загнали рандом в массив
        numberEnterChar = numberEnter.toCharArray(); //загнали вводимое число в массив
        bulls=0;//обнуляем старые данные быков и коров
        cows=0;

        if (numberRandomChar.length == numberEnterChar.length)//проверка разрядности
        {

            for (int i = 0; i < numberRandomChar.length; i++)
            {
                for (int j = 0; j < numberEnterChar.length; j++) //ищем быков
                {
                    //ищем быков
                    if ((numberRandomChar[i] == numberEnterChar[j]) && (i==j)) //Ищем совпадение значения ячеек и их индекса
                    {
                        bulls++;
                        //и затираем посчитанного быка путём замены на букву
                        numberRandomChar[i]='B';
                    }
                }//конец вложенного цикла
            }//конец цыкла


            for (int i = 0; i < numberRandomChar.length; i++)
            {
                for (int j = 0; j < numberEnterChar.length; j++)
                {
                    //ищем коров
                    if ((numberRandomChar[i] == numberEnterChar[j]) && (i!= j)) //Ищем совпадение значения ячеек без совпадения индекса
                    {
                        cows++;
                        //и затираем посчитанную корову путём замены на букву
                        numberRandomChar[i]='C';
                    }
                }//конец вложенного цикла
            }//конец цыкла

//тут мы закинем в data быков
            Data.bulls=bulls;
//тут мы закинем в data коров
            Data.cows=cows;

//временное окно результатов быков и коров
//JFrame jn = new JFrame("Проверьте разрядность!");
//jn.setDefaultCloseOperation(JFrame. DISPOSE_ON_CLOSE);//завершение программы при закрытии окна
//jn.setBounds(500,150,200,190); //размер окна и местоположение на экране
//jn.setResizable(false); //размер окна нельзя изменить
//JTextArea jTextArea2 = new JTextArea();
//String f=Data.bulls + "      " + Data.cows +"\n"+ stringNumberRandom +"\n"+ new String//(numberRandomChar) + "\n" + new String(numberEnterChar);
//jTextArea2.setText(f);
//jTextArea2.setEditable(false);
//jn.add(jTextArea2);
//jn.setVisible(true);
//конец временного

        } else {
//окно предупреждения о не совпадении разрядности чисел
            JFrame jn = new JFrame("Проверьте разрядность!");
            jn.setDefaultCloseOperation(JFrame. DISPOSE_ON_CLOSE);//завершение программы при закрытии окна
            jn.setBounds(500,300,200,190); //размер окна и местоположение на экране
            jn.setResizable(false); //размер окна нельзя изменить
            JTextArea jTextArea2 = new JTextArea();
            String f=" Проверьте разрядность числа. \n В вашем числе либо больше\n цифр, либо меньше. ";
            jTextArea2.setText(f);
            jTextArea2.setEditable(false);
            jn.add(jTextArea2);
            jn.setVisible(true);
        }

        if ((Data.bulls == Data.bitDepth) && (Data.bulls != 0)) { //остановка таймера и окно поздравления с победой
//условие автостопа таймера это быки равно разрядности
//и значение быков не нулевое как в начале игры, потомучто разрядность тоже нулевая в начале игры.
            FrameBullsAndCows.stopWatch.stopStopWatch();//остановка таймера
            //и тут запись куда-то результата.... нужно дописать код (таблица рекордов!)

//окно поздравления с победой
            JFrame jn = new JFrame("БИНГО!");
            jn.setDefaultCloseOperation(JFrame. DISPOSE_ON_CLOSE);//завершение программы при закрытии окна
            jn.setBounds(500,300,245,140); //размер окна и местоположение на экране
            jn.setResizable(false); //размер окна нельзя изменить
            JTextArea jTextArea2 = new JTextArea();
            String f="  *********************************************" +
                    "\n                          Победа!!!!" +
                    "\n               Все БЫКИ пойманы!" +
                    "\n Вы отгадали все цифры, в количестве:" + Data.bulls + " !" +
                    "\n          Вами было сделано " + (1+Data.intCounter) + " попыток!!!"+ "" +
                    "\n            Время прохождения: " + Data.hour+":"+Data.min+":"+Data.sec+":"+Data.mis + "" +
                    "\n  *********************************************";

            jTextArea2.setText(f);
            jTextArea2.setEditable(false);
            jn.add(jTextArea2);
            jn.setVisible(true);
        }

    }//конец метода
}//конец класса
