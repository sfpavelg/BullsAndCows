package org.example.bullsAndCowsbullsAndCows.button;

import org.example.bullsAndCowsbullsAndCows.FrameBullsAndCows;
import org.example.bullsAndCowsbullsAndCows.registration.RegistrationDialog;

import javax.swing.*;

public class ButtonAuthorization extends JButton {
    RegistrationDialog registrationDialog;
    FrameBullsAndCows frameBullsAndCows;
    public ButtonAuthorization(FrameBullsAndCows frameBullsAndCows){
        this.frameBullsAndCows = frameBullsAndCows;
        setText("Авторизация");
        addActionListener(e -> {
            openRegistrationDialog();
        });
    }
    private void openRegistrationDialog() {
        registrationDialog = new RegistrationDialog(frameBullsAndCows);
        registrationDialog.setVisible(true);
    }
}
