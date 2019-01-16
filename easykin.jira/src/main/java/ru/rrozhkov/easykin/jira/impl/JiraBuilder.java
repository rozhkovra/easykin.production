package ru.rrozhkov.easykin.jira.impl;

import org.apache.http.auth.Credentials;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.jira.auth.JiraAuthManager;
import ru.rrozhkov.easykin.rest.client.RestClient;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by rrozhkov on 09.10.2018.
 */
public class JiraBuilder<T> {
    protected static final Credentials credentials = JiraAuthManager.credentials();

    protected IConverter<JSONObject, T> converter;
    private String url;

    protected JiraBuilder(String url, IConverter converter) {
        this.url = url;
        this.converter = converter;
    }

    public Collection<T> beans() {
        Collection<T> beans = CollectionUtil.create();
        try {
            String result = RestClient.instance().send(url, credentials);
            JSONObject myResponse = new JSONObject(result);
            JSONArray jsonarray = myResponse.getJSONArray("issues");
            for (Object obj : jsonarray) {
                JSONObject jsonobject = (JSONObject)obj;
                Object res = converter.convert(jsonobject);
                if (res instanceof Collection) {
                    beans.addAll((Collection)res);
                } else {
                    beans.add((T)res);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException jsone) {
            jsone.printStackTrace();
        }
        return beans;
    }
}
