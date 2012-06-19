package com.github.goncharov.impl;

import com.github.goncharov.HttpClient;
import com.github.goncharov.enums.HttpMethod;
import com.github.goncharov.exceptions.AuthException;
import com.github.goncharov.exceptions.HttpClientException;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.exception.OAuthException;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: Goncharov
 * Date: 02.06.12
 * Time: 23:08
 */
public class SignpostHttpClient implements HttpClient {

    private final OAuthConsumer consumer;

    public SignpostHttpClient(OAuthConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public String request(HttpMethod method, String requestUrl, String requestContent) {
        try {
            URL url;
            if (consumer.getToken() != null) {
                url = new URL(requestUrl);
            } else {
                url = new URL(requestUrl + "&consumer_key=" + consumer.getConsumerKey());
            }

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod(method.name());
            if (consumer.getToken() != null) {
                consumer.sign(connection);
            }
            if (requestContent != null) {
                connection.setDoOutput(true);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
                try {
                    writer.write(requestContent);
                } finally {
                    writer.close();
                }
            }
            StringBuilder result = new StringBuilder();

            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(), "UTF-8"), 1024);
                try {
                    char[] buffer = new char[1024];
                    int readed;
                    while ((readed = reader.read(buffer)) != -1) {
                        result.append(buffer, 0, readed);
                    }
                } finally {
                    reader.close();
                }
            } catch (IOException e) {
                if (connection.getResponseCode() == 401) {
                    throw new AuthException(e.getMessage(), e.getCause());
                } else {
                    throw new HttpClientException(e.getMessage(), e.getCause());
                }
            }
            return result.toString();
        } catch (IOException e) {
            throw new HttpClientException(e.getMessage(), e.getCause());
        } catch (OAuthException e) {
            throw new AuthException(e.getMessage(), e.getCause());
        }

    }
}
