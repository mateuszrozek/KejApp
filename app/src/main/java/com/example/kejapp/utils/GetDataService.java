package com.example.kejapp.utils;

import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.model.QuayTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("ports")
    Call<List<PortMapTO>> findAllPorts();

    @GET("quays/{portId}")
    Call<List<QuayTO>> findQuaysById(@Path("portId") Long portId);

    @GET("ports/{portId}")
    Call<PortInfoTO> findPortById(@Path("portId") Long portId);
}
