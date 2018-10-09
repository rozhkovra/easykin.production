package ru.rrozhkov.easykin.model.jira;

/**
 * Created by rrozhkov on 17.09.2018.
 */
public class JiraTask {
    private String key;
    private String name;
    private String status;

    protected JiraTask(String key, String name, String status) {
        this.key = key;
        this.name = name;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
