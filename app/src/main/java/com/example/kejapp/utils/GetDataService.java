package com.example.kejapp.utils;

import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("ports")
    Call<List<PortMapTO>> findAllPorts();

    @GET("port/{id}")
    Call<PortInfoTO> findPortById(@Path("id") Long id);
}
