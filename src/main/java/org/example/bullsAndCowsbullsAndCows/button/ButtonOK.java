package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.information.Victory;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.Comparison;
import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForHighScoreTable;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHighScoreBitDepth3;
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
    private TableModelHighScoreBitDepth3 tableModelHighScoreBitDepth3; ////Класс, который является моделью, принимающей данные из БД для таблицы Рекордов
    private FrameBullsAndCows frameBullsAndCows; // Основной класс. Нужен здесь для привязки как к основному фрейму дополнительного окна "Победа" в new Comparison

    public ButtonOK(TextField numberEnter, JLabel lblCowsResult, JLabel lblBullsResult, JLabel lblCounter,
                    TableModelHistory tableModelHistory, FrameBullsAndCows frameBullsAndCows, TableModelHighScoreBitDepth3 tableModelHighScoreBitDepth3) {
        this.numberEnter = numberEnter;
        this.lblCowsResult = lblCowsResult;
        this.lblBullsResult = lblBullsResult;
        this.lblCounter = lblCounter;
        this.tableModelHistory = tableModelHistory;
        this.frameBullsAndCows = frameBullsAndCows;
        this.tableModelHighScoreBitDepth3 = tableModelHighScoreBitDepth3;

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
            // Создаём новый двумерный массив данных, увеличив его размер на 1 строчку
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
            frameBullsAndCows.data.incrementCounter();//Метод инкремента переменной (intCounter++)
            lblCounter.setText("" + frameBullsAndCows.data.getIntCounter());//вывели на лейбл текущее количество попыток и конвертировали в String путём конкатенации.

// условие автостопа таймера: это быки == разрядности
// и значение быков не нулевое как в начале игры, потому что разрядность тоже нулевая в начале игры.
            if ((frameBullsAndCows.data.getBulls() == frameBullsAndCows.data.getBitDepth()) && (frameBullsAndCows.data.getBulls() != 0)) { // Остановка таймера и окно поздравления с победой
                frameBullsAndCows.jpTimer.stopTimer(); // Остановка таймера
                //Данные таймера заносим в класс Data
                frameBullsAndCows.data.setMis(frameBullsAndCows.jpTimer.getMilliseconds());
                frameBullsAndCows.data.setSec(frameBullsAndCows.jpTimer.getSeconds());
                frameBullsAndCows.data.setMin(frameBullsAndCows.jpTimer.getMinutes());
                frameBullsAndCows.data.setHour(frameBullsAndCows.jpTimer.getHours());
// окно поздравления с победой
                new Victory(frameBullsAndCows); // Заполняем переменную Data.victory актуальными данными.
                /**
                 * JOptionPane Тут мы открываем окно с дополнительной информацией Victory
                 * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
                 * Аргументы:
                 * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
                 * Data.notation - текст сообщения
                 * "Сообщение" - заголовок
                 * JOptionPane.INFORMATION_MESSAGE -
                 */
                JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getVictory(), "Победа", JOptionPane.INFORMATION_MESSAGE);

                // ..... и тут запись куда-то результата.... нужно дописать код (таблица рекордов!) .....
                // Создаём объект соединения с БД
                SQLiteConnectorForHighScoreTable sqLiteConnectorForHighScoreTable = new SQLiteConnectorForHighScoreTable();
// Заполняем Таблицу в БД новой записью "Победа!"
                String rating = "Junior"; //Заглушка рейтинг
                String times = frameBullsAndCows.data.getHour() + "ч:" + frameBullsAndCows.data.getMin() + "м:"
                        + frameBullsAndCows.data.getSec() + "с:" + frameBullsAndCows.data.getMis() + "ms"; //время
                String attempts = frameBullsAndCows.data.getIntCounter() + "";

                sqLiteConnectorForHighScoreTable.insertData(frameBullsAndCows.lblUserName.getText(), attempts, times, rating);

// Заполнение Таблицы рекордов данными из БД
                // Обновляем из БД таблицу рекордов актуальными данными...
                tableModelHighScoreBitDepth3.updateData(sqLiteConnectorForHighScoreTable.selectData());
            }
        });
    }
}
