package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForUserTable;

import javax.swing.*;

public class ButtonUserChange extends JButton {
    private SQLiteConnectorForUserTable connector;

    public ButtonUserChange(RegistrationDialog registrationDialog, JLabel lblUserName) {
        setText("Сменить пользователя");
        addActionListener(e -> {
            // Здесь  получаем значения из RegistrationDialog
            String username = registrationDialog.getUsername();
            String password = registrationDialog.getPassword();

            // Выполняем необходимые действия с полученными значениями.
            connector = new SQLiteConnectorForUserTable();
            connector.changeUser(username, password);
            connector.closeConnection();
            lblUserName.setText(username);
        });
    }
}
