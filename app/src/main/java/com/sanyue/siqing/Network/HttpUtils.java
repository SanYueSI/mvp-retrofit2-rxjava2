package com.sanyue.siqing.Network;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * unknown at 2018/6/25
 */

public class HttpUtils {
    public static <T> T getApiService(Class<T> cls) {
        return NetworkService.getInstance().NetworkService(cls);
    }

    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return upstream ->
                upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }
}
