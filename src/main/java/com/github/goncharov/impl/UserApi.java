package com.github.goncharov.impl;

import com.github.goncharov.Px500;
import com.github.goncharov.entities.UserProfile;
import com.github.goncharov.enums.Endpoint;
import com.github.goncharov.query.QueryBuilder;

import static com.github.goncharov.query.QueryBuilder.Contants.*;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 20.06.12
 * Time: 13:32
 */
public class UserApi {
    private QueryBuilder builder;
    private Px500 px;

    public UserApi(Px500 px) {
        this.px = px;
    }

    public UserApi byId(int id) {
        setEndpoint(Endpoint.USERS_SHOW);
        builder.withParam(USER_ID, Integer.toString(id));
        return this;
    }

    public UserApi byName(String name) {
        setEndpoint(Endpoint.USERS_SHOW);
        builder.withParam(USERNAME, name);
        return this;
    }

    public UserApi byEmail(String email) {
        setEndpoint(Endpoint.USERS_SHOW);
        builder.withParam(EMAIL, email);
        return this;
    }

    public UserProfile get() {
        if (builder == null) {
            setEndpoint(Endpoint.USERS);
        }
        return builder.build(UserProfile.class, px.getHttpClient(), px.getJsonMapper());
    }

    private void setEndpoint(Endpoint e) {
        if (builder == null) {
            builder = new QueryBuilder(e);
        }
    }
}
