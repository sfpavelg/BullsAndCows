package org.example.bullsAndCowsbullsAndCows.tableModel;

import javax.swing.table.AbstractTableModel;

public class TableModelStory extends AbstractTableModel {
    private String[] columnNames = {"Число", "Б", "К"};
    private Object[][] data;

    public TableModelStory(Object[][] data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return data[row][column];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Добавьте метод для обновления данных в таблице:
    public void updateData(Object[][] newData) {
        data = newData;
        fireTableDataChanged();
    }
}
