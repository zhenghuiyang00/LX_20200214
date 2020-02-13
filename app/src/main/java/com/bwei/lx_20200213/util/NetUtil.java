package com.bwei.lx_20200213.util;

import com.bwei.lx_20200213.Api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetUtil {
    private static final String BASE_URL="http://mobile.bwstudent.com/";
    private final Api api;

    //1.geti
    public static NetUtil getInstance() {
        return SingleHolder.NET_UTIL;
    }

    public static final class SingleHolder{
        private static final NetUtil NET_UTIL=new NetUtil();
    }

    //2.私有构造
    public NetUtil(){
        //拦截器
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .writeTimeout(8, TimeUnit.SECONDS)
                .readTimeout(8,TimeUnit.SECONDS)
                .connectTimeout(8,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();

      Retrofit  retrofit = new Retrofit.Builder()
               .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        api = retrofit.create(Api.class);
    }

    public Api getApi() {
        return api;
    }
}
