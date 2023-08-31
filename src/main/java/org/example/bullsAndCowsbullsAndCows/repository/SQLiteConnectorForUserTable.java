package org.example.bullsAndCowsbullsAndCows.repository;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SQLiteConnectorForUserTable {
    private Connection connection;

    /**
     * Connection - подключение к БД SQLite с названием database.db
     * Если подключение произошло, и БД с именем database.db, такая БД будет автоматически создана.
     * Но подключения не будет, если отсутствует драйвер SQLite.
     * Для подключения драйвера к проекту нужно сделать следующее:
     * 1. Подключить Maven к проекту (как это сделать описано ниже).
     * 2. В pom-файле прописать зависимость:
     * <!-- https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc -->
     * <dependency>
     * <groupId>org.xerial</groupId>
     * <artifactId>sqlite-jdbc</artifactId>
     * <version>3.34.0</version>
     * </dependency>
     * 3. Обновите Maven (Зайдите в раздел Maven и нажмите  "Reload All Maven Project")
     * 4. Затем выполните сборку проекта (Ctrl + F9), и драйвер SQLite JDBC будет автоматически загружен и включен в ваш проект.
     * 5. Запустите проект, зайдите в раздел "Авторизация" Заполните поля "user" и "password", нажмите кнопку "регистрация"
     * Если БД подключилась, то ошибок не будет.
     * 6. Настройте в IDEA панель "Database" для просмотра содержания таблиц в БД. Для этого дважды кликните по файлу database.db
     * и настройте нужные схемы.
     * <p>
     * Для подключения Maven к проекту:
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

    public SQLiteConnectorForUserTable() {
        try {
            Class.forName("org.sqlite.JDBC"); //поиск драйвера SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:database.db"); //Соединение с БД database.db, одно на все запросы

//            String  databaseFilePath = "https://drive.google.com/file/d/1rlILdlYSwQ0dEzcbC_JjuMmF4aCL8Apy/view?usp=drive_link";
//            String url = "jdbc:sqlite::resource:" + databaseFilePath; // путь к файлу базы данных на удаленном диске
//            connection = DriverManager.getConnection(url);

            // Создание таблицы, если она не существует
            createTableUser(); // А вот и первый запрос к БД. Создаём, если ещё не создана, таблицу юзеров. Этот метод в блоке try-catch, именно тут обработаем исключение.
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод создающий таблицу user в БД, если этой таблицы там нет.
     * У таблицы 3 колонки, id - автоматический ключ-идентификатор, username и password
     *
     * @throws SQLException - ожидаемое, но не обрабатываемое исключение
     */
    private void createTableUser() throws SQLException { //В этом запросе может быть исключение, но обработку пробрасываем дальше
        String sql = "CREATE TABLE IF NOT EXISTS user (id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)"; //SQL запрос, но пока это просто String переменная
        PreparedStatement statement = connection.prepareStatement(sql); //Это и есть запрос к БД. Это как грузовик, а connection - дорога до БД, sql - то что нужно отвезти
        statement.execute(); //Команда грузовику statement - "ехать!"
    }

    /**
     * Метод добавляющий пользователя. На входе аргументы: (String username, String password).
     * Метод проверяет длину имени пользователя, если длинна более 30 символов, то выскочит окно предупреждения.
     * Метод проверяет на наличие пользователя с таким именем в БД, если будет совпадение, то выскочит предупреждение.
     *
     * @param username - имя пользователя
     * @param password - пароль
     */
    public void insertUser(String username, String password) {
        // Проверяем длину имени пользователя
        if (username.length() > 10 | username.length() == 0) {
            JOptionPane.showMessageDialog(null, "Имя пользователя должно содержать не более 10 символов!\n" +
                    "И должно состоять хотя бы из одного символа!");
            return;
        }
        // SQL запросы
        String checkSql = "SELECT COUNT(*) FROM user WHERE username = ?"; //Проверяем: есть ли юзер с таким именем?
        String insertSql = "INSERT INTO user (username, password) VALUES (?, ?)"; //Добавляем юзера с паролем
        try {
            // Проверяем наличие пользователя с заданным именем
            PreparedStatement checkStatement = connection.prepareStatement(checkSql); // Первый запрос, который соберёт всех юзеров с таким именем
            checkStatement.setString(1, username); // Передали нужный параметр (имя) в этот запрос
            ResultSet resultSet = checkStatement.executeQuery(); //  Поместили результат запроса поиска по имени в объект ResultSet
            resultSet.next(); // Переходим на первую строку результата

            // Если количество найденных пользователей больше 0, то выводим предупреждение
            if (resultSet.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Пользователь с таким именем уже существует!");
                return;
            }

            // Если пользователя с заданным именем нет, выполняем вставку
            PreparedStatement insertStatement = connection.prepareStatement(insertSql);
            insertStatement.setString(1, username);
            insertStatement.setString(2, password);
            insertStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Пользователь успешно зарегистрирован!\nНажмите кнопку смены пользователя.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод смены зарегистрированного пользователя.
     *
     * @param username - первый входной параметр это имя пользователя
     * @param password - второй входной параметр это пароль
     * @return - возвратом будет имя пользователя, если такой пользователь найден, либо null
     */
    public String changeUser(String username, String password) {
        // SQL- запрос в БД. Берём имя пользователя username из таблицы user, где username равен приходящему параметру и password равен приходящему параметру
        String selectSql = "SELECT username FROM user WHERE username = ? AND password = ?";
        try { // Блок try-catch для выполнения кода и обработки исключений
            /**
             * `PreparedStatement` - это интерфейс в Java, представляющий подготовленные операторы SQL,
             * которые используются для выполнения параметризованных запросов к базе данных.
             * Он представляет предварительно откомпилированный SQL-запрос, в котором значения параметров могут быть установлены позже.
             *
             * `connection` - это объект типа `Connection`, который представляет соединение с базой данных.
             * Обычно соединение создается с использованием драйвера JDBC для конкретной базы данных.
             *
             * `prepareStatement(selectSql)` - это метод `prepareStatement()`, вызываемый на объекте `connection`,
             * который создает экземпляр `PreparedStatement`. В качестве параметра `selectSql` передается SQL-запрос, который будет подготовлен и выполнен.
             *
             * В итоге, `selectStatement` будет ссылкой на объект `PreparedStatement`,
             * который содержит предварительно подготовленный SQL-запрос и может быть использован для выполнения запроса к базе данных.
             * Этот объект позволяет установить значения параметров в запросе (`selectStatement.setXXX()`)
             * и выполнить запрос с помощью метода `executeQuery()` или `executeUpdate()`.
             */
            PreparedStatement selectStatement = connection.prepareStatement(selectSql);
            selectStatement.setString(1, username); // Первым параметром передаём имя пользователя
            selectStatement.setString(2, password); // Вторым параметром передаём пароль
            ResultSet resultSet = selectStatement.executeQuery(); //Результат запроса помещаем в специальный объект ResultSet

            // Проверяем наличие совпадения логина и пароля
            if (resultSet.next()) { // Метод next() булевый, если значение есть, и курсор к нему переместился, значит вернётся true.
                return resultSet.getString("username"); // Тогда возвращаем имя пользователя
            }

        } catch (SQLException e) { // Обрабатываем исключение
            e.printStackTrace();
        }
        return null; // Если совпадения не найдены, возвращаем null
    }


    // Метод закрытия соединения с БД
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