package org.example.bullsAndCowsbullsAndCows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.*;
import java.awt.Dimension;

//Класс Окна выбора разрядности и запуска генератора рандома
class JFrameSelection extends JFrame {

    JButton Button3;
    JButton Button4;
    JButton Button5;
    JButton Button6;
    JButton Button7;
    int bitDepth; //переменная возврата разрядности выбранного числа

    //временная переменная для дополнительного окна рандома
    int fromNumberRandom;

    JLabel lblTimer3;


    //конструктор
    JFrameSelection() {}
    public int startJFrameSelection(){



        Object[] options = {3, 4, 5, 6, 7};
        /**
         * `JOptionPane.showOptionDialog()` является методом для отображения окна выбора с несколькими вариантами.
         * Вот подробное описание аргументов метода `showOptionDialog()`:
         * 1. `Component parentComponent`: Компонент-родитель, который будет использоваться как родительское окно диалога. В данном случае передано значение `null`, что означает использование текущего фрейма в качестве родительского окна.
         * 2. `Object message`: Сообщение или вопрос, отображаемые в диалоговом окне.
         * 3. `String title`: Заголовок окна диалога.
         * 4. `int optionType`: Тип вопроса, определяющий отображаемые кнопки выбора. Возможные значения:
         *    - `JOptionPane.DEFAULT_OPTION` - Стандартный набор кнопок, который включает в себя "ОК", "Отмена" и "Закрыть".
         *    - `JOptionPane.YES_NO_OPTION` - Включает кнопки "Да" и "Нет".
         *    - `JOptionPane.YES_NO_CANCEL_OPTION` - Включает кнопки "Да", "Нет" и "Отмена".
         *    - `JOptionPane.OK_CANCEL_OPTION` - Включает кнопки "ОК" и "Отмена".
         *    - Можно также использовать `JOptionPane.PLAIN_MESSAGE`, `JOptionPane.ERROR_MESSAGE`, `JOptionPane.INFORMATION_MESSAGE`, `JOptionPane.WARNING_MESSAGE` и `JOptionPane.QUESTION_MESSAGE`.
         * 5. `int messageType`: Тип сообщения, определяющий иконку, которая будет отображаться рядом с сообщением. Возможные значения:
         *    - `JOptionPane.DEFAULT_OPTION` или `JOptionPane.PLAIN_MESSAGE` - Нет иконки.
         *    - `JOptionPane.ERROR_MESSAGE` - Отображает иконку ошибки.
         *    - `JOptionPane.INFORMATION_MESSAGE` - Отображает иконку информации.
         *    - `JOptionPane.WARNING_MESSAGE` - Отображает иконку предупреждения.
         *    - `JOptionPane.QUESTION_MESSAGE` - Отображает иконку вопроса.
         * 6. `Icon icon`: Пользовательская иконка для отображения рядом с сообщением. В данном случае передано значение `null`, поэтому будет использоваться стандартная иконка.
         * 7. `Object[] options`: Массив объектов, представляющих варианты выбора. В этом случае это массив значений 3, 4, 5, 6 и 7.
         * 8. `Object initialValue`: Значение, которое будет выбрано по умолчанию при открытии окна диалога. В этом случае передано значение `options[0]`, то есть 3 будет выбрано по умолчанию.
         * Метод `showOptionDialog()` вернет индекс выбранного элемента массива `options`, который соответствует выбранному варианту пользователем.
         */

        int result = JOptionPane.showOptionDialog(null,
                "Выберите разрядность загадываемого числа:",
                "Разрядность",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]);
        // Выбранное значение будет в result
//        int selectedOption = (int) options[result];
//        if (selectedOption >= 3 && selectedOption <= 7) {
//
//
//            NumberRandom numberRandomObject = new NumberRandom(result);
////                dispose(); //закрываем окно последнего открытого фрейма
//            new Notation(result);
//            bitDepth = result;
//            Data.bitDepth = result;
//            JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);//это мы открываем временное окно оповещения
////Главная фишка его в том, что программа стопорится и ждёт его закрытия.
////                new StopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//
//            FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//
//        }

////создаём окно выбора разрядности
////        super("Разрядность");//заголовок
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение программы при закрытии окна
//        setBounds(500, 300, 200, 190); //размер окна и местоположение на экране
//        setResizable(false); //размер окна нельзя изменить
//
//
//        JPanel Panel = new JPanel();
//        Button3 = new JButton("Выбор трёхзначного       числа");
//        Button4 = new JButton("Выбор четырёхзначного числа");
//        Button5 = new JButton("Выбор пятизначного       числа");
//        Button6 = new JButton("Выбор шестизначного    числа");
//        Button7 = new JButton("Выбор семизначного     числа");
//
////создаём слушателей кнопок и события для них
//
//// на 3 числа!!!!
//        Button3.addActionListener(e -> {
////главная задача создать объект класса рандома и закинуть туда нужную цифру
//            NumberRandom numberRandomObject = new NumberRandom(3);
//            dispose();//закрываем окно последнего открытого фрейма
//            new Notation(3);
//            JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);//это мы открываем временное окно оповещения
////Главная фишка его в том, что программа стопорится и ждёт его закрытия.
////new StopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//            FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//
//
////это всё временная примочка
////ОКНО РАНДОМА
//            fromNumberRandom = Data.numberRandom;
//            JFrame j1 = new JFrame("Рандом");
//            j1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение программы
//            j1.setBounds(400, 600, 200, 190); //размер окна и местоположение на экране
//            j1.setResizable(false); //размер окна нельзя изменить
//            JLabel lblTimer2 = new JLabel("");
//            String f = Integer.toString(fromNumberRandom);
//            lblTimer2.setText(f);
//            j1.add(lblTimer2);
//            j1.setVisible(true);
//
//
////ОКНО ТАЙМЕРА
//            JFrame j2 = new JFrame("Таймер");
//            j2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//завершение программы
//            j2.setBounds(600, 600, 200, 190); //размер окна и местоположение на экране
//            JPanel pnl1 = new JPanel();
//            JPanel pnl2 = new JPanel();
//            JButton StartButton = new JButton("Старт");
//            JButton StopButton = new JButton("Стоп");
//            Border etched = BorderFactory.createEtchedBorder();//создаём рамку, цвет-чёрный, линяя -тонкая
////а тут методом createTitledBorder() добавляем на рамку заголовок
//            Border titled10 = BorderFactory.createTitledBorder(etched, "Окно №1");
//            Border titled20 = BorderFactory.createTitledBorder(etched, "Окно №2");
////теперь методом setBorder одеваем нашу панель в соответствующую рамку
//            pnl1.setBorder(titled10);
//            pnl1.setPreferredSize(new Dimension(50, 25));//размер окна
//            pnl1.setLayout(new BorderLayout());
//            pnl1.add(new JPTimer());
//            j2.add(StartButton, BorderLayout.NORTH);
//            j2.add(pnl2, BorderLayout.CENTER);
//            j2.add(StopButton, BorderLayout.SOUTH);
//            j2.add(pnl1);
//            j2.setVisible(true);
//
////слушатель кнопки старт
//            StartButton.addActionListener(new ActionListener() {
//                //                    @Override     /*само событие*/
//                public void actionPerformed(ActionEvent e) {
////старт таймера
//                    FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера
//                }
//            });
////слушатель кнопки стоп
//            StopButton.addActionListener(new ActionListener() {
//                //                    @Override     /*само событие*/
//                public void actionPerformed(ActionEvent e) {
////старт таймера
//                    FrameBullsAndCows.stopWatch.stopStopWatch();//остановка таймера
//                }
//            });
////конец временной примочки
//
//        });
//
//
//// на 4 числа!!!!
//        Button4.addActionListener(e -> {
////главная задача создать объект класса рандома и закинуть туда нужную цифру
//                NumberRandom numberRandomObject = new NumberRandom(4);
//                dispose(); //закрываем окно последнего открытого фрейма
//                new Notation(4);
//                bitDepth = 4;
//                Data.bitDepth = 4;
//                JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);//это мы открываем временное окно оповещения
////Главная фишка его в том, что программа стопорится и ждёт его закрытия.
////                new StopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//
//            FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//
//        });
//
//
//// на 5 чисел!!!!
//        Button5.addActionListener(e ->  {
////Главная задача создать объект класса рандома и закинуть туда нужную цифру
//                NumberRandom numberRandomObject = new NumberRandom(5);
//                dispose(); //закрываем окно последнего открытого фрейма
//                new Notation(5);
//                JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);//это мы открываем временное окно оповещения
////Главная фишка его в том, что программа стопорится и ждёт его закрытия.
////                new StopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//            FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//        });
//
//// на 6 чисел!!!!
//        Button6.addActionListener(e -> {
////Главная задача создать объект класса рандома и закинуть туда нужную цифру
//                NumberRandom numberRandomObject = new NumberRandom(6);
//                dispose(); //закрываем окно последнего открытого фрейма
//                new Notation(6);
//                JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);//это мы открываем временное окно оповещения
////Главная фишка его в том, что программа стопорится и ждёт его закрытия.
////                new StopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//            FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//        });
//
//// на 7 чисел!!!!
//        Button7.addActionListener(e ->  {
////Главная задача создать объект класса рандома и закинуть туда нужную цифру
//                NumberRandom numberRandomObject = new NumberRandom(7);
//                dispose(); //закрываем окно последнего открытого фрейма
//                new Notation(7);
//                JOptionPane.showMessageDialog(null, Data.notation, "Сообщение", JOptionPane.INFORMATION_MESSAGE);//это мы открываем временное окно оповещения
////Главная фишка его в том, что программа стопорится и ждёт его закрытия.
////                new StopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//            FrameBullsAndCows.stopWatch.startStopWatch();//запуск таймера, сразу после закрытия предыдущего окна
//        });
//
//        Panel.add(Button3);
//        Panel.add(Button4);
//        Panel.add(Button5);
//        Panel.add(Button6);
//        Panel.add(Button7);
//        add(Panel);
//
//        setVisible(true); //Делаем окно и всё что в нём видимым
////        return bitDepth;
        return (int) options[result];
    }
}
