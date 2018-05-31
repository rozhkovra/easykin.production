package ru.rrozhkov.easykin.person.gui.auth;


import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;
import java.awt.*;

public class AuthForm extends Form {
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private Component usernameLabel;
	private Component passwordLabel;

	public AuthForm(final IGUIEditor parent) {
		super(parent);

		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(3, 2));
		add(getUsernameLabel());
		add(getUsernameField());
		add(getPasswordLabel());
		add(getPasswordField());
		add(getOkButton());
		add(getCancelButton());
		getPasswordField().requestFocus();
	}
	
	private JTextField getUsernameField(){
		if(usernameField == null){
			usernameField = new JTextField(50);
			usernameField.addKeyListener(keyListener());
		}
		return usernameField;
	}

	private JPasswordField getPasswordField(){
		if(passwordField == null){
			passwordField = (JPasswordField) guiFactory.password();
			passwordField.addKeyListener(keyListener());
		}
		return passwordField;
	}
	
	private Component getUsernameLabel(){
		if(usernameLabel == null)
			usernameLabel = guiFactory.label("Пользователь");
		return usernameLabel;
	}
	
	private Component getPasswordLabel(){
		if(passwordLabel == null)
			passwordLabel = guiFactory.label("Пароль");
		return passwordLabel;
	}

	protected void ok(){
		if (!AuthValidator.validateAuthForm(getUsernameField(), getPasswordField())) {
			JOptionPane.showMessageDialog((Component)parent, "Username or password can't be empty!!!");
			return;
		}
		if (AuthValidator.validateSignedUsername(getUsernameField().getText())) {
			JOptionPane.showMessageDialog((Component)parent, "Username is already signed in!!!");
			return;
		}
		AuthManager.instance().signIn(getUsernameField().getText().toString(), getPasswordField().getText().toString());
		if (!AuthManager.instance().isSignedIn()) {
			JOptionPane.showMessageDialog((Component) parent, "Username or password incorrect!!!");
		} else
			parent.closeEditor(IGUIEditor.CODE_OK);
	}

	protected boolean validateData(){
		return !getUsernameField().getText().toString().isEmpty()
				&& !getPasswordField().getText().toString().isEmpty();
	}
}