package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnectorForUserTable;

import javax.swing.*;

public class ButtonRegistration extends JButton {
    RegistrationDialog registrationDialog;
    SQLiteConnectorForUserTable connector;

    public ButtonRegistration(RegistrationDialog registrationDialog) {
        this.registrationDialog = registrationDialog;
        setText("Зарегистрироваться");
        addActionListener(e -> {
            // Здесь вы можете получить значения из RegistrationDialog
            String username = registrationDialog.getUsername();
            String password = registrationDialog.getPassword();

            // ... выполните необходимые действия с полученными значениями ...
            connector = new SQLiteConnectorForUserTable();
            connector.insertUser(username, password);

            connector.closeConnection();
        });
    }
}
