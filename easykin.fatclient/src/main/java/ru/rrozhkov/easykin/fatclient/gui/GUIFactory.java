package ru.rrozhkov.easykin.fatclient.gui;

import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;

import java.awt.*;

/**
 * Created by rrozhkov on 4/19/2018.
 */
public class GUIFactory {
    final private static IGUIFactory guiFactory = ru.rrozhkov.easykin.core.gui.GUIFactory.create();
    final private static ModuleManager moduleManager = ModuleManager.instance();

    public static Component createPanel(String module, IGUIEditor parent) {
        if (moduleManager.exist(module)) {
            return (Component) moduleManager.invoke(module, "createPanel", parent);
        }
        return guiFactory.panelEmpty();
    }

    public static Component createEditor(String module, IGUIEditor parent, Object obj) {
        if(moduleManager.exist(module)) {
            if(obj!=null)
                return (Component)moduleManager.invoke(module, "createEditor", parent, obj);
            else
                return (Component)moduleManager.invoke(module, "createEditor", parent);
        }
        return guiFactory.panelEmpty();
    }

    public static Component createFilter(String module, IGUIEditor parent) {
        if(moduleManager.exist(module)) {
            return (Component)moduleManager.invoke(module, "createFilter", parent);
        }
        return guiFactory.panelEmpty();
    }
}
