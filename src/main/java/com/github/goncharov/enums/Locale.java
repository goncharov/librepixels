package com.github.goncharov.enums;

import com.github.goncharov.EntityEnumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 06.06.12
 * Time: 13:46
 */
public enum Locale implements EntityEnumeration<String> {
    EN("en"), RU("ru"), DE("de"), ES("es"), BR("br");

    private final String value;

    Locale(String locale) {
        this.value = locale;
    }

    public static Locale fromValue(String locale) {
        return Locale.valueOf(locale.toUpperCase());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public <T> T getRaw() {
        return (T) value;
    }
}
