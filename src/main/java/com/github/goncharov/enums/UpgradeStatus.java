package com.github.goncharov.enums;

import com.github.goncharov.EntityEnumeration;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 06.06.12
 * Time: 10:59
 */
public enum UpgradeStatus implements EntityEnumeration<Integer> {
    FREE("free"), PLUS("plus"), AWESOME("awesome");

    private final String value;

    UpgradeStatus(String status) {
        value = status;
    }

    public static UpgradeStatus fromValue(int i) {
        return UpgradeStatus.values()[i];
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
