package ru.rrozhkov.easykin.jira.impl;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.jira.impl.convert.JSONJiraTaskConverter;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.rest.client.RestClient;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by rrozhkov on 17.09.2018.
 */
public class TaskBuilder {
    public static final String ASSIGNEE_BUGS = "https://jira.mvideo.ru/jira/rest/api/2/search?jql=assignee=lux_rozhkov%20AND%20issuetype=Bug";
    public static final IConverter<JSONObject, JiraTask> jiraTaskConverter = new JSONJiraTaskConverter();

    public static TaskBuilder create(Credentials credentials){
        return new TaskBuilder(credentials);
    }

    private Credentials credentials;

    private TaskBuilder(Credentials credentials) {
        this.credentials = credentials;
    }

    public Collection<JiraTask> tasks() {
        Collection<JiraTask> tasks = CollectionUtil.create();
        try {
            String result = RestClient.instance().send(ASSIGNEE_BUGS, credentials);
            JSONObject myResponse = new JSONObject(result);
            JSONArray jsonarray = myResponse.getJSONArray("issues");
            for (Object obj : jsonarray) {
                JSONObject jsonobject = (JSONObject)obj;
                tasks.add(jiraTaskConverter.convert(jsonobject));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static void main(String[] args) {
        Credentials credentials = new UsernamePasswordCredentials("lux_rozhkov", "5AkynjQc");
        TaskBuilder.create(credentials).tasks();
    }
}
