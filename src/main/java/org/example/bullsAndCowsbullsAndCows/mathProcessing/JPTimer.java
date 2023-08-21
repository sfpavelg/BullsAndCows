package org.example.bullsAndCowsbullsAndCows.mathProcessing;

import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class JPTimer extends JComponent {
    private final int interval = 10; // интервал в миллисекундах (10 миллисекунд)
    private Timer timer;
    private int hours, minutes, seconds, milliseconds;

    public JPTimer() {
        ActionListener actionListener = e -> {
            milliseconds++;
            if (milliseconds >= 99) {
                milliseconds = 0;
                seconds++;
                if (seconds >= 59) {
                    minutes++;
                    seconds = 0;
                    if (minutes >= 59) {
                        hours++;
                        minutes = 0;
                    }
                }
            }
            repaint();
        };

        timer = new Timer(interval, actionListener);
    }

    @Override
    public void paintComponent(Graphics g) {
        DecimalFormat textFormat2 = new DecimalFormat("00");
        String time = textFormat2.format(hours) + ":" + textFormat2.format(minutes) + ":" + textFormat2.format(seconds) + ":" + textFormat2.format(milliseconds);
        g.drawString(time, 1, 20);
    }

    public void startTimer() {
        hours = 0; // сброс значений hours, minutes, seconds и milliseconds
        minutes = 0;
        seconds = 0;
        milliseconds = 0;
        timer.start();  // таймер запуск.
    }

    public void stopTimer() {

        timer.stop();  //таймер стоп
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }
}