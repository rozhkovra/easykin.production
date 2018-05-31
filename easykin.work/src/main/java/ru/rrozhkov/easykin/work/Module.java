package ru.rrozhkov.easykin.work;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.gui.ActivityGUIFactory;
import ru.rrozhkov.easykin.work.impl.ActivityBuilder;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IGUIFactory activityFactory = new ActivityGUIFactory();
    private static ActivityBuilder activityBuilder = new ActivityBuilder();
    public static JPanel createPanel(IGUIEditor parent) {
        return activityFactory.createTablePanel(parent, activities());
    }
    public static JPanel createEditor(IGUIEditor parent){
        return activityFactory.createEditor(parent, null);
    }
    public static JPanel createEditor(IGUIEditor parent, IActivity activity) {
        return activityFactory.createEditor(parent,activity);
    }
    public static JPanel createFilter(IGUIEditor parent){
        return activityFactory.createFilter(parent);
    }

    public static Collection activities(){
        return activityBuilder.build();
    }
}
