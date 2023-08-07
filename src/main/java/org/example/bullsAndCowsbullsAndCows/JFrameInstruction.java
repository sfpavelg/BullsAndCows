package org.example.bullsAndCowsbullsAndCows;

import javax.swing.*;

//Класс Окна инструкции
class JFrameInstruction extends JFrame {
    JFrameInstruction(){
        super("Инструкция по Игре");//заголовок
        setDefaultCloseOperation(JFrame. DISPOSE_ON_CLOSE);//завершение программы при закрытии окна
        setBounds(200,50,400,700); //размер окна и местоположение на экране
        setResizable(false); //размер окна нельзя изменить
//Текстовая переменная с самой инструкцией.
        String StringInstruction = "\n      В чём заключается суть игры?\n\n  1. Игра случайно загадает число.\n  2. Вам нужно  угадать это число.\n  3. Если в вашем предполагаемом числе есть нужная цифра,\n       но она стоит не на своём месте, то вы поймали Корову!\n      Например, загадано 245, а вы ввели 123.\n      Совпала цифра 2. Но она не на своём месте.\n      Вы поймали одну корову!\n  4. Если в вашем предполагаемом числе есть нужная цифра,\n      и она стоит на том же месте, то вы поймали одного Быка!\n      Например, загадано 245, а вы ввели 278.\n  5. Сколько угадано правильных цифр, \n      такое же количество Быков или Коров.\n      Например, загадано 245, а вы ввели 254.\n      В этом примере вы поймали Быков-1 и Коровы-2.\n  6. Но имейте ввиду, если в загаданном числе цифры повторяются,\n      то одна угаданная цифра может дать в подсказке\n      несколько коров и одного быка.\n      Например, загадано число 222, а вы выбрали 123.\n      В подсказке будет: Бык-1, Коровы-2!\n  7. Ваша задача за малое время и за малое количество попыток\n      угадать число!!!\n  8. Ведь самые лучшие будут записаны на Аллее Славы!\n  9. Если вы хотите, что-бы ваш результат был записан\n      на Аллее Славы на века, нужно зарегистрироваться.\n      За это отвечает кнопка (Регистрация).\n 10.Игра начинается с нажатия на кнопку (Начать игру).\n      Далее нужно выбрать разрядность загадываемого числа.\n      При нажатии, например, кнопки (Выбор трёхзначного числа),\n      будет загадано число из трёх знаков.\n      Например число: 245\n      Напоминание о разрядности загаданного числа будет\n      находиться в левом верхнем углу.\n 11.В поле (Поле для ввода числа) введите предполагаемое число\n      и нажмите кнопку (ОК).\n      Это будет ваша первая поптытка угадать число.\n      Именно в этот момент включится секундомер.\n      Когда вы число угадаете, он автоматически выключится.\n      Удачных вам рекордов!!!";

        JTextArea jTextAreaInstruction = new JTextArea();
        jTextAreaInstruction.setText(StringInstruction);
        jTextAreaInstruction.setEditable(false);
        add(jTextAreaInstruction);
//JFrameInstruction.add(new JTextArea(StringInstruction));
        setVisible(true); //Делаем окно и всё что в нём видимым
    }
}
