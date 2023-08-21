package org.example.bullsAndCowsbullsAndCows.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
     * У таблицы 4 колонки, id - автоматический ключ-идентификатор, username - имя игрока, attempts - количество попыток, times - время прохождения игры
     *
     * @throws SQLException - ожидаемое, но не обрабатываемое исключение
     */
    private void createTableHighScore() throws SQLException { //В этом запросе может быть исключение, но обработку пробрасываем дальше
        String sql = "CREATE TABLE IF NOT EXISTS highScore (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, attempts TEXT, times TEXT)"; //SQL запрос, но пока это просто String переменная
        PreparedStatement statement = connection.prepareStatement(sql); //Это и есть запрос к БД. Это как грузовик, а connection - дорога до БД, sql - то что нужно отвезти
        statement.execute(); //Команда грузовику statement - "ехать!"
    }
}

