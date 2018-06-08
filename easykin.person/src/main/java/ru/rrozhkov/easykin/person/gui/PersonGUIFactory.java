package ru.rrozhkov.easykin.person.gui;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class PersonGUIFactory implements IModuleGUIFactory<IPerson> {
    private final static IGUIFactory guiFactory = GUIFactory.create();
    public static class PersonGUIFactoryHolder {
        public static final PersonGUIFactory INSTANCE = new PersonGUIFactory();
    }

    public static PersonGUIFactory instance(){
        return PersonGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.panelEmpty();
    }

    public Component createEditor(IGUIEditor parent, IPerson person) {
        return new PersonForm(parent,person);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
