package org.example.bullsAndCowsbullsAndCows.tableModel;

import javax.swing.table.AbstractTableModel;

//Класс, который является моделью, принимающей данные истории попыток
public class TableModelStory extends AbstractTableModel {
    private String[] columnNames = {"Число", "Б", "К"}; //Собираем столбцы в массив строк, это будет шапка таблицы.

    //Двумерный массив будет телом таблицы. То есть каждая строка будет содержать значения Data.numberEnter, Data.bulls, Data.cows
    private Object[][] data;

    public TableModelStory(Object[][] data) { //Конструктором принимаем данные на вход: заполненный массив
        this.data = data;
    }

    /**
     * Така как абстрактный класс AbstractTableModel имплементируется интерфейсом TableModel,
     * то все его методы нужно переопределить.
     * Часть методов переопределены в абстрактном классе AbstractTableModel.
     * Но есть методы, которые нам нужно переопределить в нашем классе наследнике.
     *
     * getRowCount() это метод возврата длинны общего массива, он будет соответствовать количеству строк на какой-то текущий момент
     * @return data.length
     *
     * getColumnCount() это метод возврата длинны ячейки, он всегда будет длинною в 3 элемента. Использовать этот метод не будем, но переопределить обязаны.
     * @return columnNames.length
     *
     * getValueAt(int row, int column) это метод возврата данных в ячейке по номеру строки и столбца
     * @param  row Номер строки
     * @param  column Номер колонки
     * @return  data[row][column] Возврат данных ячейки
     *
     * getColumnName(int column) этот метод возврата имени колонки, по её номеру.
     * @param column Номер колонки
     * @return  columnNames[column]
     *
     */
    @Override
    public int getRowCount() { return data.length; }

    @Override
    public int getColumnCount() { return columnNames.length; }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Новый метод для обновления данных в таблице:
    public void updateData(Object[][] newData) {
        data = newData;
        fireTableDataChanged(); //это реализованный метод в AbstractTableModel
    }
}
