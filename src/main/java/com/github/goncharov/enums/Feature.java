package com.github.goncharov.enums;

import com.github.goncharov.EntityEnumeration;
import com.github.goncharov.QueryEnumeration;
import com.github.goncharov.query.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 13:39
 */
public enum Feature implements QueryEnumeration, EntityEnumeration<String> {
    POPULAR("popular"),
    UPCOMING("upcoming"),
    EDITORS("editors"),
    FRESH_TODAY("fresh_today"),
    FRESH_YESTERDAY("fresh_yesterday"),
    FRESH_WEEK("fresh_week"),
    USER("user"),
    USER_FRIENDS("user_friends"),
    USER_FAVORITES("user_favorites");

    private final String feature;

    Feature(String feature) {
        this.feature = feature;
    }

    public static Feature fromValue(String value) {
        return valueOf(value.toUpperCase());
    }

    @Override
    public String getName() {
        return Query.FEATURE;
    }

    @Override
    public String toString() {
        return feature;
    }

    @Override
    public <T> T getRaw() {
        return (T) feature;
    }
}
