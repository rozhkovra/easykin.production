package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.task.gui.style.impl.custom.CommentStyle;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/15/2017.
 */
public class GUIFactory {
    public static JPanel createTaskForm(IGUIEditor parent, ITask task){
        if(task!=null)
            return new TaskForm(parent,task);
        return new TaskForm(parent);
    }
    public static JPanel createTaskEditor(IGUIEditor parent, ITask task) {
        return new TaskEditor(parent, task);
    }
    public static JPanel createTaskCommentPanel(TaskEditor taskEditor, Collection collection){
        return new TablePanel(taskEditor, new Table(collection, new CommentStyle()));
    }
    public static JPanel createCommentForm(IGUIEditor parent, Object obj, int id){
        if(obj!=null && obj instanceof IComment)
            return new CommentForm(parent,(IComment)obj);
        return new CommentForm(parent, id);
    }
    public static JPanel createTaskFilter(IGUIEditor parent){
        return new TaskFilter(parent);
    }

}
