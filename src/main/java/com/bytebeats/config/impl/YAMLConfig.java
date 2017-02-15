package com.bytebeats.config.impl;

import com.bytebeats.config.ConfigObject;
import org.yaml.snakeyaml.Yaml;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 01:04
 */
public class YAMLConfig extends ConfigObject {
    private String yaml;

    public YAMLConfig(String yaml) {
        this.yaml = yaml;
    }

    @Override
    public <T> T toJavaBean(Class<T> type) {
        return new Yaml().loadAs(this.yaml, type);
    }
}
