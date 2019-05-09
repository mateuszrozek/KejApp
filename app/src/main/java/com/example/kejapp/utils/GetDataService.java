package com.example.kejapp.utils;

import com.example.kejapp.model.KejappUserTO;
import com.example.kejapp.model.MakeReservationRequest;
import com.example.kejapp.model.LoginUserRequest;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.model.QuayInfoTO;
import com.example.kejapp.model.QuayTO;
import com.example.kejapp.model.ReservationTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GetDataService {

    @GET("ports")
    Call<List<PortMapTO>> findAllPorts();

    @GET("quays/{portId}")
    Call<List<QuayTO>> findQuaysByPortId(@Path("portId") Long portId);

    @GET("piers/{portId}")
    Call<List<PierTO>> findPiersByPortId(@Path("portId") Long portId);

    @GET("ports/{portId}")
    Call<PortInfoTO> findPortById(@Path("portId") Long portId);

    @GET("quays")
    Call<QuayInfoTO> findQuayByPortIdAndPierAndQuayNumber(@Query("portId")Long portId, @Query("pier")String pier, @Query("quayNumber")Long quayNumber);

    @POST("reservations")
    Call<Void> makeReservation(MakeReservationRequest makeReservationRequest);

    @GET("reservations")
    Call<List<ReservationTO>> findReservations();

    @POST("register")
    Call<Void> registerUser(@Body KejappUserTO kejappUserTO);

    @POST("login")
    Call<Void> login(@Body LoginUserRequest loginUserRequest);
}
