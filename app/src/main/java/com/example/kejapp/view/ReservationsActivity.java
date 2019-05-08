package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.model.QuayInfoTO;
import com.example.kejapp.model.ReservationTO;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.ReservationListAdapter;
import com.example.kejapp.utils.RetrofitClientInstance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationsActivity extends AppCompatActivity {

    private Intent intent;
//    private ReservationTO portInfoTO;
    private List<ReservationTO> reservationTOList;
    private GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    private RecyclerView recyclerView;
    private ReservationListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);

        initializeGlobalData();
        loadData(); //loadFromDB or mockReservations

        recyclerView = findViewById(R.id.recyclerViewReservations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void initializeGlobalData() {

        intent = getIntent();
//        reservationTOList = (PortInfoTO) intent.getSerializableExtra("portInfoTO");
    }

    private void loadData() {

        loadReservationsFromDB();
        if (reservationTOList == null) {
            mockReservations();
        }
    }

    private void loadReservationsFromDB() {

        Call<List<ReservationTO>> call = service.findReservations();
        call.enqueue(new Callback<List<ReservationTO>>() {

            @Override
            public void onResponse(Call<List<ReservationTO>> call, Response<List<ReservationTO>> response) {
                reservationTOList = response.body();
                adapter = new ReservationListAdapter(reservationTOList);
            }

            @Override
            public void onFailure(Call<List<ReservationTO>> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mockReservations() {
        reservationTOList = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            ReservationTO reservationTO = new ReservationTO();
            QuayInfoTO quayInfoTO = new QuayInfoTO();
            quayInfoTO.setPortName("Wilkasy");
            reservationTO.setQuayInfoTO(quayInfoTO);
            reservationTO.setStartDate(LocalDateTime.now());
            reservationTO.setEndDate(LocalDateTime.now());

            reservationTOList.add(reservationTO);
        }
        adapter = new ReservationListAdapter(reservationTOList);
    }


}
