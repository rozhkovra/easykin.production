package ru.rrozhkov.easykin.jira.auth;

import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by rrozhkov on 24.09.2018.
 */
public class JiraAuthManager {
    private static final String jiraProperties = "jira.properties";
    private static Credentials credentials;

    public static Credentials credentials() {
        if (credentials == null) {
            Properties property=new Properties();
            try {
                URL iconUrl = JiraAuthManager.class.getResource("/"+jiraProperties);
                property.load(iconUrl.openStream());
                String user = property.getProperty("user");
                String pass = property.getProperty("pass");
                credentials = new UsernamePasswordCredentials(user, pass);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return credentials;
    }
}