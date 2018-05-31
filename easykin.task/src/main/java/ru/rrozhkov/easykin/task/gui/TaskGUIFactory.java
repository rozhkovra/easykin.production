package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/15/2017.
 */
public class TaskGUIFactory implements IModuleGUIFactory {
    public JPanel createTaskForm(IGUIEditor parent, ITask task){
        if(task!=null)
            return new TaskForm(parent,task);
        return new TaskForm(parent);
    }
    public JPanel createFilter(IGUIEditor parent){
        return new TaskFilter(parent);
    }

    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return new TablePanel(parent, new Table(new TaskTableModel(data)));
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        return new TaskEditor(parent, (ITask)obj);
    }
}
