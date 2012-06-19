package com.github.goncharov.impl;

import com.github.goncharov.HttpClient;
import com.github.goncharov.JsonMapper;
import com.github.goncharov.Px500;
import com.github.goncharov.entities.PhotoStream;
import com.github.goncharov.entities.UserProfile;
import com.github.goncharov.enums.Endpoint;
import com.github.goncharov.query.QueryBuilder;

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
    public void setJsonMapper(JsonMapper mapper) {
        synchronized (this.mapper) {
            this.mapper = mapper;
        }
    }

    @Override
    public UserProfile getUserProfile() {
        return new QueryBuilder(Endpoint.USERS).build(UserProfile.class, client, mapper);
    }

    @Override
    public UserProfile getUserProfileById(int id) {
        return null;
    }

    @Override
    public UserProfile getUserProfileByName(String username) {
        return null;
    }

    @Override
    public UserProfile getUserProfileByEmail(String email) {
        return null;
    }

    @Override
    public PhotoStream getPhotoStream() {
        return null;
    }


}
