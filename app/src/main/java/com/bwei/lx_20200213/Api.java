package com.bwei.lx_20200213;

import com.bwei.lx_20200213.model.entity.LoginEntity;
import com.bwei.lx_20200213.model.entity.OrderfromEntity;
import com.bwei.lx_20200213.model.entity.RegisterEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    //注册
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterEntity> register(@Field("phone")String phone,@Field("pwd") String pwd);

    //登录
    @FormUrlEncoded
    @POST("small/user/v1/login")
    Observable<LoginEntity> login(@Field("phone")String phone, @Field("pwd") String pwd);


    @GET("http://mobile.bwstudent.com/small/order/verify/v1/findOrderListByStatus")
    Observable<OrderfromEntity>getOrderformData(@Header("userId")int userId,
                                                @Header("sessionId")String sessionId,
                                                @Query("ststus")int status,
                                                @Query("page")int page,
                                                @Query("count")int count);

}
