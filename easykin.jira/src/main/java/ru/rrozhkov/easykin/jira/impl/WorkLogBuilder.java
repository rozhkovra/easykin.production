package ru.rrozhkov.easykin.jira.impl;

import org.apache.http.auth.Credentials;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.jira.auth.JiraAuthManager;
import ru.rrozhkov.easykin.jira.impl.convert.JSONJiraWorkLogConverter;
import ru.rrozhkov.easykin.model.jira.JiraWorkLog;
import ru.rrozhkov.easykin.rest.client.RestClient;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by rrozhkov on 19.09.2018.
 */
public class WorkLogBuilder {
    public static final String USER_WORKLOG = "https://jira.mvideo.ru/jira/rest/api/latest/search?jql=worklogDate%3E%272018-01-01%27%20AND%20worklogAuthor=%27lux_rozhkov%27&fields=worklog";
    public static final IConverter<JSONObject, Collection<JiraWorkLog>> jiraWorkLogConverter = new JSONJiraWorkLogConverter();

    public static WorkLogBuilder create(Credentials credentials){
        return new WorkLogBuilder(credentials);
    }

    private Credentials credentials;

    private WorkLogBuilder(Credentials credentials) {
        this.credentials = credentials;
    }

    public Collection<JiraWorkLog> worklogs() {
        Collection<JiraWorkLog> worlklogs = CollectionUtil.create();
        try {
            String result = RestClient.instance().send(USER_WORKLOG, credentials);
            JSONObject myResponse = new JSONObject(result);
            JSONArray jsonarray = myResponse.getJSONArray("issues");
            for (Object obj : jsonarray) {
                JSONObject jsonobject = (JSONObject)obj;
                worlklogs.addAll(jiraWorkLogConverter.convert(jsonobject));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return worlklogs;
    }


    public static void main(String[] args) {
        Credentials credentials = JiraAuthManager.credentials();
        WorkLogBuilder.create(credentials).worklogs();
    }
}
