package org.example.bullsAndCowsbullsAndCows.information;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.enumBitDepth.BitDepth;

public class Notation {//Заполняем String переменную дополнительной нотации
    private int bitDepth;

    public Notation(int bitDepth, FrameBullsAndCows frameBullsAndCows) {
        this.bitDepth = bitDepth;

        frameBullsAndCows.data.setNotation("Внимание!" + "\n" +
                "Загадано " + BitDepth.findByValueBitDepth(bitDepth) + " число!\n" +
                "Вы должны его угадать!\n" +
                "Вводя в (Поле для чисел) предпологаемые числа\n" +
                "и нажимая кнопку (ОК) вы будете получать подсказки,\n" +
                "сколько Быков и   Коров поймано.\n" +
                "Эти подсказки отобразятся в двух местах:\n" +
                "под картинками (Бык) (Корова)\n" +
                "и в таблице (История).\n" +
                "Если вы поймали всех Быков,\n" +
                "то-есть, все цифры отгаданы\n" +
                "и они стоят на своих местах,\n" +
                "вы увидите окно поздравления (БИНГО!),\n" +
                "с фиксацией потраченного времени\n" +
                "и количеством сделанных попыток.\n" +
                "Теперь закройте это окно и начинайте игру!\n" +
                "Удачи!!");
    }
}
