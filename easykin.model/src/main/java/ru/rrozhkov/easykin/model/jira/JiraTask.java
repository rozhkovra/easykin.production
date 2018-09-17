package ru.rrozhkov.easykin.model.jira;

/**
 * Created by rrozhkov on 17.09.2018.
 */
public class JiraTask {
    private String name;
    private String status;

    public JiraTask(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}
