package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/15/2017.
 */
public class TaskGUIFactory implements IModuleGUIFactory<ITask> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class TaskGUIFactoryHolder {
        public static final TaskGUIFactory INSTANCE = new TaskGUIFactory();
    }

    public static TaskGUIFactory instance(){
        return TaskGUIFactoryHolder.INSTANCE;
    }

    public Component createTaskForm(IGUIEditor parent, ITask task){
        return TaskForm.create(parent, task);
    }
    public Component createFilter(IGUIEditor parent){
        return TaskFilter.create(parent);
    }
    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new TaskTableModel(data));
    }
    public Component createEditor(IGUIEditor parent, ITask task) {
        return TaskEditor.create(parent, task);
    }

    public Component createView(IGUIEditor parent, ITask obj) {
        return guiFactory.panelEmpty();
    }
}
