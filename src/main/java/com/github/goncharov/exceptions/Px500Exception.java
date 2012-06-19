package com.github.goncharov.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 14:27
 */
public class Px500Exception extends RuntimeException {
    public Px500Exception() {
        super();
    }

    public Px500Exception(String message) {
        super(message);
    }

    public Px500Exception(String message, Throwable cause) {
        super(message, cause);
    }
}
