package ru.rrozhkov.easykin.task.gui.comment;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class CommentGUIFactory implements IModuleGUIFactory<IComment> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class CommentGUIFactoryHolder {
        public static final CommentGUIFactory INSTANCE = new CommentGUIFactory();
    }

    public static CommentGUIFactory instance(){
        return CommentGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection collection){
        return guiFactory.tablePanel(parent, new CommentTableModel(collection));
    }

    public Component createEditor(IGUIEditor parent, IComment comment) {
        return new CommentForm(parent,comment);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
