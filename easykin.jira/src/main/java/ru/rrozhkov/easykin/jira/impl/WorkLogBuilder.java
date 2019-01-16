package ru.rrozhkov.easykin.jira.impl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.jira.impl.convert.JSONJiraConverterFactory;
import ru.rrozhkov.easykin.model.jira.JiraWorkLog;
import ru.rrozhkov.easykin.rest.client.RestClient;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by rrozhkov on 19.09.2018.
 */
public class WorkLogBuilder extends JiraBuilder<JiraWorkLog> {
    public static final String USER_WORKLOG_ISSUES = "https://jira.mvideo.ru/jira/rest/api/latest/search?jql=worklogDate%3E%272019-01-01%27%20AND%20worklogAuthor=%27lux_rozhkov%27&fields=worklog,summary";
    private static final String WORKLOGS_FOR_ISSUE = "https://jira.mvideo.ru/jira/rest/api/2/issue/FOBOKEY/worklog";

    private static class Holder {
        private static final WorkLogBuilder INSTANCE = new WorkLogBuilder();
    }

    protected static WorkLogBuilder instance(){
        return Holder.INSTANCE;
    }

    private WorkLogBuilder() {
        super(USER_WORKLOG_ISSUES, JSONJiraConverterFactory.instance().worklog());
    }

    public Collection<JiraWorkLog> worklogs() {
        return beans();
    }

    @Override
    public Collection<JiraWorkLog> beans() {
        Collection<JiraWorkLog> beans = CollectionUtil.create();
        try {
            String result = RestClient.instance().send(USER_WORKLOG_ISSUES, credentials);
            JSONObject myResponse = new JSONObject(result);
            JSONArray jsonarray = myResponse.getJSONArray("issues");
            for (Object obj : jsonarray) {
                JSONObject jsonobject = (JSONObject)obj;
                String key = jsonobject.getString("key");
                JSONObject fields = jsonobject.getJSONObject("fields");
                String url = WORKLOGS_FOR_ISSUE.replace("FOBOKEY", key);
                String workLogResult = RestClient.instance().send(url, credentials);
                JSONObject workLogJSONObject = new JSONObject(workLogResult);
                workLogJSONObject.put("key", key);
                workLogJSONObject.put("summary", fields.getString("summary"));
                Object res = converter.convert(workLogJSONObject);
                if (res instanceof Collection) {
                    beans.addAll((Collection)res);
                } else {
                    beans.add((JiraWorkLog)res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        return beans;
    }

    public static void main(String[] args) {
        WorkLogBuilder.instance().worklogs();
    }
}
