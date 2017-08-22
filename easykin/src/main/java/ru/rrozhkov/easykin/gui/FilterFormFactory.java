package ru.rrozhkov.easykin.gui;


import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.context.IContext;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class FilterFormFactory {

    public static JPanel getFilterFormPanel(IContext context, IGUIEditor parent) {
        String module = ((EasyKinContext)context).masterData().currentModule();
        if(ModuleManager.exist(module)) {
            return (JPanel)ModuleManager.invoke(module, "createFilter", parent);
        }
        return new JPanel();
    }
}
