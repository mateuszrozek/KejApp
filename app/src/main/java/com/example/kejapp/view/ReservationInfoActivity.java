package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.kejapp.R;
import com.example.kejapp.model.ReservationTO;

public class ReservationInfoActivity extends AppCompatActivity {

    private ReservationTO reservationTO;
    private Intent intent;

    TextView reservationStartDate;
    TextView reservationEndDate;

    TextView portNameTextView;
    TextView latitudeTextView;
    TextView longitudeTextView;
    TextView pierTextView;
    TextView quayNumberTextView;
    TextView maxVesselLengthTextView;
    TextView maxVesselWidthTextView;
    TextView maxVesselSubmersionTextView;
    TextView mooringAvailableTextView;
    TextView mooringTypeTextView;
    TextView buoyAvailableTextView;
    TextView anchorRequiredTextView;
    TextView electricityAvailableTextView;
    TextView currentWaterAvailableTextView;
    TextView calculatedPriceTextView;
    TextView notesTextView;
    Button reservationRevokeButton;
    Button reservationBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_info);

        bindTextViews();
        initializeGlobalData();
    }

    private void bindTextViews() {

        portNameTextView = findViewById(R.id.portNameTextView);
        latitudeTextView = findViewById(R.id.latitudeTextView);
        longitudeTextView = findViewById(R.id.longitudeTextView);
        pierTextView = findViewById(R.id.pierTextView);
        quayNumberTextView = findViewById(R.id.quayNumberTextView);
        maxVesselLengthTextView = findViewById(R.id.maxVesselLengthTextView);
        maxVesselWidthTextView = findViewById(R.id.maxVesselWidthTextView);
        maxVesselSubmersionTextView = findViewById(R.id.maxVesselSubmersionTextView);
        mooringAvailableTextView = findViewById(R.id.mooringAvailableTextView);
        mooringTypeTextView = findViewById(R.id.mooringTypeTextView);
        buoyAvailableTextView = findViewById(R.id.buoyAvailableTextView);
        anchorRequiredTextView = findViewById(R.id.anchorRequiredTextView);
        electricityAvailableTextView = findViewById(R.id.electricityAvailableTextView);
        currentWaterAvailableTextView = findViewById(R.id.currentWaterAvailableTextView);
        calculatedPriceTextView = findViewById(R.id.calculatedPriceTextView);
        notesTextView = findViewById(R.id.notesTextView);
        reservationRevokeButton = findViewById(R.id.reservationRevokeButton);
        reservationBackButton = findViewById(R.id.reservationBackButton);
    }

    private void initializeGlobalData(){

        intent = getIntent();
        reservationTO = (ReservationTO) intent.getSerializableExtra("reservationTO");
    }

    private String printMetersFromDouble(Double d) {
        if (d == null) return "N/A";
        else return Double.toString(d) + "m";
    }

    private String printPriceFromDouble(Double d) {
        if (d == null) return "N/A";
        else return Double.toString(d) + "PLN";
    }

    private String printNamesFromString(String s) {
        if (s == null) return "N/A";
        else return s;
    }
}
