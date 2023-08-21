package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.*;
import org.example.bullsAndCowsbullsAndCows.enumBitDepth.BitDepth;
import org.example.bullsAndCowsbullsAndCows.information.Notation;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.JFrameSelection;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.JPTimer;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.NumberRandom;
import org.example.bullsAndCowsbullsAndCows.tableModel.TableModelHistory;

import javax.swing.*;

public class ButtonStart extends JButton {
    private JLabel lblBitDepth;
    private int intBitDepth; // Переменная разрядности выбранного числа типа int.
    private String stringBitDepth = null; // Переменная разрядности выбранного числа типа String.
    private TableModelHistory tableModelHistory; // Класс, который является моделью, принимающей данные истории попыток. Здесь он нужен для обнуления данных
    private FrameBullsAndCows frameBullsAndCows; // Основной класс. Нужен здесь для привязки как к основному фрейму дополнительного окна нотации
    private JLabel lblCounter;     //лейбл количества попыток
    private JPTimer jpTimer; //Таймер

    public ButtonStart(JLabel lblBitDepth, FrameBullsAndCows frameBullsAndCows, TableModelHistory tableModelHistory, JLabel lblCounter, JPTimer jpTimer) {
        this.lblBitDepth = lblBitDepth;
        this.frameBullsAndCows = frameBullsAndCows;
        this.tableModelHistory = tableModelHistory;
        this.lblCounter = lblCounter;
        this.jpTimer = jpTimer;

        setText("Начать Игру!");
    }

    public String buttonStart() {
        //Слушатель кнопки (Начать игру)
        addActionListener(e -> {
            JFrameSelection jFrameSelection = new JFrameSelection(frameBullsAndCows); //вызвали класс выбора.
            intBitDepth = jFrameSelection.startJFrameSelection(); // После выбора, нам вернётся число разрядности.
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
             * "Сообщение" - заголовок
             * JOptionPane.INFORMATION_MESSAGE -
             */
            JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getNotation(), "Нотация", JOptionPane.INFORMATION_MESSAGE);

//запуск таймера, сразу после закрытия предыдущего окна
            jpTimer.startTimer();

//            временное окно загаданного числа для отладки
            JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getNumberRandom(), "Подсказка", JOptionPane.INFORMATION_MESSAGE);

        });

// В результате работы кода, будет выбран разрядность загадываемого числа. Вернём его для дальнейшей обработки.
        return stringBitDepth;
    }
}
