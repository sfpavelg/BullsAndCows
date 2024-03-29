package org.example.bullsAndCowsbullsAndCows.tableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

//Класс, который является моделью, принимающей данные истории попыток
public class TableModelHighScore extends AbstractTableModel {
    private String[] columnNames = {"№", "Игрок", "П", "Время", "Ранг"}; //Собираем столбцы в массив строк, это будет шапка таблицы.
    private Object[][] data; //Двумерный массив будет телом таблицы. То есть каждая строка будет содержать значения *********************

    public TableModelHighScore(Object[][] data) { //Конструктором принимаем данные на вход: заполненный массив и табличную панель
        this.data = data;

    }

    /**
     * Така как абстрактный класс AbstractTableModel имплементируется интерфейсом TableModel,
     * то все его методы нужно переопределить.
     * Часть методов переопределены в абстрактном классе AbstractTableModel.
     * Но есть методы, которые нам нужно переопределить в нашем классе наследнике.
     * <p>
     * getRowCount() это метод возврата длинны общего массива, он будет соответствовать количеству строк на какой-то текущий момент
     *
     * @return data.length
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * getColumnCount() это метод возврата длинны ячейки, он всегда будет длинною в 4 элемента. Использовать этот метод не будем, но переопределить обязаны.
     *
     * @return columnNames.length
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * getValueAt(int row, int column) это метод возврата данных в ячейке по номеру строки и столбца
     *
     * @param row    the row whose value is to be queried
     * @param column the column whose value is to be queried
     * @return data[row][column] Возврат данных ячейки
     */
    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

    /**
     * getColumnName(int column) этот метод возврата имени колонки, по её номеру.
     *
     * @param column Номер колонки
     * @return columnNames[column]
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * getColumnClass(int column) этот метод нужен для позиционирования колонок по центу
     *
     * @param column Номер колонки
     * @return CenteredTableCellRenderer.class вызываем работу класса позиционирования на колонке с таким индексом
     */
    @Override
    public Class<?> getColumnClass(int column) {
        return CenteredTableCellRenderer.class;
    }

    // Метод для обновления данных в таблице:
    public void updateData(Object[][] newData) {
        data = newData;
        fireTableDataChanged(); //это реализованный метод в AbstractTableModel
    }

    // Метод для очистки данных в таблице:
    public void clearData() {
        data = new Object[0][0];
        fireTableDataChanged();
    }
}
