package ru.rrozhkov.easykin.person;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.gui.PersonGUIFactory;

import java.awt.Component;

/**
 * Created by rrozhkov on 8/17/2017.
 */
public class Module {
    private static IModuleGUIFactory personGUIFactory = PersonGUIFactory.instance();

    public static Component createEditor(IGUIEditor parent, IPerson person){
        return personGUIFactory.createEditor(parent,person);
    }
}
