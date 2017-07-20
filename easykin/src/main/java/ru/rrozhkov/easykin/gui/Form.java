package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.gui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by rrozhkov on 3/14/2017.
 */
public abstract class Form extends JPanel {
    private Component okButton;
    private Component cancelButton;
    protected IGUIEditor parent;

    public Form(IGUIEditor parent) {
        this.parent = parent;
    }

    protected abstract void fill();

    protected KeyListener keyListener(){
        return new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    ok();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cancel();
                }
            }

            public void keyReleased(KeyEvent e) {

            }
        };
    }
    protected void cancel(){
        parent.closeEditor(IGUIEditor.CODE_CANCEL);
    }

    protected void ok(){}

    protected boolean validateData(){return true;};

    protected Component getOkButton(){
        if(okButton==null){
            okButton = GuiUtil.button("Ок",new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ok();
                }
            });
        }
        return okButton;
    }

    protected Component getCancelButton() {
        if(cancelButton==null){
            cancelButton = GuiUtil.button("Закрыть",new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cancel();
                }
            });
        }
        return cancelButton;
    }
}