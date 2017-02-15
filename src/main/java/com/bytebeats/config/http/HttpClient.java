package com.bytebeats.config.http;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
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

    public Call newCall(Request request) throws IOException {
        return client.newCall(request);
    }

    public Response execute(Request request) throws IOException {
        return client.newCall(request).execute();
    }

    private static class SingletonHolder {
        private static final HttpClient INSTANCE = new HttpClient();
    }
}
