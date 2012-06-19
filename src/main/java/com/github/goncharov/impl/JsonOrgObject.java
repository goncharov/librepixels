package com.github.goncharov.impl;

import com.github.goncharov.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * Created with IntelliJ IDEA.
 * User: Goncharov
 * Date: 04.06.12
 * Time: 11:05
 */
public class JsonOrgObject implements JsonObject {
    private final JSONObject source;

    public JsonOrgObject(JSONObject source) {
        this.source = source;
    }

    @Override
    public boolean hasField(String key) {
        return source.has(key);
    }

    @Override
    public Object getRaw(String key) {
        try {
            Object tmp = source.get(key);
            if (tmp.getClass() != JSONObject.NULL.getClass()) {
                return tmp;
            } else {
                return null;
            }
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public <T> T getField(Class<T> clazz, String key) {
        try {
            Object tmp = source.get(key);
            if (!tmp.getClass().equals(JSONObject.NULL.getClass()))
                return (T) tmp;
        } catch (JSONException e) {
            return null;
        }
        return null;
    }

    @Override
    public <T> Object getArrayField(Class<T> clazz, String key) {
        try {
            JSONArray jsonArray = source.getJSONArray(key);
            if (jsonArray.length() == 0)
                return null;
            Object array = Array.newInstance(clazz, jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                if (!jsonArray.isNull(i)) {
                    JsonObject tmp = new JsonOrgObject(jsonArray.getJSONObject(i));
                    Array.set(array, i, tmp);
                } else {
                    Array.set(array, i, null);
                }
            }
            return array;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public Integer getInt(String key) {
        try {
            return source.getInt(key);
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public String getString(String key) {
        try {
            return source.getString(key);
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public Double getDouble(String key) {
        try {
            return source.getDouble(key);
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public JsonObject getObject(String key) {
        try {
            return new JsonOrgObject(source.getJSONObject(key));
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public JsonObject[] getArray(String key) {
        try {
            JSONArray array = source.getJSONArray(key);
            JsonOrgObject[] result = new JsonOrgObject[array.length()];
            for (int i = 0; i < array.length(); i++) {
                result[i] = new JsonOrgObject(array.getJSONObject(i));
            }
            return result;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public String[] getStringArray(String key) {
        try {
            JSONArray array = source.getJSONArray(key);
            String[] sArray = new String[array.length()];
            for (int i = 0; i < array.length(); i++) {
                sArray[i] = array.getString(i);
            }
            return sArray;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public boolean getBoolean(String key) {
        try {
            return source.getBoolean(key);
        } catch (JSONException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return source.toString();
    }

}
