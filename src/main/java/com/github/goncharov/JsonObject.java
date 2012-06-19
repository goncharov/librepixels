package com.github.goncharov;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 11:25
 */
public interface JsonObject {

    boolean hasField(String key);

    Object getRaw(String key);

    <T> T getField(Class<T> clazz, String key);

    <T> Object getArrayField(Class<T> clazz, String key);

    Integer getInt(String key);

    String getString(String key);

    String[] getStringArray(String key);

    Double getDouble(String key);

    JsonObject getObject(String key);

    JsonObject[] getArray(String key);

    boolean getBoolean(String key);

}
