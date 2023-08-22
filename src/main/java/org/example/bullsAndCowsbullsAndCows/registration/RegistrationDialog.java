package org.example.bullsAndCowsbullsAndCows.registration;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.button.ButtonRegistration;
import org.example.bullsAndCowsbullsAndCows.button.ButtonUserChange;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrationDialog extends JDialog { // Наследуемся от JDialog
    private JTextField usernameField;
    private JTextField passwordField;
    private ButtonUserChange changeUserButton;
    private ButtonRegistration registerButton;
    private JLabel lblUserName;

    public RegistrationDialog(FrameBullsAndCows frameBullsAndCows, JLabel lblUserName) {
        super(frameBullsAndCows, "Зарегистрируйтесь, или зайдите под своей учётной записью!", true); // Заголовок
        this.lblUserName = lblUserName;
        usernameField = new JTextField(20); // Поле ввода имени
        passwordField = new JTextField(20); // Поле ввода пароля
        changeUserButton = new ButtonUserChange(this, lblUserName); // Кнопка смены пользователя
        registerButton = new ButtonRegistration(this); // Кнопка Регистрации

        JPanel panel = new JPanel(); // Создаём панель, добавляем на неё поля и кнопки
        panel.add(new JLabel("Имя пользователя:"));
        panel.add(usernameField);
        panel.add(new JLabel("Пароль:"));
        panel.add(passwordField);
        panel.add(changeUserButton);
        panel.add(registerButton);

        add(panel); // Добавляем заполненную панель на JDialog
        /**
         * Когда вы вызываете метод `pack()` на экземпляре класса `JDialog`,
         * он анализирует компоненты (например, панели, метки, кнопки и т.д.),
         * которые содержит окно, и автоматически устанавливает его размеры и расположение
         * таким образом, чтобы все содержимое было видимым.
         */
        pack();
        setLocationRelativeTo(frameBullsAndCows); // Выравнивание по центру основного окна frameBullsAndCows

    }

    // Методы для получения значений полей
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }
}
