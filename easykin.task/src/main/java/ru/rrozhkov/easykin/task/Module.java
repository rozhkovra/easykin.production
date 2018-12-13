package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.task.gui.TaskGUIFactory;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverter;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.service.impl.TaskService;
import ru.rrozhkov.easykin.task.service.impl.TaskServiceFactory;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final IModuleGUIFactory guiTaskFactory = TaskGUIFactory.instance();
    private static final TaskFactory taskFactory = TaskFactory.instance();
    private static final IEntityConverter taskConverter = TaskConverterFactory.instance().task();
    private static final TaskService taskService = TaskServiceFactory.instance().task();
    private static final AuthManager authManager = AuthManager.instance();

    public static Component createPanel(IGUIEditor parent){
        return guiTaskFactory.createTablePanel(parent, taskService.tasks(authManager.signedPerson()));
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

    public static Collection payments(){
        return ((TaskConverter)taskConverter).payments(taskService.tasks(authManager.signedPerson()));
    }
}
