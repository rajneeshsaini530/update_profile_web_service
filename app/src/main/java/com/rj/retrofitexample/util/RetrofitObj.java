package com.rj.retrofitexample.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObj {
    public static final String BASE_URL = "http://url_here";
    public static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static RequestIntefaceApi getRequestInterfaceApi(){
        return getRetrofit().create(RequestIntefaceApi.class);
    }

}
