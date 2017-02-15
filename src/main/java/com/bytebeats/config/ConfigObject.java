package com.bytebeats.config;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:23
 */
public class ConfigObject implements Config {

    public boolean containsKey(String key) {
        return false;
    }

    public String getString(String key) {
        return null;
    }

    public String[] getStringArray(String key) {
        return new String[0];
    }

    public Integer getInteger(String key) {
        return null;
    }

    public Long getLong(String key) {
        return null;
    }

    public Double getDouble(String key) {
        return null;
    }

    public Boolean getBoolean(String key) {
        return null;
    }

    public <T> T toJavaBean(Class<T> type) {
        return null;
    }
}
