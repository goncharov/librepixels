package com.github.goncharov.impl;

import com.github.goncharov.HttpClient;
import com.github.goncharov.JsonMapper;
import com.github.goncharov.Px500;

/**
 * Created by IntelliJ IDEA.
 * User: Goncharov
 * Date: 02.06.12
 * Time: 15:18
 */
public class Px500Impl implements Px500 {
    private HttpClient client;
    private JsonMapper mapper;

    public Px500Impl(HttpClient client, JsonMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    @Override
    public void setHttpClient(HttpClient client) {
        synchronized (this.client) {
            this.client = client;
        }
    }

    @Override
    public HttpClient getHttpClient() {
        synchronized (client) {
            return client;
        }
    }

    @Override
    public void setJsonMapper(JsonMapper mapper) {
        synchronized (this.mapper) {
            this.mapper = mapper;
        }
    }

    @Override
    public JsonMapper getJsonMapper() {
        synchronized (mapper) {
            return mapper;
        }
    }

    @Override
    public UserApi getUser() {
        return new UserApi(this);
    }


}
