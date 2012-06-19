package com.github.goncharov;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 11:31
 */
public interface JsonMapper {
    <T> T parseEntity(String source, Class<T> clazz);
}
