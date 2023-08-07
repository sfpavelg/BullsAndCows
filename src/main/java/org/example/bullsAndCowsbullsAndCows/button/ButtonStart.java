package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.*;

import javax.swing.*;

public class ButtonStart extends JButton {
    private JLabel lblBitDepth;
    int intBitDepth;
    String stringBitDepth = null;
    public ButtonStart(JLabel lblBitDepth) {
        this.lblBitDepth = lblBitDepth;
        setText("Начать Игру!");
    }
    public String buttonStart(){
                //Слушатель кнопки (Начать игру)
        addActionListener(e -> {
            JFrameSelection jFrameSelection = new JFrameSelection(); //вызвали класс выбора.
            intBitDepth = jFrameSelection.startJFrameSelection();
            stringBitDepth = "" + intBitDepth; //конвертируем int в String
            lblBitDepth.setText(stringBitDepth);
            new NumberRandom(intBitDepth);
            new Notation(intBitDepth);
//это мы открываем временное окно оповещения
//Главная фишка его в том, что программа стопорится и ждёт его закрытия.
            JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);
//запуск таймера, сразу после закрытия предыдущего окна
            FrameBullsAndCows.stopWatch.startStopWatch();
        });
        return stringBitDepth;
    }
}
