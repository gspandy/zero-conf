package com.bytebeats.config;

import com.bytebeats.config.model.Configuration;
import com.bytebeats.config.util.JsonUtils;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:52
 */
public class YAMLTest {

    @Test
    public void testYaml(){

        Yaml yaml = new Yaml();
        try {
            InputStream in = YAMLTest.class.getResourceAsStream("/app.yml");
            Configuration config = yaml.loadAs(in, Configuration.class );
            System.out.println(JsonUtils.toJson(config));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
