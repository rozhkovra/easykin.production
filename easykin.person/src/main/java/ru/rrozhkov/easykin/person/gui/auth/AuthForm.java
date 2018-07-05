package ru.rrozhkov.easykin.person.gui.auth;


import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Component;

public class AuthForm extends Form {
	private static final long serialVersionUID = 1L;
	private static final AuthManager authManager = AuthManager.instance();
	private static final AuthValidator authValidator = new AuthValidator();

	private JTextField usernameField;
	private JPasswordField passwordField;
	private Component usernameLabel;
	private Component passwordLabel;

	public static Form create(final IGUIEditor parent) {
		Form form = new AuthForm(parent);
		form.fill();
		return form;
	}

	private AuthForm(final IGUIEditor parent) {
		super(parent);
	}
	
	public void fill(){
		setLayout(guiFactory.gridLayout(3, 2));
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
			usernameField = (JTextField) guiFactory.fieldEditable(50, "");
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
		if (!authValidator.validateAuthForm(getUsernameField(), getPasswordField())) {
			JOptionPane.showMessageDialog((Component)parent, "Username or password can't be empty!!!");
			return;
		}
		if (authValidator.validateSignedUsername(getUsernameField().getText())) {
			JOptionPane.showMessageDialog((Component)parent, "Username is already signed in!!!");
			return;
		}
		authManager.signIn(getUsernameField().getText(), String.valueOf(getPasswordField().getPassword()));
		if (!authManager.isSignedIn()) {
			JOptionPane.showMessageDialog((Component) parent, "Username or password incorrect!!!");
		} else
			parent.closeEditor(IGUIEditor.CODE_OK);
	}

	protected boolean validateData(){
		return !getUsernameField().getText().isEmpty()
				&& getPasswordField().getPassword().length > 0;
	}
}