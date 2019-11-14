package com.sanyue.siqing.Network;

import com.sanyue.siqing.bean.SelectSpecial;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("iosController/selectSpecial")
    Observable<SelectSpecial> selectSpecial();

}
