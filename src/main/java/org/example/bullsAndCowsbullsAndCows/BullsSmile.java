package org.example.bullsAndCowsbullsAndCows;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

//Вложенный клас с изображением БЫКА
class BullsSmile extends JComponent
{
    @Override
    public void paintComponent (Graphics a)
    {
        a.setColor(Color.RED);
        a.fillOval(0, 40, 100, 100);//левое ухо
        a.setColor(Color.PINK);
        a.fillOval(10, 50, 80, 80);//левое ухо
        a.setColor(Color.RED);
        a.fillOval(260, 40, 100, 100);//правое ухо
        a.setColor(Color.PINK);
        a.fillOval(270,50, 80, 80);//правое ухо
        a.setColor(Color.red);
        a.fillOval(30, 10, 300, 300);//голова
        a.setColor(Color.PINK);
        a.fillOval(80, 190, 210,130);//морда
        a.setColor(Color.BLACK);
        a.fillOval(135, 160, 30, 30);//глаза зрачки
        a.fillOval(210, 160, 30, 30);//глаза зрачки
        a.drawArc(60, 120, 100, 100,0, 100);//глаза обвод
        a.drawArc(215, 120, 100, 100,180, -100);//глаза обвод
        a.fillOval(155, 230, 20, 20);//левая ноздря
        a.fillOval(200, 230, 20, 20);//правая ноздря
        a.fillOval(120, 5, 30, 50);//левый рог
        a.fillOval(220, 5, 30, 50);//правый рог
        a.drawArc(150, 270, 80, 20,0, 180);//рот
    }
}
