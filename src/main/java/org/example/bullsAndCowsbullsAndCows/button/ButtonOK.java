package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.Comparsion;
import org.example.bullsAndCowsbullsAndCows.data.Data;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelStory;

import javax.swing.*;
import java.awt.*;

public class ButtonOK extends JButton {
    private TextField numberEnter;  //поле для ввода цифр
    private String CowsResult; //Строковая переменная
    private String BullsResult; //Строковая переменная
    private JLabel lblCowsResult;        //лейбл количества Коров
    private JLabel lblBullsResult;       //лейбл количества Быков
    private String randomNumberStory = "";    //Строковая переменная
    private int intCounter = 0;    //переменная счётчика попыток
    private JLabel lblCounter;     //лейбл количества попыток
    private TableModelStory tableModel; //Класс, который является моделью, принимающей данные истории попыток

    public ButtonOK(TextField numberEnter, JLabel lblCowsResult, JLabel lblBullsResult, JLabel lblCounter, TableModelStory tableModel) {
        this.numberEnter = numberEnter;
        this.lblCowsResult = lblCowsResult;
        this.lblBullsResult = lblBullsResult;
        this.lblCounter = lblCounter;
        this.tableModel = tableModel;

        setText("OK");

        addActionListener(e -> {
            Data.numberEnter = numberEnter.getText();//забираем вводимое число текстовой строкой и кидаем в класс данных
            new Comparsion(Data.numberEnter); //вызвали класс сравнения, с введенным числом на входе
            CowsResult = "Поймано Коров " + Data.cows; //Строковая переменная с обновлённым результатом пойманных коров
            BullsResult = "Поймано Быков " + Data.bulls; //Строковая переменная с обновлённым результатом пойманных быков
            lblCowsResult.setText(CowsResult); //вывели на лейбл под рисунком сколько было поймано коров
            lblBullsResult.setText(BullsResult);//вывели на лейбл под рисунком сколько было поймано быков

//заполняем историю попыток
            // Получаем новые данные: Data.numberEnter, Data.bulls и Data.cows
            Object[] newData = {Data.numberEnter, Data.bulls, Data.cows};
            // Получаем текущее количество строк в модели таблицы
            int rowCount = tableModel.getRowCount();
            // Создаём новый массив данных, увеличив его размер на 1 строчку
            Object[][] updatedData = new Object[rowCount + 1][3];
            // Скопируем текущие данные в новый массив
            for (int i = 0; i < rowCount; i++) {
                updatedData[i] = new Object[]{
                        tableModel.getValueAt(i, 0),
                        tableModel.getValueAt(i, 1),
                        tableModel.getValueAt(i, 2)
                };
            }
            // Добавляем новые данные в последнюю строку нового массива
            updatedData[rowCount] = newData;
            // Обновляем модель таблицы с новыми данными
            tableModel.updateData(updatedData);

//меняем счётчик попыток
            intCounter++; //увеличили переменную числа попыток на +1
            Data.intCounter = intCounter;//количество попыток отправили в базу данных
            lblCounter.setText("" + intCounter);//вывели на лейбл текущее количество попыток и конвертировали в String путём конкатенации.
        });
    }
}
