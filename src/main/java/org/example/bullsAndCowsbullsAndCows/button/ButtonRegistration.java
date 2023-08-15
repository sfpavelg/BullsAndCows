package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnector;

import javax.swing.*;

public class ButtonRegistration extends JButton {
    RegistrationDialog registrationDialog;
    SQLiteConnector connector;
    public ButtonRegistration( RegistrationDialog registrationDialog) {
        this.registrationDialog = registrationDialog;
        setText("Зарегистрироваться");
        addActionListener(e -> {
            // Здесь вы можете получить значения из RegistrationDialog
            String username = registrationDialog.getUsername();
            String password = registrationDialog.getPassword();

            // ... выполните необходимые действия с полученными значениями ...
            connector = new SQLiteConnector();
            connector.insertUser(username, password);

            connector.closeConnection();
        });
    }
}
