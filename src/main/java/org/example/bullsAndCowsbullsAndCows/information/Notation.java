package org.example.bullsAndCowsbullsAndCows.information;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.enumClass.BitDepth;

public class Notation {//Заполняем String переменную дополнительной нотации
    private int bitDepth;
    private String rating;
    private String ratingBitDept3;
    private String ratingBitDept4;
    private String ratingBitDept5;
    private String ratingBitDept6;
    private String ratingBitDept7;

    public Notation(int bitDepth, FrameBullsAndCows frameBullsAndCows) {
        this.bitDepth = bitDepth;

        ratingBitDept3 = "Senior - попыток не более 5 и время не более 25 секунд.\n" +
                "Middle - попыток не более 8 и время не более 45 секунд.\n" +
                "Junior - попыток  более 8 или время  более 45 секунд.\n";
        ratingBitDept4 = "Senior - попыток не более 7 и время не более 50 секунд.\n" +
                "Middle - попыток не более 12 и время не более 80 секунд.\n" +
                "Junior - попыток  более 12 или время  более 80 секунд.\n";
        ratingBitDept5 = "Senior - попыток не более 10 и время не более 60 секунд.\n" +
                "Middle - попыток не более 15 и время не более 110 секунд.\n" +
                "Junior - попыток  более 15 или время  более 110 секунд.\n";
        ratingBitDept6 = "Senior - попыток не более 11 и время не более 80 секунд.\n" +
                "Middle - попыток не более 16 и время не более 120 секунд.\n" +
                "Junior - попыток  более 16 или время  более 120 секунд.\n";
        ratingBitDept7 = "Senior - попыток не более 12 и время не более 90 секунд.\n" +
                "Middle - попыток не более 17 и время не более 130 секунд.\n" +
                "Junior - попыток  более 17 или время  более 130 секунд.\n";
        switch (bitDepth) {
            case 3:
                rating = ratingBitDept3;
                break;
            case 4:
                rating = ratingBitDept4;
                break;
            case 5:
                rating = ratingBitDept5;
                break;
            case 6:
                rating = ratingBitDept6;
                break;
            case 7:
                rating = ratingBitDept7;
                break;
        }

        frameBullsAndCows.data.setNotation("Внимание!" + "\n" +
                "Загадано " + BitDepth.findByValueBitDepth(bitDepth) + " число!\n" +
                "Вы должны его угадать!\n" +
                "Вводя в (Поле для ввода чисел) предполагаемые числа\n" +
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
                "Рейтинг ваших результатов оценивается по следующему принципу:\n" +
                rating +
                "Теперь закройте это окно и начинайте игру!\n" +
                "Удачи!!");
    }
}
