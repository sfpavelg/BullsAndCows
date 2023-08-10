package org.example.bullsAndCowsbullsAndCows.information;

import org.example.bullsAndCowsbullsAndCows.data.Data;

public class Victory {
    public Victory(){
        Data.victory = "  *********************************************" +
                "\n                          Победа!!!!" +
                "\n               Все БЫКИ пойманы!" +
                "\n Вы отгадали все цифры, в количестве:" + Data.bulls + " !" +
                "\n          Вами было сделано " + (1+Data.intCounter) + " попыток!!!"+ "" +
                "\n            Время прохождения: " + Data.hour+":"+Data.min+":"+Data.sec+":"+Data.mis + "" +
                "\n  *********************************************";
            }
}
