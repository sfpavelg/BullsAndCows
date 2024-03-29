package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.enumClass.HighScoreTableName;
import org.example.bullsAndCowsbullsAndCows.enumClass.RatingCalculator;
import org.example.bullsAndCowsbullsAndCows.information.Victory;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.Comparison;
import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForHighScoreTable;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHighScore;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class ButtonOK extends JButton {
    private TextField numberEnter;  //поле для ввода цифр
    private String CowsResult; //Строковая переменная
    private String BullsResult; //Строковая переменная
    private JLabel lblCowsResult;        //лейбл количества Коров
    private JLabel lblBullsResult;       //лейбл количества Быков
    private String randomNumberStory = "";    //Строковая переменная
    private JLabel lblCounter;     //лейбл количества попыток
    private TableModelHistory tableModelHistory; //Класс, который является моделью, принимающей данные истории попыток
    private TableModelHighScore tableModelHighScore; ////Класс, который является моделью, принимающей данные из БД для таблицы Рекордов
    private FrameBullsAndCows frameBullsAndCows; // Основной класс. Нужен здесь для привязки как к основному фрейму дополнительного окна "Победа" в new Comparison

    public ButtonOK(TextField numberEnter, JLabel lblCowsResult, JLabel lblBullsResult, JLabel lblCounter,
                    TableModelHistory tableModelHistory, FrameBullsAndCows frameBullsAndCows, TableModelHighScore tableModelHighScore) {
        this.numberEnter = numberEnter;
        this.lblCowsResult = lblCowsResult;
        this.lblBullsResult = lblBullsResult;
        this.lblCounter = lblCounter;
        this.tableModelHistory = tableModelHistory;
        this.frameBullsAndCows = frameBullsAndCows;
        this.tableModelHighScore = tableModelHighScore;

        setText("OK");//Надпись на кнопку
        addActionListener(e -> processButtonClick());  // Слушатель кнопки ОК, который выполняет метод processButtonClick()

        /**
         * Слушатель кнопки клавиатуры Enter, который выполняет processButtonClick(), если курсор ввода станет активным
         * addKeyListener() привязан к полю ввода чисел numberEnter,
         * и при активации в нём курсора, становится возможным использование кнопки Enter.
         * Методы keyTyped(KeyEvent e) и keyReleased(KeyEvent e) не имеют реализации, но мы обязаны их переопределить.
         * Метод keyPressed(KeyEvent e) перехватывает нажатие кнопки и реализует тот же метод processButtonClick();,
         * что и кнопка ОК.
         */
        numberEnter.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Не используется
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    processButtonClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Не используется
            }
        });
        setFocusable(true);
    }

    private void processButtonClick() {
        frameBullsAndCows.data.setNumberEnter(numberEnter.getText());//забираем вводимое число текстовой строкой и кидаем в класс данных
        new Comparison(frameBullsAndCows.data.getNumberEnter(), frameBullsAndCows); //вызвали класс сравнения, с введенным числом на входе и с объектом основного фрейма для дополнительного окна "Ошибка"
        if (String.valueOf(frameBullsAndCows.data.getNumberEnter()).length() == String.valueOf(frameBullsAndCows.data.getNumberRandom()).length() &&
        String.valueOf(frameBullsAndCows.data.getNumberEnter()).length() >= 3){ //Число уже загадано? Если да, то разрядности загаданного числа и вводимого должны совпасть.
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

// Заполняем Таблицу в БД новой записью результатов победителя
                String rating = "" + new RatingCalculator().calculateRating(frameBullsAndCows.data.getBitDepth(),
                        frameBullsAndCows.data.getIntCounter(),
                        (frameBullsAndCows.data.getMin() * 60 + frameBullsAndCows.data.getSec()));//Определяем рейтинг по результатам победы
//Формируем дату и время. Дата реальная, а время, это результат таймера.
                Date currentDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1; // Месяцы в Calendar начинаются с 0
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = frameBullsAndCows.data.getHour(); // Забираем из Data время и формируем String переменную.
                int min = frameBullsAndCows.data.getMin();
                int sec = frameBullsAndCows.data.getSec();
                int mis = frameBullsAndCows.data.getMis();

                String time = String.format(year + "-" + month + "-" + day + " %02d:%02d:%02d.%02d", hour, min, sec, mis);//Собираем дату и время в String
                Timestamp times = Timestamp.valueOf(time); //Конвертируем String в Timestamp, которую хорошо понимает БД

                int attempts = frameBullsAndCows.data.getIntCounter(); // Забираем из Data счётчик попыток
                String userName = frameBullsAndCows.lblUserName.getText(); // Забираем с лейбла имя текущего игрока
                // Забираем из Data выбранную разрядность, передаём её в ENUM и извлекаем от туда нужное название таблицы в БД, куда будем класть данные
                String nameTable = "" + HighScoreTableName.findByValueHighScoreTableName(frameBullsAndCows.data.getBitDepth());

                // Создаём объект соединения с БД
                SQLiteConnectorForHighScoreTable sqLiteConnectorForHighScoreTable = new SQLiteConnectorForHighScoreTable(nameTable);
                //Вызываем метод заполнения таблицы в БД, и передаём на вход все эти параметры
                sqLiteConnectorForHighScoreTable.insertData(nameTable, userName, attempts, times, rating);

                tableModelHighScore.updateData(sqLiteConnectorForHighScoreTable.selectData(nameTable)); // Заполнение Таблицы рекордов актуальными данными из БД
                frameBullsAndCows.data.setNumberRandom(0); //Сбрасываем загаданное число
            }
        }
    }
}
