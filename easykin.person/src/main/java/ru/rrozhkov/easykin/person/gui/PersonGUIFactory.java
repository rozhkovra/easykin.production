package ru.rrozhkov.easykin.person.gui;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class PersonGUIFactory implements IGUIFactory{
    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return new JPanel();
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        return new PersonForm(parent,(IPerson)obj);
    }

    public JPanel createFilter(IGUIEditor parent) {
        return new JPanel();
    }
}
