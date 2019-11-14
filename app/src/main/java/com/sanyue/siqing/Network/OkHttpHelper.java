package com.sanyue.siqing.Network;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpHelper {
    private static class OkHttpInit {
        private static final OkHttpHelper OK_HTTP_HELPER = new OkHttpHelper();
    }

    static OkHttpHelper getInstance() {
        return OkHttpInit.OK_HTTP_HELPER;
    }

    OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }
    //拦截器
    class  LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

            Response originalResponse = chain.proceed(request);
                //如果有统一的head可以在这里添加
//                return originalResponse.newBuilder()
//                .header("xxxx","xxxx")
//                        .header("xxx","xxx")
//                        .build();
                return originalResponse;
        }

    }
}
