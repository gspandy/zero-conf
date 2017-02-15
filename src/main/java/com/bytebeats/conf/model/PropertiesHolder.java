package com.bytebeats.conf.model;

import com.bytebeats.conf.util.StringUtils;

import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 16:56
 */
public class PropertiesHolder {
    private String filename;
    private Properties props;

    public PropertiesHolder(String filename, Properties props) {
        this.filename = filename;
        this.props = props;
    }

    public String getString(String key){
        return getPropertyValue(this.props, key);
    }

    public String[] getStringArray(String key){
        String value = getPropertyValue(this.props, key);
        if (StringUtils.isNotEmpty(value)) {
            String[] arr = value.split(",");
            for (int i=0; i<arr.length; i++){
                arr[i] = arr[i].trim();
            }
            return arr;
        }
        return null;
    }

    public Double getDouble(String key){
        return Double.parseDouble(getPropertyValue(this.props, key));
    }

    public Integer getInteger(String key){
        return Integer.parseInt(getPropertyValue(this.props, key));
    }

    public Boolean getBoolean(String key){
        return Boolean.valueOf(getPropertyValue(this.props, key));
    }

    private String getPropertyValue(Properties props, String key){
        if(props.containsKey(key)){
            return props.getProperty(key);
        }
        throw new IllegalArgumentException("not found key: "+key+" in "+filename);
    }
}
