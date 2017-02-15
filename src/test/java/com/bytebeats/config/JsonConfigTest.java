package com.bytebeats.config;

import com.bytebeats.config.model.Configuration;
import org.junit.Test;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @create 2017-02-16 00:59
 */
public class JsonConfigTest {

    @Test
    public void testLocalJson(){

        Config config = ConfigLoader.load("app.json", Format.JSON);
        Configuration conf = config.toJavaBean(Configuration.class);
        System.out.println(conf);
    }
}
