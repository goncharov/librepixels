package com.github.goncharov;

import com.github.goncharov.impl.UserApi;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 16:19
 */
public interface Px500 {
    void setHttpClient(HttpClient client);

    HttpClient getHttpClient();

    void setJsonMapper(JsonMapper mapper);

    JsonMapper getJsonMapper();

    UserApi getUser();


}
