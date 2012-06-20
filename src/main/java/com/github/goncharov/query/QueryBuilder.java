package com.github.goncharov.query;

import com.github.goncharov.HttpClient;
import com.github.goncharov.JsonMapper;
import com.github.goncharov.enums.Endpoint;
import com.github.goncharov.exceptions.IllegalQueryParameter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 13:26
 */
public class QueryBuilder {

    public static class Contants {
        public static final String API_BASE_URL = "https://api.500px.com/v1";
        public static final String ONLY = "only";
        public static final String EXCLUDE = "exclude";
        public static final String EMAIL = "email";
        public static final String USERNAME = "username";
        public static final String USER_ID = "user_id";
        public static final String FEATURE = "feature";
        public static final String SORT = "sort";
    }


    private Endpoint endpoint;
    private Object[] args;
    private List<QueryStatement> raw;
    private String params;

    /*public QueryBuilder() {
    }*/

    public QueryBuilder(Endpoint endpoint, Object... args) {
        this.endpoint = endpoint;
        this.args = args;
    }

    /*public QueryBuilder setEndpoint(Endpoint endpoint, Object... args) {
        this.endpoint = endpoint;
        this.args = args;
        return this;
    }*/

    public <T> T build(Class<T> clazz, HttpClient client, JsonMapper mapper) {
        String response = client.request(endpoint.getMethod(),
                url(), null);
        return mapper.parseEntity(response, clazz);
    }

    public QueryStatement getStatement(String key) {
        for (QueryStatement s : raw) {
            if (s.getKey().equals(key))
                return s;
        }
        return null;
    }

    private String url() {
        StringBuilder result = new StringBuilder();
        result.append(Contants.API_BASE_URL).append(endpoint.getPath());
        if (raw.size() > 0) {
            result.append('?');
            for (QueryStatement statement : raw) {
                result.append(statement.toString());
            }
        }
        return result.toString();
    }

    public void withParam(String key, String value) {
        if (endpoint.isParamAllowed(key)) {
            QueryStatement tmp = getStatement(key);
            if (tmp == null) {
                raw.add(new QueryStatement(key, value));
            } else {
                tmp.setValue(value);
            }
        } else {
            throw new IllegalQueryParameter(key, endpoint);
        }
    }

    private class QueryStatement {
        private String key;
        private String value;

        public QueryStatement(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public QueryStatement(String key, int value) {
            this.key = key;
            this.value = Integer.toString(value);
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = Integer.toString(value);
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
