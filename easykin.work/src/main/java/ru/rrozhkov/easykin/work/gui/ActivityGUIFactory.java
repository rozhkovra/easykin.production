package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.lib.gui.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class ActivityGUIFactory implements IModuleGUIFactory {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new ActivityTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, Object obj) {
        return new ActivityForm(parent,(IActivity)obj);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
