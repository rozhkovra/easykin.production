package ru.rrozhkov.easykin.jira.gui;

import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.model.task.ITask;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/15/2017.
 */
public class JiraGUIFactory implements IModuleGUIFactory<ITask> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class Holder {
        public static final JiraGUIFactory INSTANCE = new JiraGUIFactory();
    }

    public static JiraGUIFactory instance(){
        return Holder.INSTANCE;
    }

    public Component createFilter(IGUIEditor parent){
        return guiFactory.panelEmpty();
    }
    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new JiraTableModel(data));
    }
    public Component createEditor(IGUIEditor parent, ITask task) {
        return guiFactory.panelEmpty();
    }

    public Component createView(IGUIEditor parent, ITask obj) {
        return guiFactory.panelEmpty();
    }
}
