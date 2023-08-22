package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForUserTable;

import javax.swing.*;

public class ButtonUserChange extends JButton {
    private SQLiteConnectorForUserTable connector;

    public ButtonUserChange(RegistrationDialog registrationDialog, JLabel lblUserName) {
        setText("Сменить пользователя");
        addActionListener(e -> { // Слушатель кнопки смены Пользователя
            // Здесь получаем значения из RegistrationDialog, то что было введено в текстовых полях
            String username = registrationDialog.getUsername();
            String password = registrationDialog.getPassword();

            connector = new SQLiteConnectorForUserTable(); // Соединение с БД
            String usernameOut = connector.changeUser(username, password); // Этот метод проверяет по имени и паролю наличие такого пользователя в БД, и вернёт либо имя, либо null
            connector.closeConnection(); //Закрываем соединение
            if (usernameOut == null) {
                JOptionPane.showMessageDialog(null, "Пользователь с таким именем и паролем не существует!", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                lblUserName.setText(usernameOut);
                JOptionPane.showMessageDialog(null, "Приветствую вас, <<" + usernameOut + ">> !", "Смена пользователя", JOptionPane.INFORMATION_MESSAGE);
                registrationDialog.dispose();
            }
        });
    }
}
