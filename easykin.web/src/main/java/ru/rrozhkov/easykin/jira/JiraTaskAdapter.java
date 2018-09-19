package ru.rrozhkov.easykin.jira;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.jira.impl.TaskBuilder;
import ru.rrozhkov.easykin.model.jira.JiraTask;

import java.util.Collection;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class JiraTaskAdapter {
    private static final TaskBuilder taskBuilder = TaskBuilder.instance();

    public Collection<JiraTaskBean> tasks() {
        Collection<JiraTask> tasks = taskBuilder.tasks();
        Collection<JiraTaskBean> taskBeans = CollectionUtil.create();
        int i = 0;
        for (JiraTask task : tasks) {
            taskBeans.add(new JiraTaskBean(++i, task));
        }
        return taskBeans;
    }
}
