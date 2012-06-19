package com.github.goncharov.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 14.06.12
 * Time: 10:26
 */
public class AuthException extends Px500Exception {
    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}
