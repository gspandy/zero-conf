package com.bytebeats.config.impl;

import com.bytebeats.config.ConfigObject;
import com.bytebeats.config.util.StringUtils;

import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-15 23:46
 */
public class SystemConfig extends ConfigObject {

    public boolean containsKey(String key) {
        return getString(key)!=null;
    }

    public String getString(String key) {
        return System.getProperty(key);
    }

    public String[] getStringArray(String key) {
        String value = getString(key);
        if (StringUtils.isNotEmpty(value)) {
            String[] arr = value.split(",");
            for (int i=0; i<arr.length; i++){
                arr[i] = arr[i].trim();
            }
            return arr;
        }
        return null;
    }

    public Integer getInteger(String key) {
        String value = getString(key);
        return Integer.parseInt(value);
    }

    public Long getLong(String key) {
        String value = getString(key);
        return Long.parseLong(value);
    }

    public Double getDouble(String key) {
        String value = getString(key);
        return Double.parseDouble(value);
    }

    public Boolean getBoolean(String key) {
        String value = getString(key);
        return Boolean.valueOf(value);
    }

}
