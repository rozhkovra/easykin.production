package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.gui.TaskGUIFactory;
import ru.rrozhkov.easykin.task.impl.TaskBuilder;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverter;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final IModuleGUIFactory guiTaskFactory = TaskGUIFactory.instance();
    private static final TaskFactory taskFactory = TaskFactory.instance();
    private static final TaskBuilder taskBuilder = TaskBuilder.instance();
    private static final TaskConverterFactory taskConverterFactory = TaskConverterFactory.instance();
    private static final AuthManager authManager = AuthManager.instance();

    public static Component createPanel(IGUIEditor parent){
        return guiTaskFactory.createTablePanel(parent, tasks());
    }
    public static Component createEditor(IGUIEditor parent){
        ITask task = taskFactory.newTask();
        return guiTaskFactory.createEditor(parent, task);
    }
    public static Component createEditor(IGUIEditor parent, ITask task){
        return guiTaskFactory.createEditor(parent, task);
    }
    public static Component createFilter(IGUIEditor parent){
        return guiTaskFactory.createFilter(parent);
    }

    public static Collection tasks(){
        Collection collection;
        IPerson person = authManager.signedPerson();
        if(person!=null)
            collection = taskBuilder.build(person.getId());
        else
            collection = taskBuilder.build();
        return collection;
    }

    public static Collection payments(){
        return ((TaskConverter)taskConverterFactory.task()).payments(tasks());
    }
}
