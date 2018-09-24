package ru.rrozhkov.easykin.jira;

import org.apache.http.auth.Credentials;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.jira.auth.JiraAuthManager;
import ru.rrozhkov.easykin.jira.gui.JiraGUIFactory;
import ru.rrozhkov.easykin.jira.impl.TaskBuilder;
import ru.rrozhkov.easykin.model.jira.JiraTask;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final IModuleGUIFactory guiJiraFactory = JiraGUIFactory.instance();
    private static final Credentials credentials = JiraAuthManager.credentials();
    private static final TaskBuilder taskBuilder = TaskBuilder.create(credentials);

    public static Component createPanel(IGUIEditor parent){
        return guiJiraFactory.createTablePanel(parent, tasks());
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

    public static Collection tasks(){
        return taskBuilder.tasks();
    }

}
