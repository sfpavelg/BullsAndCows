package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.Comparsion;
import org.example.bullsAndCowsbullsAndCows.Data;

import javax.swing.*;
import java.awt.*;

public class ButtonOK extends JButton {
    private TextField numberEnter;  //поле для ввода цифр
    private String CowsResult; //Строковая переменная
    private String BullsResult; //Строковая переменная
    private JLabel lblCowsResult;        //лейбл количества Коров
    private JLabel lblBullsResult;       //лейбл количества Быков
    private String randomNumberStory = "";    //Строковая переменная
    private JTextArea textAreaStory; //поле истории попыток
    private int intCounter = 0; //переменная счётчика попыток
    private JLabel lblCounter;           //лейбл количества попыток

    public  ButtonOK(TextField numberEnter, JLabel lblCowsResult, JLabel lblBullsResult, JTextArea textAreaStory, JLabel lblCounter) {
        this.numberEnter = numberEnter;
        this.lblCowsResult = lblCowsResult;
        this.lblBullsResult = lblBullsResult;
        this.textAreaStory = textAreaStory;
        this.lblCounter = lblCounter;

        setText("OK");

         addActionListener(e -> {
            Data.numberEnter = numberEnter.getText();//забираем вводимое число текстовой строкой и кидаем в класс данных
            new Comparsion(Data.numberEnter); //вызвали класс сравнения, с введенным числом на входе
            CowsResult = "Поймано Коров " + Data.cows; //Строковая переменная с результатом  пойманных коров
            BullsResult = "Поймано Быков " + Data.bulls; //Строковая переменная с результатом пойманных быков
            lblCowsResult.setText(CowsResult); //вывели на лэйбл пойманных коров
            lblBullsResult.setText(BullsResult);//вывели на лэйбл пойманных быков
//заполняем историю попыток
            randomNumberStory = randomNumberStory + "\n" + Data.numberEnter + "    " + Data.bulls + "  " + Data.cows;
            textAreaStory.setText(randomNumberStory);
            intCounter++; //увеличили переменную числа попыток на +1
            Data.intCounter = intCounter;//количество попыток отправили в базу данных
            lblCounter.setText("" + intCounter);//вывели на лэбл текущее количество попыток и конвертировали в String путём конкатинации.
        });

    }


}
