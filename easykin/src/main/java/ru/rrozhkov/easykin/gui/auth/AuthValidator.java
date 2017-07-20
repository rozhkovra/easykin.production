package ru.rrozhkov.easykin.gui.auth;

import ru.rrozhkov.easykin.auth.AuthManager;

import javax.swing.*;

/**
 * Created by rrozhkov on 6/28/2017.
 */
public class AuthValidator {
    public static boolean validateAuthForm(JTextField username, JPasswordField password){
        return !username.getText().toString().isEmpty()
                && !password.getText().toString().isEmpty();
    }
    public static boolean validateSignedUsername(String username){
        return AuthManager.instance().isSignedIn() && username.equals(AuthManager.instance().signedPerson().getUsername());
    }
}
