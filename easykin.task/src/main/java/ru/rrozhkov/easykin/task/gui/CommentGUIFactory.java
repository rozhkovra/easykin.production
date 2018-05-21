package ru.rrozhkov.easykin.task.gui;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.gui.style.impl.custom.CommentStyle;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;
import ru.rrozhkov.lib.gui.style.IStyle;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class CommentGUIFactory implements IGUIFactory {
    public JPanel createTablePanel(IGUIEditor parent, Collection collection, IStyle style){
        return new TablePanel(parent, new Table(collection, style));
    }
    public JPanel createEditor(IGUIEditor parent, Object obj, int id){
        if(obj!=null && obj instanceof IComment)
            return new CommentForm(parent,(IComment)obj);
        return new CommentForm(parent, id);
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        if(obj!=null)
            return new CommentForm(parent,(IComment)obj);
        return new CommentForm(parent, 0);
    }

    public JPanel createFilter(IGUIEditor parent) {
        return new JPanel();
    }
}
