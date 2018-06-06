package ru.rrozhkov.easykin.auto.gui.auto;

import ru.rrozhkov.easykin.auto.gui.auto.service.AutoServiceForm;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class ServiceGUIFactory implements IModuleGUIFactory {
    private final static IGUIFactory guiFactory = GUIFactory.create();
    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new AutoTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, Object obj) {
        return new AutoServiceForm(parent,(IService)obj);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
