package com.github.goncharov.query;

import com.github.goncharov.HttpClient;
import com.github.goncharov.JsonMapper;
import com.github.goncharov.QueryEnumeration;
import com.github.goncharov.enums.Endpoint;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 13:26
 */
public class QueryBuilder {
    public static final String API_BASE_URL = "https://api.500px.com/v1";

    private final Endpoint endpoint;
    private final Object[] args;
    private String params;

    public QueryBuilder(Endpoint endpoint, Object... args) {
        this.endpoint = endpoint;
        this.args = args;
    }

    public QueryBuilder withParam(QueryEnumeration param) {
        withParam(param.getName() + "=" + param.toString());
        return this;
    }

    public QueryBuilder withParam(String paramKey, String paramValue) {
        withParam(paramKey + "=" + paramValue);
        return this;
    }

    private void withParam(String param) {
        if (params != null) {
            params += "&" + param;
        } else {
            params = param;
        }
    }
    private String getUrl() {
        return API_BASE_URL + String.format(endpoint.getPath(), args) + "?" + params;
    }

    public <T> T build(Class<T> clazz, HttpClient client, JsonMapper mapper) {
        String response = client.request(endpoint.getMethod(),
                getUrl(), null);
        return mapper.parseEntity(response, clazz);
    }

    @Override
    public String toString() {
        return "QueryBuilder{" +
                "endpoint=" + endpoint +
                ", args=" + (args == null ? null : Arrays.asList(args)) +
                ", params='" + params + '\'' +
                '}';
    }
}
