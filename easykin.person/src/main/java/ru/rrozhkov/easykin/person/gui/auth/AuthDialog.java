package ru.rrozhkov.easykin.person.gui.auth;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Created by rrozhkov on 6/28/2017.
 */
public class AuthDialog extends JDialog implements IGUIEditor {
    private int code = 0;
    public AuthDialog(JFrame owner, boolean modal) {
        super(owner, modal);
        setSize(400, 150);
        getContentPane().removeAll();
        getContentPane().add(AuthForm.create(this));
    }

    public void edit(Object obj) {
    }

    public void add() {
    }

    public void closeEditor(int code) {
        finish(code);
    }

    public void refresh() {
    }

    public void finish(int code){
        this.code = code;
        setVisible(false);
    }

    public void start(){
        setVisible(true);
    }

    public int code() {
        return code;
    }
}