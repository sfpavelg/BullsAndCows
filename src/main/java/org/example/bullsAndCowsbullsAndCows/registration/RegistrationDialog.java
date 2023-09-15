package org.example.bullsAndCowsbullsAndCows.registration;

import org.example.bullsAndCowsbullsAndCows.frames.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.button.ButtonRegistration;
import org.example.bullsAndCowsbullsAndCows.button.ButtonUserChange;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrationDialog extends JDialog { // Наследуемся от JDialog
    private JTextField usernameField;
    private JPasswordField passwordField;
    private ButtonUserChange changeUserButton;
    private ButtonRegistration registerButton;
    private JLabel lblUserName;

    public RegistrationDialog(FrameBullsAndCows frameBullsAndCows, JLabel lblUserName) {
        super(frameBullsAndCows, "Зарегистрируйтесь, или зайдите под своей учётной записью!", true); // Заголовок
        this.lblUserName = lblUserName;
        usernameField = new JTextField(20); // Поле ввода имени
        passwordField = new JPasswordField(20);
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

        // Добавляем слушатель KeyListener кнопки клавиатуры Enter к текстовому полю ввода пароля.
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    changeUserButton.doClick(); // Вызываем событие клика для кнопки "ButtonUserChange"
                }
            }
        });

    }

    // Методы для получения значений полей
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}
