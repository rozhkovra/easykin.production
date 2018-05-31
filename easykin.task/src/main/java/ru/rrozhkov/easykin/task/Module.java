package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.gui.TaskGUIFactory;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverter;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.IFilterBean;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory taskFactory = new TaskGUIFactory();
    private static TaskBuilder taskBuilder = new TaskBuilder();
    public static Component createPanel(IGUIEditor parent){
        return taskFactory.createTablePanel(parent, tasks());
    }
    public static Component createEditor(IGUIEditor parent){
        return taskFactory.createEditor(parent, null);
    }
    public static Component createEditor(IGUIEditor parent, ITask task){
        return taskFactory.createEditor(parent, task);
    }
    public static Component createFilter(IGUIEditor parent){
        return taskFactory.createFilter(parent);
    }

    public static Collection tasks(){
        Collection collection;
        IPerson person = AuthManager.instance().signedPerson();
        if(person!=null)
            collection = tasks(person);
        else
            collection = taskBuilder.build();
        return collection;
    }
    public static Collection tasks(IPerson person){
        return taskBuilder.build(person.getId());
    }
    public static Collection tasks(IFilterBean bean){
        return taskBuilder.build((TaskFilterBean)bean);
    }
    public static Collection tasks(IPerson person, IFilter filter){
        return FilterUtil.filter(tasks(person), filter);
    }
    public static Collection payments(){
        return ((TaskConverter)TaskConverterFactory.task()).payments(tasks());
    }
}
