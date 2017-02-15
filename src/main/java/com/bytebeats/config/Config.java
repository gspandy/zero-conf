package com.bytebeats.config;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-15 23:20
 */
public interface Config {

    boolean containsKey(String key);

    String getString(String key);

    String[] getStringArray(String key);

    Integer getInteger(String key);

    Long getLong(String key);

    Double getDouble(String key);

    Boolean getBoolean(String key);

    <T> T toJavaBean(Class<T> type);
}
