package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
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
        return new ActivityForm(parent,activity);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
