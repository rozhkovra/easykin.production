package ru.rrozhkov.easykin.jira.impl.convert;

import org.json.JSONObject;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.model.jira.JiraTask;

/**
 * Created by rrozhkov on 19.09.2018.
 */
public class JSONJiraTaskConverter implements
        IConverter<JSONObject, JiraTask> {
    protected JSONJiraTaskConverter() {
    }

    public JiraTask convert(JSONObject jsonobject) {
        JSONObject fields = jsonobject.getJSONObject("fields");
        JSONObject status = fields.getJSONObject("status");
        String key = jsonobject.getString("key");
        String name = fields.getString("summary");
        String statusName = status.getString("name");
        return new JiraTask(key, name, statusName);
    }
}
