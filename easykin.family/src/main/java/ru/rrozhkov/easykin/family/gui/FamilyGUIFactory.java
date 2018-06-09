package ru.rrozhkov.easykin.family.gui;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.gui.PersonForm;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class FamilyGUIFactory implements IModuleGUIFactory<IPerson> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class FamilyGUIFactoryHolder {
        public static final FamilyGUIFactory INSTANCE = new FamilyGUIFactory();
    }

    public static FamilyGUIFactory instance(){
        return FamilyGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new FamilyTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, IPerson person) {
        return new PersonForm(parent,person);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
