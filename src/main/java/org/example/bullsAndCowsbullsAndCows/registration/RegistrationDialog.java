package org.example.bullsAndCowsbullsAndCows.registration;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.button.ButtonRegistration;
import org.example.bullsAndCowsbullsAndCows.button.ButtonUserChange;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationDialog extends JDialog {
    private JTextField usernameField;
    private JTextField passwordField;
    private ButtonUserChange changeUserButton;
    private ButtonRegistration registerButton;
    private JLabel lblUserName;

    public RegistrationDialog(FrameBullsAndCows frameBullsAndCows, JLabel lblUserName) {
        super(frameBullsAndCows, "Регистрация", true);
        this.lblUserName = lblUserName;
        usernameField = new JTextField(20);
        passwordField = new JTextField(20);
        changeUserButton = new ButtonUserChange(this, lblUserName);
        registerButton = new ButtonRegistration(this);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Имя пользователя:"));
        panel.add(usernameField);
        panel.add(new JLabel("Пароль:"));
        panel.add(passwordField);
        panel.add(changeUserButton);
        panel.add(registerButton);

        add(panel);
        pack();
        setLocationRelativeTo(frameBullsAndCows); // Выравнивание по центру основного окна

        // Добавьте обработчики событий для кнопок `changeUserButton` и `registerButton`
        // для выполнения соответствующих действий при их нажатии.
    }

    // Методы для получения значений полей
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
}
