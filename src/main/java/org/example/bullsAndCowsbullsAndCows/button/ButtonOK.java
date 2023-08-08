package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.Comparsion;
import org.example.bullsAndCowsbullsAndCows.Data;
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
//    private JTextArea textAreaStory; //поле истории попыток
    private int intCounter = 0;    //переменная счётчика попыток
    private JLabel lblCounter;     //лейбл количества попыток
    TableModelStory tableModel; //****

    public ButtonOK(TextField numberEnter, JLabel lblCowsResult, JLabel lblBullsResult, JLabel lblCounter, TableModelStory tableModel) {
        this.numberEnter = numberEnter;
        this.lblCowsResult = lblCowsResult;
        this.lblBullsResult = lblBullsResult;
 //       this.textAreaStory = textAreaStory;
        this.lblCounter = lblCounter;
        this.tableModel = tableModel;

        setText("OK");

        addActionListener(e -> {
            Data.numberEnter = numberEnter.getText();//забираем вводимое число текстовой строкой и кидаем в класс данных
            new Comparsion(Data.numberEnter); //вызвали класс сравнения, с введенным числом на входе
            CowsResult = "Поймано Коров " + Data.cows; //Строковая переменная с результатом пойманных коров
            BullsResult = "Поймано Быков " + Data.bulls; //Строковая переменная с результатом пойманных быков
            lblCowsResult.setText(CowsResult); //вывели на лейбл под рисунком пойманных коров
            lblBullsResult.setText(BullsResult);//вывели на лейбл под рисунком пойманных быков

//заполняем историю попыток
//            randomNumberStory = randomNumberStory + "\n" + Data.numberEnter + "    " + Data.bulls + "  " + Data.cows;
//            textAreaStory.setText(randomNumberStory);

            // Определите логику получения новых данных Data.numberEnter, Data.bulls и Data.cows
            Object[] newData = {Data.numberEnter, Data.bulls, Data.cows};
            // Получите текущее количество строк в модели таблицы
            int rowCount = tableModel.getRowCount();
            // Создайте новый массив данных, увеличив его размер на 1
            Object[][] updatedData = new Object[rowCount + 1][3];
            // Скопируйте текущие данные в новый массив
            for (int i = 0; i < rowCount; i++) {
                updatedData[i] = new Object[]{
                        tableModel.getValueAt(i, 0),
                        tableModel.getValueAt(i, 1),
                        tableModel.getValueAt(i, 2)
                };
            }
            // Добавьте новые данные в последнюю строку нового массива
            updatedData[rowCount] = newData;
            // Обновите модель таблицы с новыми данными
            tableModel.updateData(updatedData);





//меняем счётчик попыток
            intCounter++; //увеличили переменную числа попыток на +1
            Data.intCounter = intCounter;//количество попыток отправили в базу данных
            lblCounter.setText("" + intCounter);//вывели на лейбл текущее количество попыток и конвертировали в String путём конкатенации.
        });
    }
}
