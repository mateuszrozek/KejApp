package com.example.kejapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.content.SharedPreferences;

import com.example.kejapp.view.LoginActivity;
import com.example.kejapp.view.LogoutActivity;
import com.google.android.gms.common.util.Strings;

public class RetrofitClientInstance {
    private static final String BASE_URL = "http://10.0.2.2:8080/kejapp/api/v1/";          //emulator
    private static final String SECURITY_URL =  "http://10.0.2.2:8080/kejapp/api/v1/security/users/";
    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userToken";
//    private static final String BASE_URL = "http://192.168.100.169:8080/kejapp/api/v1/";  //phone must be in the same wi-fi network with computer


    public static Retrofit getRetrofitInstance(Context appContext) {

        Retrofit.Builder retrofitBuilder = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        return updateRetrofitBuilderWithAuthorizationHeader(getUserToken(appContext), retrofitBuilder).build();
    }

    private static String getUserToken(Context context){
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);
        String tokenFromSharedPreferences = preferences.getString(PREFERENCES_TEXT_FIELD, "");
        return tokenFromSharedPreferences;
    }

    public static Retrofit getRetrofitInstanceForUserAuthorization() {
        Retrofit retrofitAuth = new retrofit2.Retrofit.Builder()
                    .baseUrl(SECURITY_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofitAuth;
    }

    private static Retrofit.Builder updateRetrofitBuilderWithAuthorizationHeader(String userToken, Retrofit.Builder retrofitBuilder){
        if(!Strings.isEmptyOrWhitespace(userToken)){
            return retrofitBuilder.client(createOkHttepClient(userToken));
        } else {
            return retrofitBuilder;
        }
    }

    private static OkHttpClient createOkHttepClient(final String userToken) {
        OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request request = chain.request().newBuilder()
                                        .addHeader("Authorization", "Bearer " + userToken).build();
                                return chain.proceed(request);
                            }
                        }).build();
        return defaultHttpClient;
    }
}



