package ru.rrozhkov.easykin.person;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.db.impl.PersonHandler;
import ru.rrozhkov.easykin.person.gui.PersonForm;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/17/2017.
 */
public class Module {
    public static JPanel createEditor(IGUIEditor parent, IPerson person){
        return new PersonForm(parent,person);
    }
    public static Collection persons(){
        try {
            return PersonHandler.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CollectionUtil.create();
    }
}
