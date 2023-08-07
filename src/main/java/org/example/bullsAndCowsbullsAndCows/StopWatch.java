package org.example.bullsAndCowsbullsAndCows;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StopWatch{

    public static Timer timer;

    public StopWatch() {  //конструктор
        Data.mis=0;   //обнуления всех переменных
        Data.sec=0;
        Data.min=0;
        Data.hour=0;
        timer=new Timer(100,new TestActionListener());// единица времени 10мс
    }// конец конструктора

    public static void startStopWatch(){
        Data.mis=0;     //обнуления всех переменных
        Data.sec=0;
        Data.min=0;
        Data.hour=0;
        timer.start();  // таймер запуск.
    }

    public static void stopStopWatch(){
        timer.stop();  //таймер стоп
    }

    class TestActionListener implements ActionListener{   //это вложенный класс обработчик слушателя.
        public void actionPerformed(ActionEvent e){
            Data.mis++;  //счётчик-цикл миллисекунд
            if(Data.mis >= 99){ //переполнение миллисекунд
                Data.sec++;  //счётчик-цикл секунд
                Data.mis=0;  //обнуление миллисекунд
                if(Data.sec>=59){  //и так далее. Это счётчик разрядов
                    Data.min++;   //минуты
                    Data.sec=0;
                    if(Data.min>=59){
                        Data.hour++;  //часы
                        Data.min=0;
                    }  //конец if min
                }  //конец if sec
            } //конец if mis
        } //конец метода actionPerformed
    } //конец вложенного класса TestActionListener
}  //конец основного класса

