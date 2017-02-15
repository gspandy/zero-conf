package com.bytebeats.config;

import com.bytebeats.config.model.Configuration;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:59
 */
public class YAMLConfigTest {

    @Test
    public void testLocalYaml(){

        Config config = ConfigLoader.load("app.yml", Format.YAML);
        Configuration conf = config.toJavaBean(Configuration.class);
        System.out.println(conf);
    }
}
