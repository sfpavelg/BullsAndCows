package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.enumClass.BitDepth;
import org.example.bullsAndCowsbullsAndCows.enumClass.HighScoreTableName;
import org.example.bullsAndCowsbullsAndCows.frames.JFrameSelection;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForHighScoreTable;

import javax.swing.*;

public class ButtonViewHighScore extends JButton {
    public ButtonViewHighScore(FrameBullsAndCows frameBullsAndCows){
        setText("Просмотр таблицы рекордов");
        //Слушатель кнопки
        addActionListener(e -> {
//            JFrameSelection jFrameSelection = new JFrameSelection(frameBullsAndCows); //вызвали класс выбора разрядности.
//            int intBitDepth = jFrameSelection.startJFrameSelection(); // После выбора, нам вернётся число разрядности.
            int intBitDepth = new JFrameSelection(frameBullsAndCows).startJFrameSelection();

// Меняем таблицу Рекордов согласно выбранной разрядности. Данные берём из БД
            String nameTable = "" + HighScoreTableName.findByValueHighScoreTableName(intBitDepth);
            SQLiteConnectorForHighScoreTable sqLiteConnectorForHighScoreTable = new SQLiteConnectorForHighScoreTable(nameTable);
            frameBullsAndCows.tableModelHighScore.updateData(sqLiteConnectorForHighScoreTable.selectData(nameTable));

// В зависимости от выбранной разрядности, меняется отображение соответствующей таблицы Рекордов, а значит нужно поменять заголовок рамки этой таблицы.
            frameBullsAndCows.lineName = "" + BitDepth.findByValueBitDepth(intBitDepth);
            frameBullsAndCows.titledBorderHighScoreTable.setTitle("Таблица Рекордов(" + frameBullsAndCows.lineName  + " число)");
            frameBullsAndCows.pnEast.repaint(); // Обновление отображения панели pnEast
        });
    }
}
