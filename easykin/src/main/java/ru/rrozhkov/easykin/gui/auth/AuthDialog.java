package ru.rrozhkov.easykin.gui.auth;

import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.ContextUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 6/28/2017.
 */
public class AuthDialog extends JDialog implements IGUIEditor {
    private int code = 0;
    public AuthDialog(Frame owner, boolean modal) {
        super(owner, modal);
        setTitle(ContextUtil.authTitle());
        setSize(400, 150);
        getContentPane().removeAll();
        getContentPane().add(new AuthForm(this));
    }

    public void edit(int index) {

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
