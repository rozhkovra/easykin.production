package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class FilterFormFactory {

    public static JPanel getFilterFormPanel(MasterDataContext context, IGUIEditor parent) {
        String module = context.currentModule();
        if(ModuleManager.exist(module)) {
            return (JPanel)ModuleManager.invoke(module, "createFilter", parent);
        }
        return new JPanel();
    }
}
