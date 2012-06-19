package com.github.goncharov.enums;

import com.github.goncharov.EntityEnumeration;
import com.github.goncharov.QueryEnumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 06.06.12
 * Time: 14:02
 */
public enum Category implements QueryEnumeration, EntityEnumeration<Integer> {
    UNCATEGORIZED("Uncategorized"),
    CELEBRITIES("Celebrities"),
    FILM("Film"),
    JOURNALISM("Journalism");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    public static Category fromValue(int id) {
        try {
            return Category.values()[id];
        } catch (Exception e) {
            return null;
        }
    }

    public static Category fromValue(String title) {
        return Category.valueOf(title.toUpperCase());
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String toString() {
        return title;
    }

    public int toInteger() {
        return ordinal();
    }

    @Override
    public <T> T getRaw() {
        return (T) Integer.class.cast(ordinal());
    }
}
