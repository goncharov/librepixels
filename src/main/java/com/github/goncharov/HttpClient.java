package com.github.goncharov;

import com.github.goncharov.enums.HttpMethod;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 15:56
 */
public interface HttpClient {
    String request(HttpMethod method, String requestUrl, String requestContent);
}
