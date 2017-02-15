package com.bytebeats.conf;

import com.bytebeats.conf.http.HttpClient;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.net.URL;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 16:35
 */
public class YamlConfigLoader {

    public <T> T yaml(URL url, Class<T> cls){
        Yaml yaml = new Yaml();
        InputStream in = null;
        try {
            in = HttpClient.getHttpClient().get(url);
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
            InputStream in = YamlConfigLoader.class.getResourceAsStream(filename);
            return yaml.loadAs(in, cls);
        } catch (Exception e){
            throw new IllegalArgumentException("not found "+filename+" in classpath!");
        }
    }

}
