package com.example.kejapp.utils;

import com.example.kejapp.model.PortMapTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("ports")
    Call<List<PortMapTO>> getAllPortMapTOs();
}
