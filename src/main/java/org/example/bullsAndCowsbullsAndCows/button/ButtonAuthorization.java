package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;

import javax.swing.*;

public class ButtonAuthorization extends JButton {
    private RegistrationDialog registrationDialog;
    private FrameBullsAndCows frameBullsAndCows;
    private JLabel lblUserName;

    public ButtonAuthorization(FrameBullsAndCows frameBullsAndCows, JLabel lblUserName) {
        this.frameBullsAndCows = frameBullsAndCows;
        this.lblUserName = lblUserName;
        setText("Авторизация");
        addActionListener(e -> {
            openRegistrationDialog();
        });
    }

    private void openRegistrationDialog() {
        registrationDialog = new RegistrationDialog(frameBullsAndCows, lblUserName);
        registrationDialog.setVisible(true);
    }
}
