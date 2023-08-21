package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.mathProcessing.Comparison;
import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.data.Data;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHistory;

import javax.swing.*;
import java.awt.*;

public class ButtonOK extends JButton {
    private TextField numberEnter;  //поле для ввода цифр
    private String CowsResult; //Строковая переменная
    private String BullsResult; //Строковая переменная
    private JLabel lblCowsResult;        //лейбл количества Коров
    private JLabel lblBullsResult;       //лейбл количества Быков
    private String randomNumberStory = "";    //Строковая переменная
    private JLabel lblCounter;     //лейбл количества попыток
    private TableModelHistory tableModelHistory; //Класс, который является моделью, принимающей данные истории попыток
    private FrameBullsAndCows frameBullsAndCows; // Основной класс. Нужен здесь для привязки как к основному фрейму дополнительного окна "Победа" в new Comparison

    public ButtonOK(TextField numberEnter, JLabel lblCowsResult, JLabel lblBullsResult, JLabel lblCounter, TableModelHistory tableModelHistory, FrameBullsAndCows frameBullsAndCows) {
        this.numberEnter = numberEnter;
        this.lblCowsResult = lblCowsResult;
        this.lblBullsResult = lblBullsResult;
        this.lblCounter = lblCounter;
        this.tableModelHistory = tableModelHistory;
        this.frameBullsAndCows = frameBullsAndCows;

        setText("OK");

        addActionListener(e -> {
            frameBullsAndCows.data.setNumberEnter(numberEnter.getText());//забираем вводимое число текстовой строкой и кидаем в класс данных
            new Comparison(frameBullsAndCows.data.getNumberEnter(), frameBullsAndCows); //вызвали класс сравнения, с введенным числом на входе и с объектом основного фрейма для дополнительного окна "Победа"
            CowsResult = "Поймано Коров " + frameBullsAndCows.data.getCows(); //Строковая переменная с обновлённым результатом пойманных коров
            BullsResult = "Поймано Быков " + frameBullsAndCows.data.getBulls(); //Строковая переменная с обновлённым результатом пойманных быков
            lblCowsResult.setText(CowsResult); //вывели на лейбл под рисунком сколько было поймано коров
            lblBullsResult.setText(BullsResult);//вывели на лейбл под рисунком сколько было поймано быков

//заполняем таблицу историй попыток
            // Получаем новые данные: Data.numberEnter, Data.bulls и Data.cows
            Object[] newData = {frameBullsAndCows.data.getNumberEnter(), frameBullsAndCows.data.getBulls(), frameBullsAndCows.data.getCows()};
            // Получаем текущее количество строк в модели таблицы
            int rowCount = tableModelHistory.getRowCount();
            // Создаём новый массив данных, увеличив его размер на 1 строчку
            Object[][] updatedData = new Object[rowCount + 1][3];
            // Скопируем текущие данные в новый массив
            for (int i = 0; i < rowCount; i++) {
                updatedData[i] = new Object[]{
                        tableModelHistory.getValueAt(i, 0),
                        tableModelHistory.getValueAt(i, 1),
                        tableModelHistory.getValueAt(i, 2)
                };
            }
            // Добавляем новые данные в последнюю строку нового массива
            updatedData[rowCount] = newData;
            // Обновляем модель таблицы с новыми данными
            tableModelHistory.updateData(updatedData);

//меняем счётчик попыток
            frameBullsAndCows.data.incrementCounter();//количество попыток отправили в базу данных
            lblCounter.setText("" + frameBullsAndCows.data.getIntCounter());//вывели на лейбл текущее количество попыток и конвертировали в String путём конкатенации.
        });
    }
}
