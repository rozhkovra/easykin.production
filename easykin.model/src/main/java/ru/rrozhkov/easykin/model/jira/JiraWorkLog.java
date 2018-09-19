package ru.rrozhkov.easykin.model.jira;

import java.util.Date;

/**
 * Created by rrozhkov on 17.09.2018.
 */
public class JiraWorkLog {
    protected Date date;
    protected int time;
    protected String name;
    protected String desc;

    public JiraWorkLog(Date date, int time, String name, String desc) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
