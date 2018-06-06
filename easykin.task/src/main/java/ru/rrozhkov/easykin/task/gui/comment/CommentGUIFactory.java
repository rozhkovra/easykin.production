package ru.rrozhkov.easykin.task.gui.comment;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class CommentGUIFactory implements IModuleGUIFactory {
    private final static IGUIFactory guiFactory = GUIFactory.create();
    public Component createTablePanel(IGUIEditor parent, Collection collection){
        return guiFactory.tablePanel(parent, new CommentTableModel(collection));
    }
    public Component createEditor(IGUIEditor parent, Object obj, int id){
        if(obj!=null && obj instanceof IComment)
            return new CommentForm(parent,(IComment)obj);
        return new CommentForm(parent, id);
    }

    public Component createEditor(IGUIEditor parent, Object obj) {
        if(obj!=null)
            return new CommentForm(parent,(IComment)obj);
        return new CommentForm(parent, 0);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
