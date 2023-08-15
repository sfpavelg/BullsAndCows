package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;
import org.example.bullsAndCowsbullsAndCows.repository.SQLiteConnector;

import javax.swing.*;

public class ButtonUserChange extends JButton {
    private RegistrationDialog registrationDialog;
    private SQLiteConnector connector;
    private JLabel lblUserName;

    public ButtonUserChange(RegistrationDialog registrationDialog, JLabel lblUserName) {
        this.registrationDialog = registrationDialog;
        this.lblUserName = lblUserName;
        setText("Сменить пользователя");
        addActionListener(e -> {
            // Здесь вы можете получить значения из RegistrationDialog
            String username = registrationDialog.getUsername();
            String password = registrationDialog.getPassword();

            // ... выполните необходимые действия с полученными значениями ...
            connector = new SQLiteConnector();
            connector.changeUser(username, password);
            connector.closeConnection();
            lblUserName.setText(username);
        });
    }
}