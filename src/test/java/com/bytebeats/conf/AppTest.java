package com.bytebeats.conf;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testLocalProperties(){

        System.out.println("app-name: "+ ConfigLoader.configuration().properties("app.properties").getString("app-name"));
        System.out.println("app-version: "+ ConfigLoader.configuration().properties("app.properties").getDouble("app-version"));
        System.out.println("proxy-allowed: "+ ConfigLoader.configuration().properties("app.properties").getBoolean("proxy-allowed"));
        System.out.println("read_timeout: "+ ConfigLoader.configuration().properties("app.properties").getInteger("read_timeout"));

        System.out.println("*******protocols******");
        String[] arr = ConfigLoader.configuration().properties("app.properties").getStringArray("protocols");
        for (String protocol : arr){
            System.out.println("protocol:"+protocol);
        }

    }

    @Test
    public void testRemoteProperties() throws MalformedURLException {

        URL url = new URL("https://raw.githubusercontent.com/TiFG/springmvc4-in-action/master/ch1-restful/src/main/resources/mysql.properties");
        System.out.println(ConfigLoader.configuration().properties(url).getString("ds1.jdbc.username"));
    }


}
