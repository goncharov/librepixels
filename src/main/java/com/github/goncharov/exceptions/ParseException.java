package com.github.goncharov.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 17:24
 */
public class ParseException extends Px500Exception {

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
