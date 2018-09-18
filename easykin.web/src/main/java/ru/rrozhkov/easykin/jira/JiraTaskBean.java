package ru.rrozhkov.easykin.jira;

import ru.rrozhkov.easykin.model.jira.JiraTask;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class JiraTaskBean {
    private int num;
    private JiraTask task;

    public JiraTaskBean(int num, JiraTask task) {
        this.num = num;
        this.task = task;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public JiraTask getTask() {
        return task;
    }

    public void setTask(JiraTask task) {
        this.task = task;
    }
}
