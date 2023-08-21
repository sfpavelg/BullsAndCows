package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.information.Instruction;

import javax.swing.*;

public class ButtonInstruction extends JButton {
    private FrameBullsAndCows frameBullsAndCows;

    public ButtonInstruction(FrameBullsAndCows frameBullsAndCows) {
        this.frameBullsAndCows = frameBullsAndCows;
        setText("Инструкция");

        //Слушатель кнопки (Инструкция)
        addActionListener(e -> {
            new Instruction(frameBullsAndCows); // Текст Инструкции закидываем в переменную Data.instruction
            /**
             * JOptionPane Тут мы открываем окно с дополнительной информацией Notation
             * Главная фишка такого окна в том, что программа стопорится и ждёт его закрытия.
             * Аргументы:
             * frameBullsAndCows - привязываемся к главному окну, по которому и будет центроваться окно сообщения.
             * Data.notation - текст сообщения
             * "Сообщение" - заголовок
             * JOptionPane.INFORMATION_MESSAGE -
             */
            JOptionPane.showMessageDialog(frameBullsAndCows, frameBullsAndCows.data.getInstruction(), "Инструкция", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
