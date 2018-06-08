package ru.rrozhkov.easykin.person;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.gui.PersonGUIFactory;
import ru.rrozhkov.easykin.person.service.impl.PersonService;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/17/2017.
 */
public class Module {
    private static IModuleGUIFactory personGUIFactory = new PersonGUIFactory();
    private static final PersonService personService = new PersonService();

    public static Component createEditor(IGUIEditor parent, IPerson person){
        return personGUIFactory.createEditor(parent,person);
    }
    public static Collection persons(){
        return personService.persons();
    }
}
