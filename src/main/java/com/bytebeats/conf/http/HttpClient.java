package com.bytebeats.conf.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-15 19:52
 */
public class HttpClient {
    private final OkHttpClient client;

    private HttpClient(){
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public static HttpClient getHttpClient(){
        return SingletonHolder.INSTANCE;
    }

    public InputStream get(String url) throws IOException {
        return get(new URL(url), HttpMethod.GET);
    }

    public InputStream get(URL url) throws IOException {
        return get(url, HttpMethod.GET);
    }

    public InputStream get(URL url, HttpMethod method) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try{
            response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);

            return response.body().byteStream();
        } finally {
            response.close();
        }
    }

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }
}
