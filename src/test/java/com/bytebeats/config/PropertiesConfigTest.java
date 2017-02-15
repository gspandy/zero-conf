package com.bytebeats.config;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class PropertiesConfigTest {

    @Test
    public void testLocalProperties(){

        Config config = ConfigLoader.load("classpath:app.properties", Format.PROPERTIES);

        System.out.println("app-name: "+ config.getString("app-name"));
        System.out.println("app-version: "+ config.getDouble("app-version"));
        System.out.println("proxy-allowed: "+ config.getBoolean("proxy-allowed"));
        System.out.println("read_timeout: "+ config.getInteger("read_timeout"));

        System.out.println("*******protocols******");
        String[] arr = config.getStringArray("protocols");
        for (String protocol : arr){
            System.out.println("protocol:"+protocol);
        }

    }

    @Test
    public void testRemoteProperties() throws MalformedURLException {

        URL url = new URL("https://raw.githubusercontent.com/TiFG/springmvc4-in-action/master/ch1-restful/src/main/resources/mysql.properties");
        Config config = ConfigLoader.parseURL(url, Format.PROPERTIES);
        System.out.println(config.getString("ds1.jdbc.username"));
    }


}
