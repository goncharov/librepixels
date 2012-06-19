package com.github.goncharov.impl;

import com.github.goncharov.Entity;
import com.github.goncharov.EntityEnumeration;
import com.github.goncharov.JsonMapper;
import com.github.goncharov.JsonObject;
import com.github.goncharov.entities.PhotoResponse;
import com.github.goncharov.entities.PhotoStream;
import com.github.goncharov.entities.UserProfile;
import com.github.goncharov.enums.*;
import com.github.goncharov.exceptions.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.bind.DatatypeConverter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 11:02
 */
public class JsonOrgMapper implements JsonMapper {

    private JsonObject parseJson(String source) throws JSONException {
        return new JsonOrgObject(new JSONObject(source));
    }


    private boolean isImplements(Class clazz, Class implement) {
        for (Class c : clazz.getInterfaces()) {
            if (c.equals(implement))
                return true;
        }
        return false;
    }

    private <T> T makeEnumeration(Class<T> clazz, Object object) {
        if (object == null)
            return null;
        if (clazz == Category.class) {
            return (T) Category.fromValue((Integer) object);
        } else if (clazz == Feature.class) {
            return (T) Feature.fromValue((String) object);
        } else if (clazz == Locale.class) {
            return (T) Locale.fromValue((String) object);
        } else if (clazz == Sex.class) {
            return (T) Sex.fromValue((Integer) object);
        } else if (clazz == UpgradeStatus.class) {
            return (T) UpgradeStatus.fromValue((Integer) object);
        }
        return null;
    }

    private <T> T makeObject(Class<T> clazz, JsonObject json) throws IllegalAccessException, InstantiationException {
        T instance = clazz.newInstance();

        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            if (json.hasField(f.getName())) {
                if (isImplements(f.getType(), Entity.class)) {
                    f.set(instance, makeObject(f.getType(), json.getObject(f.getName())));
                } else if (isImplements(f.getType(), EntityEnumeration.class)) {
                    f.set(instance, makeEnumeration(f.getType(), json.getRaw(f.getName())));
                } else if (f.getType().isArray()) {
                    if (isImplements(f.getType().getComponentType(), Entity.class)) {
                        JsonObject[] jArray = json.getArray(f.getName());
                        if (jArray != null) {
                            Object array = Array.newInstance(f.getType().getComponentType(), jArray.length);
                            for (int i = 0; i < jArray.length; i++) {
                                Array.set(array, i, makeObject(f.getType().getComponentType(), jArray[i]));
                            }
                            f.set(instance, array);
                        } else {
                            f.set(instance, null);
                        }
                    } else {
                        f.set(instance, json.getStringArray(f.getName()));
                    }
                } else if (f.getType().equals(Date.class)) {
                    String tmp = json.getField(String.class, f.getName());
                    if (tmp != null) {
                        f.set(instance, DatatypeConverter.parseDateTime(tmp).getTime());
                    }
                } else {
                    f.set(instance, json.getField(f.getType(), f.getName()));
                }
            }
        }
        return instance;
    }

    @Override
    public <T> T parseEntity(String source, Class<T> clazz) {
        try {
            if (UserProfile.class.equals(clazz)) {
                JsonObject json = parseJson(source).getObject("user");
                return (T) makeObject(UserProfile.class, json);
            } else if (PhotoStream.class.equals(clazz)) {
                return (T) makeObject(PhotoStream.class, parseJson(source));
            } else if (PhotoResponse.class.equals(clazz)) {
                return (T) makeObject(PhotoResponse.class, parseJson(source));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            throw new ParseException(e.getMessage(), e.getCause());
        }
        return null;
    }
}

