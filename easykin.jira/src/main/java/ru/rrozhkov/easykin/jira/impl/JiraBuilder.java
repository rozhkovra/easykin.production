package ru.rrozhkov.easykin.jira.impl;

import org.apache.http.auth.Credentials;
import org.json.JSONArray;
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
    private IConverter<JSONObject, T> converter;
    private String url;
    private static final Credentials credentials = JiraAuthManager.credentials();

    public static JiraBuilder create(String url, IConverter converter){
        return new JiraBuilder(url, converter);
    }

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
                beans.add(converter.convert(jsonobject));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return beans;
    }
}
