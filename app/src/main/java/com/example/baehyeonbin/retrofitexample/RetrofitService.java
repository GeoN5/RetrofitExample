package com.example.baehyeonbin.retrofitexample;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 이건호 on 2017-10-07.
 */

public interface RetrofitService {
    public static String URL="http://n0rr.iptime.org:5000";
    @FormUrlEncoded
    @POST("/test")
    Call<TestRepo> getItem(
            @Field("name")String name,
            @Field("number")String number
    );

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
