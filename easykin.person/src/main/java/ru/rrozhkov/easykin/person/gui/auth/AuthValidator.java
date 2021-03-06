package ru.rrozhkov.easykin.person.gui.auth;

import ru.rrozhkov.easykin.person.auth.AuthManager;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Created by rrozhkov on 6/28/2017.
 */
public class AuthValidator {
    private static final AuthManager authManager = AuthManager.instance();

    public boolean validateAuthForm(JTextField username, JPasswordField password){
        return !username.getText().isEmpty()
                && password.getPassword().length > 0;
    }
    public boolean validateSignedUsername(String username){
        return authManager.isSignedIn() && username.equals(authManager.signedPerson().getUsername());
    }
}
