package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.gui.*;
import ru.rrozhkov.lib.gui.style.IStyle;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/15/2017.
 */
public class TaskGUIFactory implements IGUIFactory {
    public JPanel createTaskForm(IGUIEditor parent, ITask task){
        if(task!=null)
            return new TaskForm(parent,task);
        return new TaskForm(parent);
    }
    public JPanel createFilter(IGUIEditor parent){
        return new TaskFilter(parent);
    }

    public JPanel createTablePanel(IGUIEditor parent, Collection data, IStyle style) {
        return new TablePanel(parent, new Table(data, style));
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        return new TaskEditor(parent, (ITask)obj);
    }
}
