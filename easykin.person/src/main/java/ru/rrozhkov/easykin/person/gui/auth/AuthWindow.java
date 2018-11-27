package ru.rrozhkov.easykin.person.gui.auth;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.resources.ImageManager;

import javax.swing.JFrame;
import java.awt.HeadlessException;

/**
 * Created by RRozhkov on 3/7/2017.
 */
public class AuthWindow extends JFrame implements IGUIEditor {
    private boolean finished = false;
    final static private ImageManager imageManager = ImageManager.instance();
    public AuthWindow() throws HeadlessException {
        super("Авторизация");
        setIconImage(imageManager.keyImg(getClass()));
        setSize(400, 150);
        getContentPane().removeAll();
        getContentPane().add(AuthForm.create(this));
        this.finished = false;
    }

    public void edit(Object obj) {

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
