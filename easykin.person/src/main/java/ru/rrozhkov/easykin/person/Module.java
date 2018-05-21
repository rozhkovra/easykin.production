package ru.rrozhkov.easykin.person;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.db.impl.PersonHandler;
import ru.rrozhkov.easykin.person.gui.PersonGUIFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/17/2017.
 */
public class Module {
    private static IGUIFactory personGUIFactory = new PersonGUIFactory();
    public static JPanel createEditor(IGUIEditor parent, IPerson person){
        return personGUIFactory.createEditor(parent,person);
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
