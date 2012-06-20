package com.github.goncharov.exceptions;

import com.github.goncharov.enums.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 14:25
 */
public class IllegalQueryParameter extends Px500Exception {
    public IllegalQueryParameter() {
        super();
    }

    public IllegalQueryParameter(String param, Endpoint endpoint) {
        super("Parameter \"" + param + "\" not allowed for " + endpoint.getPath() + " queries");
    }
}
