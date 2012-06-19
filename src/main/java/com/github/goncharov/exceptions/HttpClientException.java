package com.github.goncharov.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 14.06.12
 * Time: 10:30
 */
public class HttpClientException extends Px500Exception {
    public HttpClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
