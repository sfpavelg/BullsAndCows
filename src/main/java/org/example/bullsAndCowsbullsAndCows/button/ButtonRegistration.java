package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;

import javax.swing.*;

public class ButtonRegistration extends JButton {
    FrameBullsAndCows frameBullsAndCows;
    public ButtonRegistration(FrameBullsAndCows frameBullsAndCows){
        this.frameBullsAndCows = frameBullsAndCows;
        setText("Регистрация");
        addActionListener(e -> {
            openRegistrationDialog();
        });
    }
    private void openRegistrationDialog() {
        RegistrationDialog dialog = new RegistrationDialog(frameBullsAndCows);
        dialog.setVisible(true);

        // Здесь вы можете получить значения из RegistrationDialog
        String username = dialog.getUsername();
        String password = dialog.getPassword();

        // ... выполните необходимые действия с полученными значениями ...
    }
}
