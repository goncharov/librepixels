package com.github.goncharov.enums;

import com.github.goncharov.EntityEnumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 06.06.12
 * Time: 13:59
 */
public enum Sex implements EntityEnumeration<Integer> {
    REFUSED("refused"), MALE("male"), FEMALE("female");

    private final String value;

    Sex(String status) {
        value = status;
    }

    public static Sex fromValue(int i) {
        System.out.println("sex " +i);
        return Sex.values()[i];
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public <T> T getRaw() {
        return (T) Integer.class.cast(ordinal());
    }
}
