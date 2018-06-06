package ru.rrozhkov.easykin.family.gui;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.gui.PersonForm;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class FamilyGUIFactory implements IModuleGUIFactory {
    private final static IGUIFactory guiFactory = GUIFactory.create();
    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new FamilyTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, Object obj) {
        return new PersonForm(parent,(IPerson)obj);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
