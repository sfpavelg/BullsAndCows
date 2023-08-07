package org.example.bullsAndCowsbullsAndCows;

import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import java.text.DecimalFormat;

class JPTimer extends JComponent
{
    @Override
    public void paintComponent (Graphics a)
    {
//       super.paintComponent(a);
        DecimalFormat textFormat2=new DecimalFormat("00");// форматированный вывод таймера
        a.drawString(textFormat2.format(Data.hour)+":"+textFormat2.format(Data.min)+":"+textFormat2.format(Data.sec)+":"+textFormat2.format(Data.mis),1,20);
        repaint();
    }
}