package ru.rrozhkov.easykin.work;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.easykin.work.gui.ActivityGUIFactory;
import ru.rrozhkov.easykin.work.service.impl.ActivityService;

import java.awt.Component;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory activityFactory = ActivityGUIFactory.instance();
    private static final ActivityService activityService = ActivityService.instance();
    private static final WorkFactory workFactory = WorkFactory.instance();

    public static Component createPanel(IGUIEditor parent) {
        return activityFactory.createTablePanel(parent, activityService.activities());
    }
    public static Component createEditor(IGUIEditor parent){
        IActivity activity = workFactory.newActivity();
        return activityFactory.createEditor(parent, activity);
    }
    public static Component createEditor(IGUIEditor parent, IActivity activity) {
        return activityFactory.createEditor(parent,activity);
    }
    public static Component createFilter(IGUIEditor parent){
        return activityFactory.createFilter(parent);
    }
}
