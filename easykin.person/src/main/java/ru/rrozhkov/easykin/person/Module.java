package ru.rrozhkov.easykin.person;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.gui.PersonForm;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

/**
 * Created by rrozhkov on 8/17/2017.
 */
public class Module {
    public static JPanel createEditor(IGUIEditor parent, IPerson person){
        return new PersonForm(parent,person);
    }

}
