package org.example.bullsAndCowsbullsAndCows.repository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class SQLiteConnectorForHighScoreTable {
    private Connection connection;

    public SQLiteConnectorForHighScoreTable() {

        try {
            Class.forName("org.sqlite.JDBC"); //поиск драйвера SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:database.db"); //Соединение с БД database.db, одно на все запросы

            // Создание таблицы, если она не существует
            createTableHighScore(); // Запрос к БД. Создаём, если ещё не создана, таблицу рекордов.
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создающий Рейтинговую таблицу в БД, если этой таблицы там нет.
     * У таблицы 5 колонок, id - автоматический ключ-идентификатор, username - имя игрока, attempts - количество попыток,
     * times - время прохождения игры, rating - рейтинг
     *
     * @throws SQLException - ожидаемое, но не обрабатываемое исключение
     */
    private void createTableHighScore() throws SQLException { //В этом запросе может быть исключение, но обработку пробрасываем дальше
        String sql = "CREATE TABLE IF NOT EXISTS highScore (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, attempts TEXT, times TEXT, rating TEXT)"; //SQL запрос, но пока это просто String переменная
        PreparedStatement statement = connection.prepareStatement(sql); //Это и есть запрос к БД. Это как грузовик, а connection - дорога до БД, sql - то что нужно отвезти
        statement.execute(); //Команда грузовику statement - "ехать!"
    }

    public void insertData(String username, String attempts, String times, String rating) {
        String insertDataSql = "INSERT INTO highScore (username, attempts, times, rating) VALUES (?, ?, ?, ?)"; //Заносим данные "Победы" в БД
        try {
            PreparedStatement insertStatement = connection.prepareStatement(insertDataSql);
            insertStatement.setString(1, username);
            insertStatement.setString(2, attempts);
            insertStatement.setString(3, times);
            insertStatement.setString(4, rating);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Описание...
     * @return
     */
    public Object[][] selectData() {
        String selectDataSql = "SELECT * FROM highScore ORDER BY attempts, times"; //Забираем все данные из БД
        Object[][] newData = null;
        try {
            PreparedStatement selectStatement = connection.prepareStatement(selectDataSql);
            ResultSet resultSet = selectStatement.executeQuery();

            ArrayList<Object[]> dataList = new ArrayList<>(); // Список для хранения данных из базы данных
            // Итерироваться по результатам запроса и добавлять данные в список
            while (resultSet.next()) {
                Object[] rowData = new Object[5];
                rowData[0] = resultSet.getInt("id");
                rowData[1] = resultSet.getString("username");
                rowData[2] = resultSet.getString("attempts");
                rowData[3] = resultSet.getString("times");
                rowData[4] = resultSet.getString("rating");
                dataList.add(rowData);
            }
            // Преобразовать список в двумерный массив данных
            newData = new Object[dataList.size()][5];
            for (int i = 0; i < dataList.size(); i++) {
                newData[i] = dataList.get(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newData;
    }
}


