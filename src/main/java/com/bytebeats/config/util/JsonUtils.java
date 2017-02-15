package com.bytebeats.config.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Reader;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:27
 */
public class JsonUtils {
    private static final Gson GSON = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static <T> T fromJson(String json, Class<T> type) {
        return GSON.fromJson(json, type);
    }

    public static <T> T fromJson(Reader reader, Class<T> type) {
        return GSON.fromJson(reader, type);
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }
}
