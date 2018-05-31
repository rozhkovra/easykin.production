package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.swing.SwingGuiFactory;

import javax.swing.*;

/**
 * Created by rrozhkov on 4/19/2018.
 */
public class GUIFactory {
    private final static IGUIFactory guiFactory = ru.rrozhkov.lib.gui.GUIFactory.create();
    public static JPanel createPanel(String module, IGUIEditor parent) {
        if (ModuleManager.exist(module)) {
            return (JPanel) ModuleManager.invoke(module, "createPanel", parent);
        }
        return guiFactory.panelEmpty();
    }

    public static JPanel createEditor(String module, IGUIEditor parent, Object obj) {
        if(ModuleManager.exist(module)) {
            if(obj!=null)
                return (JPanel)ModuleManager.invoke(module, "createEditor", parent, obj);
            else
                return (JPanel)ModuleManager.invoke(module, "createEditor", parent);
        }
        return guiFactory.panelEmpty();
    }

    public static JPanel createFilter(String module, IGUIEditor parent) {
        if(ModuleManager.exist(module)) {
            return (JPanel)ModuleManager.invoke(module, "createFilter", parent);
        }
        return guiFactory.panelEmpty();
    }
}
