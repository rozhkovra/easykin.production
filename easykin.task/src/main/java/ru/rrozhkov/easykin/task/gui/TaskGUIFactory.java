package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.gui.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/15/2017.
 */
public class TaskGUIFactory implements IModuleGUIFactory {
    private final static IGUIFactory guiFactory = GUIFactory.create();
    public Component createTaskForm(IGUIEditor parent, ITask task){
        if(task!=null)
            return new TaskForm(parent,task);
        return new TaskForm(parent);
    }
    public Component createFilter(IGUIEditor parent){
        return new TaskFilter(parent);
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new TaskTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, Object obj) {
        return new TaskEditor(parent, (ITask)obj);
    }
}
