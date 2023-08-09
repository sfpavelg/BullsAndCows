package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.*;
import org.example.bullsAndCowsbullsAndCows.data.Data;
import org.example.bullsAndCowsbullsAndCows.enumBitDepth.BitDepth;
import org.example.bullsAndCowsbullsAndCows.information.Notation;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.JFrameSelection;
import org.example.bullsAndCowsbullsAndCows.mathProcessing.NumberRandom;

import javax.swing.*;

public class ButtonStart extends JButton {
    private JLabel lblBitDepth;
    private int intBitDepth;
    private String stringBitDepth = null;
    private FrameBullsAndCows frameBullsAndCows;

    public ButtonStart(JLabel lblBitDepth, FrameBullsAndCows frameBullsAndCows) {
        this.frameBullsAndCows = frameBullsAndCows;
        this.lblBitDepth = lblBitDepth;
        setText("Начать Игру!");
    }

    public String buttonStart() {
        //Слушатель кнопки (Начать игру)
        addActionListener(e -> {
            JFrameSelection jFrameSelection = new JFrameSelection(frameBullsAndCows); //вызвали класс выбора.
            intBitDepth = jFrameSelection.startJFrameSelection(); // После выбора, нам вернётся число разрядности.
            stringBitDepth = "Загадано " + BitDepth.findByValueBitDepth(intBitDepth) + " число!"; //Достаём из ENUM нужное текстовое значение разрядности по int-вому значению.
            lblBitDepth.setText(stringBitDepth); //Выводим на лейбл информацию о выбранной разрядности загаданного числа.
            new NumberRandom(intBitDepth); //Теперь запускаем класс рандома числа с выбранной разрядностью.
            new Notation(intBitDepth); // Добавляем в дополнительную информацию разрядность выбранного числа

            /**
             * JOptionPane Тут мы открываем окно с дополнительной информацией Notation
             * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
             * Аргументы:
             * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
             * Data.notation - текст сообщения
             * "Сообщение" - заголовок
             * JOptionPane.INFORMATION_MESSAGE -
             */
            JOptionPane.showMessageDialog(frameBullsAndCows, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);

//запуск таймера, сразу после закрытия предыдущего окна
            FrameBullsAndCows.stopWatch.startStopWatch();
        });

// В результате работы кода, будет выбран разрядность загадываемого числа. Вернём его для дальнейшей обработки.
        return stringBitDepth;
    }
}
