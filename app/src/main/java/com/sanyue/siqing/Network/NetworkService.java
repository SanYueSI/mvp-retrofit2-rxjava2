package com.sanyue.siqing.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    public static String BASE_URL="http://47.112.108.67/fnsc/";

    public static class InitRetrofit {
        public static final NetworkService INSTANCE = new NetworkService();
    }
    private Retrofit apiService() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpHelper.getInstance().okHttpClient())
                .build();
    }
    public <T> T NetworkService(Class<T> tClass) {
        return apiService().create(tClass);
    }

    public static NetworkService getInstance() {
        return InitRetrofit.INSTANCE;
    }

    public NetworkService() {
    }

}
