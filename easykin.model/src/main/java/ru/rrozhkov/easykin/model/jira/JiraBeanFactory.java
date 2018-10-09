package ru.rrozhkov.easykin.model.jira;

import java.util.Date;

/**
 * Created by rrozhkov on 09.10.2018.
 */
public class JiraBeanFactory {
    public static class Holder {
        public static final JiraBeanFactory INSTANCE = new JiraBeanFactory();
    }

    public static JiraBeanFactory instance(){
        return Holder.INSTANCE;
    }

    private JiraBeanFactory() {
    }

    public JiraTask task(String key, String name, String status) {
        return new JiraTask(key, name, status);
    }

    public JiraWorkLog worklog(Date date, int time, String name, String desc) {
        return new JiraWorkLog(date, time, name, desc);
    }
}
