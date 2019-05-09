package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.ReservationTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservationInfoActivity extends AppCompatActivity {

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
                Intent intent = new Intent(getApplicationContext(), ReservationsActivity.class);
                intent.putExtra("dupa", "dupa");
                /*TODO
                tu coś dodawać czy puścić requesta tylko?*/
                Toast.makeText(getApplicationContext(), "Rezerwacja została anulowana", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        reservationBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void fillTextViews(ReservationTO reservationTO) {

        reservationStartDate.setText(printStringFromLocalDateTime(reservationTO.getStartDate()));
        reservationEndDate.setText(printStringFromLocalDateTime(reservationTO.getStartDate()));

        reservationPortNameTextView.setText(printNamesFromString(reservationTO.getQuayInfoTO().getPortName()));
        reservationLatitudeTextView.setText(printMetersFromDouble(reservationTO.getQuayInfoTO().getLatitude()));
        reservationLongitudeTextView.setText(printMetersFromDouble(reservationTO.getQuayInfoTO().getLongitude()));

        reservationPierTextView.setText(printNamesFromString(reservationTO.getQuayInfoTO().getPier()));
        reservationQuayNumberTextView.setText(printStringFromNumber(reservationTO.getQuayInfoTO().getQuayNumber()));

        reservationMaxVesselLengthTextView.setText(printMetersFromDouble(reservationTO.getQuayInfoTO().getMaxVesselLength()));
        reservationMaxVesselWidthTextView.setText(printMetersFromDouble(reservationTO.getQuayInfoTO().getMaxVesselWidth()));
        reservationMaxVesselSubmersionTextView.setText(printMetersFromDouble(reservationTO.getQuayInfoTO().getMaxVesselSubmersion()));;

        reservationMooringAvailableTextView.setText(printStringFromBoolean(reservationTO.getQuayInfoTO().getMooringAvailable()));
        reservationMooringTypeTextView.setText(printNamesFromString(reservationTO.getQuayInfoTO().getMooringType()));
        reservationBuoyAvailableTextView.setText(printStringFromBoolean(reservationTO.getQuayInfoTO().getBuoyAvailable()));
        reservationAnchorRequiredTextView.setText(printStringFromBoolean(reservationTO.getQuayInfoTO().getAnchorRequired()));
        reservationElectricityAvailableTextView.setText(printStringFromBoolean(reservationTO.getQuayInfoTO().getElectricityAvailable()));
        reservationCurrentWaterAvailableTextView.setText(printStringFromBoolean(reservationTO.getQuayInfoTO().getCurrentWaterAvailable()));
        reservationCalculatedPriceTextView.setText(printPriceFromDouble(reservationTO.getQuayInfoTO().getCalculatedPrice()));
        reservationNotesTextView.setText(printNamesFromString(reservationTO.getQuayInfoTO().getNotes()));
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

    private String printStringFromLocalDateTime(LocalDateTime date) {
        if (date == null) return "N/A";
        else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
            return date.format(formatter);
        }
    }

    private String printStringFromNumber(Long quayNumber) {
        if (quayNumber == null) return "N/A";
        else return quayNumber.toString();
    }

    private String printStringFromBoolean(Boolean flag) {
        if (flag == null) return "N/A";
        else return flag.toString();
    }
}
