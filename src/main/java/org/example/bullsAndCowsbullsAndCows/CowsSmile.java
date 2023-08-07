package org.example.bullsAndCowsbullsAndCows;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

//Класс с изображением КОРОВЫ
class CowsSmile extends JComponent
{
    @Override
    public void paintComponent (Graphics a)
    {
        a.setColor(Color.YELLOW);
        a.fillOval(0, 40, 100, 100);//левое ухо
        a.setColor(Color.PINK);
        a.fillOval(10, 50, 80, 80);//левое ухо
        a.setColor(Color.black);
        a.fillOval(260, 40, 100, 100);//правое ухо
        a.setColor(Color.PINK);
        a.fillOval(270,50, 80, 80);//правое ухо
        a.setColor(Color.YELLOW);
        a.fillOval(30, 10, 300, 300);//голова
        a.setColor(Color.PINK);
        a.fillOval(80, 190, 210,130);//морда
        a.setColor(Color.black);
        a.fillOval(120, 165, 40, 40);//левый зрачок
        a.fillOval(220, 165, 40, 40);//правый зрачок
        a.fillOval(150, 230, 15, 20);//левая ноздря
        a.fillOval(215, 230, 15, 20);//правая ноздря
        a.fillOval(120, 5, 30, 50);//левый рог
        a.fillOval(220, 5, 30, 50);//правый рог
        a.drawArc(170, 270, 40, 20, 0, -180);//рот
        a.setColor(Color.WHITE);
        a.fillOval(125, 170, 15, 15);//глаза блики
        a.fillOval(240, 170, 15, 15);//глаза блики
        a.fillOval(135, 190, 7, 7);//глаза блики
        a.fillOval(240, 190, 7, 7);//глаза блики
    }
}
