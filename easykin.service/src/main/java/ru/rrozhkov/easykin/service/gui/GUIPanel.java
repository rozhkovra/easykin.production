package ru.rrozhkov.easykin.service.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Created by rrozhkov on 12/22/2017.
 */
public abstract class GUIPanel extends JPanel  implements DocumentListener {
    protected Panel parent;

    public GUIPanel(Panel parent) {
        this.parent = parent;
    }

    public void refresh() {
        updateBean();
        updateUI();
        if(parent!=null)
            parent.refresh();

    }

    public void insertUpdate(DocumentEvent e) {
        refresh();
    }

    public void removeUpdate(DocumentEvent e) {
        refresh();
    }

    public void changedUpdate(DocumentEvent e) {
        refresh();
    }

    abstract public void updateBean();
}
