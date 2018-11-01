package ru.rrozhkov.easykin.jira.impl.convert;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.jira.auth.JiraAuthManager;
import ru.rrozhkov.easykin.model.jira.JiraBeanFactory;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.model.jira.JiraWorkLog;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 05.10.2018.
 */
public class JSONJiraConverterFactory {
    private static final Credentials credentials = JiraAuthManager.credentials();
    private static final JiraBeanFactory jiraBeanFactory = JiraBeanFactory.instance();
    public static class Holder {
        public static final JSONJiraConverterFactory INSTANCE = new JSONJiraConverterFactory();
    }

    public static JSONJiraConverterFactory instance(){
        return Holder.INSTANCE;
    }

    public IConverter task() {
        return new IConverter<JSONObject, JiraTask>() {
            public JiraTask convert(JSONObject jsonobject) {
                JSONObject fields = jsonobject.getJSONObject("fields");
                JSONObject status = fields.getJSONObject("status");
                String key = jsonobject.getString("key");
                String name = fields.getString("summary");
                String statusName = status.getString("name");
                return jiraBeanFactory.task(key, name, statusName);
            }
        };
    }
    public IConverter worklog(){
        return new IConverter<JSONObject, Collection<JiraWorkLog>>() {
            public Collection<JiraWorkLog> convert(JSONObject jsonobject) {
                Collection<JiraWorkLog> worklogsList = CollectionUtil.create();
                String key = jsonobject.getString("key");
                JSONObject fields = jsonobject.getJSONObject("fields");
                JSONObject worklog = fields.getJSONObject("worklog");
                JSONArray worklogs = worklog.getJSONArray("worklogs");
                for (Object obj : worklogs) {
                    JSONObject worklogEntry = (JSONObject) obj;
                    JSONObject author = worklogEntry.getJSONObject("author");
                    String username = ((UsernamePasswordCredentials) credentials).getUserName();
                    if (username.equals(author.getString("name"))) {
                        String comment = worklogEntry.getString("comment");
                        Date date = DateUtil.parseJSON(worklogEntry.getString("started"));
                        int time = worklogEntry.getInt("timeSpentSeconds") / 3600;
                        System.out.println(key + "\t" + comment + "\t" + worklogEntry.getString("started") + "\t" + time);
                        worklogsList.add(jiraBeanFactory.worklog(date, time, key, comment));
                    }
                }
                return worklogsList;
            }
        };
    }
}
