package com.bytebeats.config.impl;

import com.bytebeats.config.ConfigObject;
import com.bytebeats.config.util.JsonUtils;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:23
 */
public class JsonConfig extends ConfigObject {
    private String json;

    public JsonConfig(String json) {
        this.json = json;
    }

    @Override
    public <T> T toJavaBean(Class<T> type) {
        return JsonUtils.fromJson(this.json, type);
    }
}
