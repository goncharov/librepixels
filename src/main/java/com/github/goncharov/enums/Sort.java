package com.github.goncharov.enums;

import com.github.goncharov.QueryEnumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 13.06.12
 * Time: 14:44
 */
public enum Sort implements QueryEnumeration {
    CREATED_AT("created_at"),
    RATING("rating"),
    TIMES_VIEWED("times_viewed"),
    VOTES_COUNT("votes_count"),
    FAVORITES_COUNT("favorites_count"),
    COMMENTS_COUNT("comments_count"),
    TAKEN_AT("taken_at");

    private final String sortBy;

    private Sort(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public String getName() {
        return "sort";
    }

    @Override
    public String toString() {
        return sortBy;
    }
}
