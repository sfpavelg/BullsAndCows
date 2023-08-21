package org.example.bullsAndCowsbullsAndCows.information;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;

public class Victory {
    public Victory(FrameBullsAndCows frameBullsAndCows) {
        frameBullsAndCows.data.setVictory("  *********************************************" +
                "\n                          Победа!!!!" +
                "\n               Все БЫКИ пойманы!" +
                "\n Вы отгадали все цифры, в количестве:" + frameBullsAndCows.data.getBulls() + " !" +
                "\n          Вами было сделано " + frameBullsAndCows.data.getIntCounter() + " попыток!!!" + "" +
                "\n            Время прохождения: " + frameBullsAndCows.data.getHour() +
                ":" + frameBullsAndCows.data.getMin() + ":" + frameBullsAndCows.data.getSec() + ":" + frameBullsAndCows.data.getMis() + "" +
                "\n  *********************************************");
    }
}
