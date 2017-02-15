package com.bytebeats.config;

import com.bytebeats.config.exception.ConfigException;
import com.bytebeats.config.factory.ConfigParserFactory;
import com.bytebeats.config.http.HttpClient;
import com.bytebeats.config.impl.SystemConfig;
import com.bytebeats.config.util.IoUtils;
import okhttp3.Request;
import okhttp3.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 16:35
 */
public class ConfigLoader {

    /**
     * load Java system properties, java -jar app.jar -Dapp.version=1.0
     * @return
     */
    public static Config load(){
        return new SystemConfig();
    }
    /**
     * load classpath config file
     * @param resourceName
     * @param format
     * @return
     */
    public static Config load(String resourceName, Format format){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return load(classLoader, resourceName, format);
    }

    public static Config load(ClassLoader classLoader, String resourceName, Format format){
        InputStream in = null;
        try {
            in = classLoader.getResourceAsStream(resourceName);
            return ConfigParserFactory.createConfigParser(format).parse(in);
        } catch (Exception e) {
            throw new ConfigException(e);
        } finally{
            IoUtils.closeQuietly(in);
        }
    }

    /**
     * parse given config file
     * @param file
     * @param format
     * @return
     */
    public static Config parseFile(File file, Format format){
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            return ConfigParserFactory.createConfigParser(format).parse(in);
        } catch (Exception e) {
            throw new ConfigException(e);
        } finally{
            IoUtils.closeQuietly(in);
        }
    }

    public static Config parseURL(String url, Format format){
        try {
            return parseURL(new URL(url), format);
        } catch (MalformedURLException e) {
            throw new ConfigException(e);
        }
    }

    public static Config parseURL(URL url, Format format){
        Response response = null;
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            response = HttpClient.getHttpClient().execute(request);
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);

            return ConfigParserFactory.createConfigParser(format).parse(response.body().byteStream());
        } catch (IOException e) {
            throw new ConfigException(e);
        } catch (Exception e) {
            throw new ConfigException(e);
        } finally {
            IoUtils.closeQuietly(response);
        }
    }
}
