package org.example.bullsAndCowsbullsAndCows.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLiteConnector {
    private Connection connection;

    /**
     *  connection - подключение к БД SQLite с названием database.db
     *  Если подключение произошло, и БД с именем database.db, такая БД будет автоматически создана.
     *  Ео подключения не будет, если отсутствует драйвер SQLite.
     *  Для подключения драйвера к проекту нужно сделать следующее:
     *  1. Подключить Maven к проекту (как это сделать описано ниже).
     *  2. В pom-файле прописать зависимость:
     *  <!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
     * <dependency>
     *     <groupId>org.xerial</groupId>
     *     <artifactId>sqlite-jdbc</artifactId>
     *     <version>3.34.0</version>
     * </dependency>
     *  3. Обновите Maven (Зайдите в раздел Maven и нажмите  "Reload All Maven Project")
     *  4. Затем выполните сборку проекта (Ctrl + F9), и драйвер SQLite JDBC будет автоматически загружен и включен в ваш проект.
     *  5. Запустите проект, зайдите в раздел "Авторизация" Заполните поля "user" и "password", нажмите кнопку "регистрация"
     *  Если БД подключилась, то ошибок не будет.
     *  6. Настройте в IDEA панель "Database" для просмотра содержания таблиц в БД. Для этого дважды кликните по файлу database.db
     *  и настройте нужные схемы.
     *
     *  Для подключения Maven к проекту:
     * 1. Откройте IntelliJ IDEA и свой проект.
     * 2. Перейдите в меню "File" (Файл) и выберите пункт "Settings" (Настройки).
     * 3. В поисковой строке в верхней части окна настроек введите "Maven".
     * 4. В разделе "Build, Execution, Deployment" (Сборка, выполняемые действия, развертывание) щелкните "Maven"
     * и перейдите в раздел "Maven home directory" (Директория Maven).
     * 5. Проверьте, установлен ли Maven на вашем компьютере. Если Maven не установлен, вам нужно скачать его и установить.
     * Вы можете скачать Maven с официального сайта: https://maven.apache.org/download.cgi
     * 6. После установки Maven укажите путь к директории Maven, где он был установлен.
     * 7. Щелкните кнопку "Apply" (Применить) и "OK" для сохранения настроек.
     * Теперь Maven будет подключен к вашему проекту в IntelliJ IDEA. Вы можете добавить зависимости,
     * указав их в файле `pom.xml` вашего проекта.
     * Также вам может понадобиться выполнить обновление проекта, чтобы IntelliJ IDEA обнаружила изменения,
     * связанные с использованием Maven. Для этого щелкните правой кнопкой мыши на файле `pom.xml` в рамке проекта
     * и выберите пункт "Maven" -> "Reload Project" (Maven -> Обновить проект).
     * После обновления проекта вы сможете добавлять зависимости Maven и использовать их в вашем проекте.
     */

    public SQLiteConnector() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");

            // Создание таблицы, если она не существует
            createTable();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }

    public void insertUser(String username, String password) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}