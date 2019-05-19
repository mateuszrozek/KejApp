package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.ReservationTO;
import com.example.kejapp.utils.Formatter;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.ReservationListAdapter;
import com.example.kejapp.utils.RetrofitClientInstance;

import java.util.List;

public class ReservationInfoActivity extends AppCompatActivity {

    private GetDataService service;

    private Formatter formatter;

    private ReservationTO reservationTO;
    private Intent intent;

    TextView reservationStartDate;
    TextView reservationEndDate;

    TextView reservationPortNameTextView;
    TextView reservationLatitudeTextView;
    TextView reservationLongitudeTextView;
    TextView reservationPierTextView;
    TextView reservationQuayNumberTextView;
    TextView reservationMaxVesselLengthTextView;
    TextView reservationMaxVesselWidthTextView;
    TextView reservationMaxVesselSubmersionTextView;
    TextView reservationMooringAvailableTextView;
    TextView reservationMooringTypeTextView;
    TextView reservationBuoyAvailableTextView;
    TextView reservationAnchorRequiredTextView;
    TextView reservationElectricityAvailableTextView;
    TextView reservationCurrentWaterAvailableTextView;
    TextView reservationCalculatedPriceTextView;
    TextView reservationNotesTextView;
    
    Button reservationRevokeButton;
    Button reservationBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_info);

        bindTextViews();
        initializeGlobalData();
        fillTextViews(reservationTO);

        reservationRevokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                revokeReservation(reservationTO);
                onBackPressed();
            }
        });
        reservationBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void revokeReservation(ReservationTO reservationTO) {
        Call<Void> call = service.deleteReservation(reservationTO.getId());
        call.enqueue(new Callback<Void>() {

            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
//                reservationTOList.rem
//                adapter = new ReservationListAdapter(reservationTOList);
//                recyclerView = findViewById(R.id.recyclerViewReservations);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void fillTextViews(ReservationTO reservationTO) {

        reservationStartDate.setText(formatter.printStringFromLocalDateTime(reservationTO.getStartDate()));
        reservationEndDate.setText(formatter.printStringFromLocalDateTime(reservationTO.getStartDate()));

        reservationPortNameTextView.setText(formatter.printNamesFromString(reservationTO.getQuayInfoTO().getPortName()));
        reservationLatitudeTextView.setText(formatter.printLatLngFromDouble(reservationTO.getQuayInfoTO().getLatitude()));
        reservationLongitudeTextView.setText(formatter.printLatLngFromDouble(reservationTO.getQuayInfoTO().getLongitude()));

        reservationPierTextView.setText(formatter.printNamesFromString(reservationTO.getQuayInfoTO().getPier()));
        reservationQuayNumberTextView.setText(formatter.printStringFromNumber(reservationTO.getQuayInfoTO().getQuayNumber()));

        reservationMaxVesselLengthTextView.setText(formatter.printMetersFromDouble(reservationTO.getQuayInfoTO().getMaxVesselLength()));
        reservationMaxVesselWidthTextView.setText(formatter.printMetersFromDouble(reservationTO.getQuayInfoTO().getMaxVesselWidth()));
        reservationMaxVesselSubmersionTextView.setText(formatter.printMetersFromDouble(reservationTO.getQuayInfoTO().getMaxVesselSubmersion()));;

        reservationMooringAvailableTextView.setText(formatter.printStringFromBoolean(reservationTO.getQuayInfoTO().getMooringAvailable()));
        reservationMooringTypeTextView.setText(formatter.printNamesFromString(reservationTO.getQuayInfoTO().getMooringType()));
        reservationBuoyAvailableTextView.setText(formatter.printStringFromBoolean(reservationTO.getQuayInfoTO().getBuoyAvailable()));
        reservationAnchorRequiredTextView.setText(formatter.printStringFromBoolean(reservationTO.getQuayInfoTO().getAnchorRequired()));
        reservationElectricityAvailableTextView.setText(formatter.printStringFromBoolean(reservationTO.getQuayInfoTO().getElectricityAvailable()));
        reservationCurrentWaterAvailableTextView.setText(formatter.printStringFromBoolean(reservationTO.getQuayInfoTO().getCurrentWaterAvailable()));
        reservationCalculatedPriceTextView.setText(formatter.printPriceFromDouble(reservationTO.getQuayInfoTO().getCalculatedPrice()));
        reservationNotesTextView.setText(formatter.printNamesFromString(reservationTO.getQuayInfoTO().getNotes()));
    }


    private void bindTextViews() {

        reservationStartDate = findViewById(R.id.reservationStartDate);
        reservationEndDate = findViewById(R.id.reservationEndDate);

        reservationPortNameTextView = findViewById(R.id.reservationPortNameTextView);
        reservationLatitudeTextView = findViewById(R.id.reservationLatitudeTextView);
        reservationLongitudeTextView = findViewById(R.id.reservationLongitudeTextView);
        reservationPierTextView = findViewById(R.id.reservationPierTextView);
        reservationQuayNumberTextView = findViewById(R.id.reservationQuayNumberTextView);
        reservationMaxVesselLengthTextView = findViewById(R.id.reservationMaxVesselLengthTextView);
        reservationMaxVesselWidthTextView = findViewById(R.id.reservationMaxVesselWidthTextView);
        reservationMaxVesselSubmersionTextView = findViewById(R.id.reservationMaxVesselSubmersionTextView);
        reservationMooringAvailableTextView = findViewById(R.id.reservationMooringAvailableTextView);
        reservationMooringTypeTextView = findViewById(R.id.reservationMooringTypeTextView);
        reservationBuoyAvailableTextView = findViewById(R.id.reservationBuoyAvailableTextView);
        reservationAnchorRequiredTextView = findViewById(R.id.reservationAnchorRequiredTextView);
        reservationElectricityAvailableTextView = findViewById(R.id.reservationElectricityAvailableTextView);
        reservationCurrentWaterAvailableTextView = findViewById(R.id.reservationCurrentWaterAvailableTextView);
        reservationCalculatedPriceTextView = findViewById(R.id.reservationCalculatedPriceTextView);
        reservationNotesTextView = findViewById(R.id.reservationNotesTextView);
        
        reservationRevokeButton = findViewById(R.id.reservationRevokeButton);
        reservationBackButton = findViewById(R.id.reservationBackButton);
    }

    private void initializeGlobalData(){

        intent = getIntent();
        reservationTO = (ReservationTO) intent.getSerializableExtra("reservationTO");
        service = RetrofitClientInstance.getRetrofitInstance(getApplicationContext()).create(GetDataService.class);
        formatter = new Formatter();
    }


}
