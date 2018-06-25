package ru.rrozhkov.easykin.person.gui;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.Component;
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
        return PersonForm.create(parent,person);
    }

    public Component createView(IGUIEditor parent, IPerson obj) {
        return guiFactory.panelEmpty();
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
