package ru.rrozhkov.easykin.jira.impl.convert;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.model.jira.JiraWorkLog;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 19.09.2018.
 */
public class JSONJiraWorkLogConverter implements
        IConverter<JSONObject, Collection<JiraWorkLog>> {
    public JSONJiraWorkLogConverter() {
    }

    public Collection<JiraWorkLog> convert(JSONObject jsonobject) {
        Collection<JiraWorkLog> worklogsList = CollectionUtil.create();
        String key = jsonobject.getString("key");
        JSONObject fields = jsonobject.getJSONObject("fields");
        JSONObject worklog = fields.getJSONObject("worklog");
        JSONArray worklogs = worklog.getJSONArray("worklogs");
        for (Object obj : worklogs) {
            JSONObject worklogEntry = (JSONObject)obj;
            JSONObject author = worklogEntry.getJSONObject("author");
            if ("lux_rozhkov".equals(author.getString("name"))) {
                String comment = worklogEntry.getString("comment");
                Date date = DateUtil.parseJSON(worklogEntry.getString("started"));
                int time = worklogEntry.getInt("timeSpentSeconds") / 3600;
                System.out.println(key + "\t" + comment + "\t" + worklogEntry.getString("started") + "\t" + time);
                worklogsList.add(new JiraWorkLog(date, time, key, comment));
            }
        }
        return worklogsList;
    }
}
