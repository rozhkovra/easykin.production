package ru.rrozhkov.easykin.jira.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.rest.client.RestClient;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by rrozhkov on 17.09.2018.
 */
public class TaskBuilder {
    public Collection<JiraTask> tasks() {
        Collection<JiraTask> tasks = CollectionUtil.create();
        RestClient client = new RestClient();
        String result = null;
        try {
            result = client.send("https://jira.mvideo.ru/jira/rest/api/2/search?jql=assignee=lux_rozhkov%20AND%20issuetype=Bug");
            JSONObject myResponse = new JSONObject(result);
            JSONArray jsonarray = myResponse.getJSONArray("issues");
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String name = jsonobject.getString("key");
                JSONObject fields = jsonobject.getJSONObject("fields");
                JSONObject status = fields.getJSONObject("status");
                name += " " + fields.getString("summary");
                System.out.println(name+" "+status.getString("name"));
                tasks.add(new JiraTask(name, status.getString("name")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static void main(String[] args) {
        new TaskBuilder().tasks();
    }
}
