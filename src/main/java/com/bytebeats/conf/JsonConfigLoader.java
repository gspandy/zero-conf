package com.bytebeats.conf;

import com.bytebeats.conf.model.PropertiesHolder;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 16:35
 */
public class JsonConfigLoader {
    private final ConcurrentHashMap<String, PropertiesHolder> propertiesMap = new ConcurrentHashMap<String, PropertiesHolder>();

    public <T> T json(URL url, Class<T> cls) {
        return null;
    }

    public PropertiesHolder json(File file) {
        return null;
    }

    public PropertiesHolder json(String filename) {
        return null;
    }

}
