package com.bwei.lx_20200213;

import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    //登录，注册
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterEntity> register(@Field("phone")String phone,@Field("pwd") String pwd);

    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginEntity> login(@Field("phone")String phone, @Field("pwd") String pwd);

}
