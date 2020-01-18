package com.rj.retrofitexample.util;

import com.rj.retrofitexample.model.RegisterList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface RequestIntefaceApi {

    @FormUrlEncoded
    @POST("url_")
    Call<RegisterList> updateUser(@Field("U_Email") String U_Email,
                                  @Field("IMG_") String img,
                                  @Field("mob") String mobile,
                                  @Field("U_mobl") String u_mobl);
}