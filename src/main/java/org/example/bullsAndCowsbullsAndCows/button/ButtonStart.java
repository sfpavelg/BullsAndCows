package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.enumClass.BitDepth;
import org.example.bullsAndCowsbullsAndCows.enumClass.HighScoreTableName;
import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.information.Notation;
import org.example.bullsAndCowsbullsAndCows.frames.JFrameSelection;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.JPTimer;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.NumberRandom;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForHighScoreTable;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHighScore;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHistory;

import javax.swing.*;

public class ButtonStart extends JButton {
    private JLabel lblBitDepth;
    private int intBitDepth; // Переменная разрядности выбранного числа типа int.
    private String stringBitDepth = null; // Переменная разрядности выбранного числа типа String.
    private TableModelHistory tableModelHistory; // Класс, который является моделью, принимающей данные истории попыток. Здесь он нужен для обнуления данных
    private TableModelHighScore tableModelHighScore; // Класс, который является моделью, принимающей данные для таблицы Рекордов. Здесь он нужен для обнуления таблицы
    private FrameBullsAndCows frameBullsAndCows; // Основной класс. Нужен здесь для привязки как к основному фрейму дополнительного окна нотации
    private JLabel lblCounter;     //лейбл количества попыток
    private JPTimer jpTimer; //Таймер

    public ButtonStart(JLabel lblBitDepth, FrameBullsAndCows frameBullsAndCows, TableModelHistory tableModelHistory, JLabel lblCounter, JPTimer jpTimer, TableModelHighScore tableModelHighScore) {
        this.lblBitDepth = lblBitDepth;
        this.frameBullsAndCows = frameBullsAndCows;
        this.tableModelHistory = tableModelHistory;
        this.lblCounter = lblCounter;
        this.jpTimer = jpTimer;
        this.tableModelHighScore = tableModelHighScore;

        setText("Начать Игру!");
    }

    public String buttonStart() {
        //Слушатель кнопки (Начать игру)
        addActionListener(e -> {
            /**
             * Первым пунктом идёт проверка на смену имени игрока.
             * Логика простая, берём то что на лейбле и сравниваем с содержимым текстовой переменной,
             * которая содержит предупреждение о смене имени игрока и является константой.
             * Любая другая надпись на лейбле даст false и пустит далее по коду.
             * Но другой запись может быть только реальным именем игрока, за этим следит аутентификация.
             */
            if (frameBullsAndCows.lblUserName.getText().equals(frameBullsAndCows.userName)) { // Если на лейбле lblUserName имя игрока не сменилось, запуска не будет.
                /**
                 * JOptionPane Тут мы открываем окно с дополнительной информацией о том, что не было аутентификации.
                 * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
                 * Аргументы:
                 * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
                 * "***" - текст сообщения
                 * "Внимание!" - заголовок
                 * JOptionPane.INFORMATION_MESSAGE - тип окна
                 */
                JOptionPane.showMessageDialog(frameBullsAndCows, "Зайдите под своей учётной записью , или зарегистрируйтесь!",
                        "Внимание!", JOptionPane.INFORMATION_MESSAGE);
            } else { //Если Аутентификация пройдена, то откроется доступ к выбору разрядности и запуску игры.
                JFrameSelection jFrameSelection = new JFrameSelection(frameBullsAndCows); //вызвали класс выбора разрядности.
                intBitDepth = jFrameSelection.startJFrameSelection(); // После выбора, нам вернётся число разрядности или -1, если мы просто закроем окно без выбора.
                if (intBitDepth == -1) { //Если закроем экран без выбора, вернётся число разрядности -1, и завершим этот метод без дальнейшего запуска
                    return;
                }
                stringBitDepth = "Загадано " + BitDepth.findByValueBitDepth(intBitDepth) + " число!"; //Достаём из ENUM нужное текстовое значение разрядности по int-вому значению.
                lblBitDepth.setText(stringBitDepth); //Выводим на лейбл информацию о выбранной разрядности загаданного числа.
                new NumberRandom(intBitDepth, frameBullsAndCows); //Теперь запускаем класс рандома числа с выбранной разрядностью.
                new Notation(intBitDepth, frameBullsAndCows); // Добавляем в дополнительную информацию разрядность выбранного числа
                tableModelHistory.clearData(); //обнуление таблицы истории попыток
                frameBullsAndCows.data.setIntCounter(0);  //Обнуление счётчика попыток
                lblCounter.setText("" + frameBullsAndCows.data.getIntCounter());//Выводим на лейбл обнулённое количество попыток

                /**
                 * JOptionPane Тут мы открываем окно с дополнительной информацией Notation
                 * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
                 * Аргументы:
                 * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
                 * Data.notation - текст сообщения
                 * "Нотация" - заголовок
                 * JOptionPane.INFORMATION_MESSAGE - тип окна
                 */
                JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getNotation(), "Нотация", JOptionPane.INFORMATION_MESSAGE);

                jpTimer.startTimer(); //запуск таймера, сразу после закрытия предыдущего окна
                int intBitDepth = frameBullsAndCows.data.getBitDepth(); //Выбранная разрядность угадываемого числа

// Меняем таблицу Рекордов согласно выбранной разрядности. Данные берём из БД
                String nameTable = "" + HighScoreTableName.findByValueHighScoreTableName(intBitDepth);
                SQLiteConnectorForHighScoreTable sqLiteConnectorForHighScoreTable = new SQLiteConnectorForHighScoreTable(nameTable);
                tableModelHighScore.updateData(sqLiteConnectorForHighScoreTable.selectData(nameTable));

// В зависимости от выбранной разрядности, меняется отображение соответствующей таблицы Рекордов, а значит нужно поменять заголовок рамки этой таблицы.
                frameBullsAndCows.lineName = "" + BitDepth.findByValueBitDepth(intBitDepth);
                frameBullsAndCows.titledBorderHighScoreTable.setTitle("Таблица Рекордов(" + frameBullsAndCows.lineName + " число)");
                frameBullsAndCows.pnEast.repaint(); // Обновление отображения панели pnEast

//            временное окно загаданного числа для отладки
//                JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getNumberRandom(), "Подсказка", JOptionPane.INFORMATION_MESSAGE);
            }
        });
// В результате работы кода, будет выбран разрядность загадываемого числа. Вернём его для дальнейшей обработки.
        return stringBitDepth;

    }
}
