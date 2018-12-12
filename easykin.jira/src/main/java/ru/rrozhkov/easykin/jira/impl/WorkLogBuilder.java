package ru.rrozhkov.easykin.jira.impl;

import ru.rrozhkov.easykin.jira.impl.convert.JSONJiraConverterFactory;
import ru.rrozhkov.easykin.model.jira.JiraWorkLog;

import java.util.Collection;

/**
 * Created by rrozhkov on 19.09.2018.
 */
public class WorkLogBuilder extends JiraBuilder<JiraWorkLog> {
    public static final String USER_WORKLOG = "https://jira.mvideo.ru/jira/rest/api/latest/search?jql=worklogDate%3E%272018-01-01%27%20AND%20worklogAuthor=%27lux_rozhkov%27&fields=worklog";

    private static class Holder {
        private static final WorkLogBuilder INSTANCE = new WorkLogBuilder();
    }

    protected static WorkLogBuilder instance(){
        return Holder.INSTANCE;
    }

    private WorkLogBuilder() {
        super(USER_WORKLOG, JSONJiraConverterFactory.instance().worklog());
    }

    public Collection<JiraWorkLog> worklogs() {
        return beans();
    }

    public static void main(String[] args) {
        WorkLogBuilder.instance().worklogs();
    }
}
