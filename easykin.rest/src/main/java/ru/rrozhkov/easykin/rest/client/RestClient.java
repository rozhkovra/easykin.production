package ru.rrozhkov.easykin.rest.client;


import org.apache.http.*;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class RestClient {

    public String send(String url)  throws IOException {
        HttpRequestBase req = new HttpGet(url);
        Credentials creds = new UsernamePasswordCredentials("lux_rozhkov", "5AkynjQc");
        req.addHeader(BasicScheme.authenticate(creds, "utf-8", false));
        HttpClient httpClient = HttpClientBuilder.create().build();
        req.addHeader("Accept", "application/json");


        HttpResponse resp = httpClient.execute(req);
        HttpEntity ent = resp.getEntity();
        StringBuilder result = new StringBuilder();

        if (ent != null) {
            String encoding = null;
            if (ent.getContentEncoding() != null) {
                encoding = ent.getContentEncoding().getValue();
            }

            if (encoding == null) {
                Header contentTypeHeader = resp.getFirstHeader("Content-Type");
                HeaderElement[] contentTypeElements = contentTypeHeader.getElements();
                for (HeaderElement he : contentTypeElements) {
                    NameValuePair nvp = he.getParameterByName("charset");
                    if (nvp != null) {
                        encoding = nvp.getValue();
                    }
                }
            }

            InputStreamReader isr =  encoding != null ?
                    new InputStreamReader(ent.getContent(), encoding) :
                    new InputStreamReader(ent.getContent());
            BufferedReader br = new BufferedReader(isr);
            String line = "";

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            isr.close();
            br.close();
        }
        return result.toString();
    }
}
