package ru.rrozhkov.easykin.jira;

import ru.rrozhkov.easykin.model.jira.JiraWorkLog;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class JiraWorkLogBean {
    private int num;
    private JiraWorkLog workLog;
    private String dateClass;

    public JiraWorkLogBean(int num, JiraWorkLog workLog, String dateClass) {
        this.num = num;
        this.workLog = workLog;
        this.dateClass = dateClass;
    }

    public int getNum() {
        return num;
    }

    public JiraWorkLog getWorkLog() {
        return workLog;
    }

    public String getDateClass() {
        return dateClass;
    }
}
