package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class ActivityGUIFactory implements IModuleGUIFactory<IActivity> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class ActivityGUIFactoryHolder {
        public static final ActivityGUIFactory INSTANCE = new ActivityGUIFactory();
    }

    public static ActivityGUIFactory instance(){
        return ActivityGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new ActivityTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, IActivity activity) {
        return ActivityForm.create(parent, activity);
    }

    public Component createView(IGUIEditor parent, IActivity obj) {
        return guiFactory.panelEmpty();
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
