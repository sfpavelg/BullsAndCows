package org.example.bullsAndCowsbullsAndCows.repository;

import java.sql.*;
import java.util.ArrayList;
//Класс соединения с таблицей в БД в случае, если разрядность загаданного числа выбрана:3.
public class SQLiteConnectorForHighScoreTable {
    private Connection connection;

    /**
     * Конструктор создаёт соединение с БД посредством нужного драйвера.
     * И вызывается метод создающий соответствующую таблицу, если таковой нет.
     */
    public SQLiteConnectorForHighScoreTable(String tableName) {
        try {
            Class.forName("org.sqlite.JDBC"); //поиск драйвера SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:database.db"); //Соединение с БД database.db, одно на все запросы

            // Создание таблицы, если она не существует
            createTableHighScore(tableName); // Запрос к БД. Создаём, если ещё не создана, таблицу рекордов.
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
    private void createTableHighScore(String tableName) throws SQLException { //В этом запросе может быть исключение, но обработку пробрасываем дальше
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, attempts TEXT, times TEXT, rating TEXT)"; //SQL запрос
        PreparedStatement statement = connection.prepareStatement(sql); //Это и есть запрос к БД. Это как грузовик, а connection - дорога до БД, sql - то что нужно отвезти
        statement.execute(); //Команда грузовику statement - "ехать!"
    }

    /**
     * Когда пользователь победил, вызывается данный метод и заполняется таблица highScoreBitDepth3 в БД.
     *
     * @param username - На вход принимаем имя текущего пользователя
     * @param attempts - Количество попыток, за которые достигнута победа.
     * @param times    - Время за которое достигнута победа.
     * @param rating   - Определён рейтинг на основании количества попыток и затраченного времени.
     */

    public void insertData(String tableName, String username, String attempts, String times, String rating) {
        String insertDataSql = "INSERT INTO " + tableName + " (username, attempts, times, rating) VALUES (?, ?, ?, ?)"; //Заносим данные "Победы" в БД
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
     * Метод собирает всё из таблицы рекордов highScoreBitDepth3 из БД.
     * Cначало кладёт данные в коллекцию типа Список,
     * посредством временного создания массива на пять ячеек, и заполнения Список через цикл while.
     * Затем формирует двумерный массив и заполняет его данными из Списка через цикл for.
     *
     * @return Object[][] - заполненный двумерный массив
     */
    public Object[][] selectData(String tableName) { //highScoreBitDepth3
        String selectDataSql = "SELECT * FROM " + tableName + " ORDER BY attempts, times"; //Забираем все данные из БД
        Object[][] newData = null; // Объявляем двумерный массив.
        try {
            PreparedStatement selectStatement = connection.prepareStatement(selectDataSql); // Запрос в БД
            ResultSet resultSet = selectStatement.executeQuery(); // результат запроса кладём в ResultSet

            ArrayList<Object[]> dataList = new ArrayList<>(); // Список для хранения данных из БД
            // Используем итератор и из ResultSet заполняем Список
            while (resultSet.next()) {
                Object[] rowData = new Object[5]; // Создаём временный массив на 5 ячеек
                rowData[0] = resultSet.getInt("id"); // в каждую кладём соответсвующее значение
                rowData[1] = resultSet.getString("username");
                rowData[2] = resultSet.getString("attempts");
                rowData[3] = resultSet.getString("times");
                rowData[4] = resultSet.getString("rating");
                dataList.add(rowData); // это будет соответствовать одной полностью заполненной строке. и так по циклу, пока строки не закончатся.
            } // По окончанию цикла у нас будет заполненный Список, где каждый элемент, это пятизначный массив - строка

            // теперь нужно преобразовать преобразовать Список в двумерный массив данных
            newData = new Object[dataList.size()][5];
            for (int i = 0; i < dataList.size(); i++) {
                newData[i] = dataList.get(i);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newData; // Возвращаем заполненный двумерный массив, который будет основанием модели таблицы Рекордов.
    }
}


