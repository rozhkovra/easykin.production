package ru.rrozhkov.easykin.gui.auth;

import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.ContextUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by RRozhkov on 3/7/2017.
 */
public class AuthWindow extends JFrame implements IGUIEditor {
    private boolean finished = false;
    public AuthWindow() throws HeadlessException {
        setTitle(ContextUtil.authTitle());
        setSize(400, 150);
        getContentPane().removeAll();
        getContentPane().add(new AuthForm(this));
        this.finished = false;
    }

    public void edit(int index) {

    }

    public void add() {

    }

    public void closeEditor(int code) {
        finish();
    }

    public void refresh() {

    }

    public boolean isFinished(){
        return finished;
    }

    public void start(){
        finished = false;
        setVisible(true);
    }

    public void finish(){
        setVisible(false);
        finished = true;
    }
}
