package ru.rrozhkov.easykin.jira;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.jira.gui.JiraGUIFactory;
import ru.rrozhkov.easykin.jira.impl.JiraBuilderFactory;
import ru.rrozhkov.easykin.jira.impl.TaskBuilder;
import ru.rrozhkov.easykin.model.jira.JiraTask;

import java.awt.Component;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final IModuleGUIFactory guiJiraFactory = JiraGUIFactory.instance();
    private static final TaskBuilder taskBuilder = JiraBuilderFactory.instance().task();

    public static Component createPanel(IGUIEditor parent){
        return guiJiraFactory.createTablePanel(parent, taskBuilder.tasks());
    }
    public static Component createEditor(IGUIEditor parent){
        return guiJiraFactory.createEditor(parent, null);
    }
    public static Component createEditor(IGUIEditor parent, JiraTask task){
        return guiJiraFactory.createEditor(parent, task);
    }
    public static Component createFilter(IGUIEditor parent){
        return guiJiraFactory.createFilter(parent);
    }
}
