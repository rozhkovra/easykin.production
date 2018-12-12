package ru.rrozhkov.easykin.jira.impl;

import ru.rrozhkov.easykin.jira.impl.convert.JSONJiraConverterFactory;
import ru.rrozhkov.easykin.model.jira.JiraTask;

import java.util.Collection;

/**
 * Created by rrozhkov on 17.09.2018.
 */
public class TaskBuilder extends JiraBuilder<JiraTask> {
    public static final String ASSIGNEE_BUGS = "https://jira.mvideo.ru/jira/rest/api/2/search?jql=assignee=currentuser()%20AND%20issuetype=Bug";
    private static class Holder {
        private static final TaskBuilder INSTANCE = new TaskBuilder();
    }

    protected static TaskBuilder instance(){
        return Holder.INSTANCE;
    }

    private TaskBuilder() {
        super(ASSIGNEE_BUGS, JSONJiraConverterFactory.instance().task());
    }

    public Collection<JiraTask> tasks() {
        return beans();
    }

    public static void main(String[] args) {
        TaskBuilder.instance().tasks();
    }
}
