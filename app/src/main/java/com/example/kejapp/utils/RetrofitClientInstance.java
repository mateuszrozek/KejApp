package com.example.kejapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {

    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://10.0.2.2:8080/kejapp/api/v1/";
    private static final String BASE_URL = "http://192.168.43.xxx:8080/kejapp/api/v1/";
//    private static final String BASE_URL = "https://www.google.com/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

