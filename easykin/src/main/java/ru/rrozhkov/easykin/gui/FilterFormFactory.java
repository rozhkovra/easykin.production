package ru.rrozhkov.easykin.gui;


import ru.rrozhkov.easykin.context.EasyKinContext;
import ru.rrozhkov.easykin.context.IContext;
import ru.rrozhkov.easykin.module.Module;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

/**
 * Created by rrozhkov on 3/21/2017.
 */
public class FilterFormFactory {

    public static JPanel getFilterFormPanel(IContext context, IGUIEditor parent) {
        ICategory category = ((EasyKinContext)context).masterData().currentCategory();
        if(category.getId()==1
            || category.getId()==8
            || category.getId()==9){
            if(ModuleManager.exist(Module.TASK)) {
                return (JPanel)ModuleManager.invoke(Module.TASK, "createFilter", parent);
            }
        }
        return new JPanel();
    }
}
