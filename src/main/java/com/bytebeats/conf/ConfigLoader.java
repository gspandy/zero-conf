package com.bytebeats.conf;

import com.bytebeats.conf.model.PropertiesHolder;
import com.bytebeats.conf.util.IoUtils;
import com.bytebeats.conf.util.PropertiesUtils;
import org.yaml.snakeyaml.Yaml;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 16:35
 */
public class ConfigLoader {
    private final ConcurrentHashMap<String, PropertiesHolder> propertiesMap = new ConcurrentHashMap<String, PropertiesHolder>();

    public static ConfigLoader configuration(){
        return SingletonHolder.INSTANCE;
    }

    public PropertiesHolder properties(URL url) {
        try {
            Properties props = PropertiesUtils.load(url);
            return new PropertiesHolder(url.getPath(), props);
        } catch (Exception e) {
            throw new IllegalArgumentException("load url:"+url+" failed", e);
        }
    }

    public PropertiesHolder properties(File file) {
        try {
            Properties props = PropertiesUtils.load(file);
            return new PropertiesHolder(file.getName(), props);
        } catch (Exception e) {
            throw new IllegalArgumentException("not found "+file);
        }
    }

    public PropertiesHolder properties(String filename) {
        if (!filename.startsWith("/")) {
            filename = "/" + filename;
        }
        InputStream in = null;
        try {
            PropertiesHolder holder = propertiesMap.get(filename);
            if(holder==null){
                Properties props = PropertiesUtils.load(filename);
                holder = new PropertiesHolder(filename, props);
                PropertiesHolder oldHolder = propertiesMap.putIfAbsent(filename, holder);
                if(oldHolder!=null){
                    holder = oldHolder;
                }
            }
            return holder;
        } catch (Exception e) {
            throw new IllegalArgumentException("not found "+filename+" in classpath!");
        } finally {
            IoUtils.closeQuietly(in);
        }
    }

    public <T> T yaml(URL url, Class<T> cls){
        Yaml yaml = new Yaml();
        InputStream in = null;
        try {
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);
            in = connection.getInputStream();
            return yaml.loadAs(in, cls);
        } catch (Exception e){
            throw new IllegalArgumentException("not found "+url+" in classpath!");
        }
    }

    public <T> T yaml(String name, Class<T> cls){
        String filename = String.format("%s.properties", name);
        if (!filename.startsWith("/")) {
            filename = "/" + filename;
        }
        Yaml yaml = new Yaml();
        try {
            InputStream in = ConfigLoader.class.getResourceAsStream(filename);
            return yaml.loadAs(in, cls);
        } catch (Exception e){
            throw new IllegalArgumentException("not found "+filename+" in classpath!");
        }
    }

    private static class SingletonHolder {
        private static final ConfigLoader INSTANCE = new ConfigLoader();
    }
}
