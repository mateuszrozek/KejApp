package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.model.QuayInfoTO;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuayInfoActivity extends AppCompatActivity {

    QuayInfoTO quayInfoTO;
    private Intent intent;

    TextView textViewQuayInfo;

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
    Button quayOrderButton;
    Button quayBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quay_info);

        initializeGlobalData();
        bindTextViews();
        quayOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("dupa", "dupa");
                Toast.makeText(getApplicationContext(), "Keja została zarezerwowana", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        quayBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initializeGlobalData() {

        intent = getIntent();
        String quay = (String) intent.getSerializableExtra("quay");
        Long quayId = Long.valueOf(quay);

        /*TODO
        get to know if id is enough to identify quay
        * */

        quayInfoTO = new QuayInfoTO();
        quayInfoTO.setQuayNumber(quayId.doubleValue());
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
        quayOrderButton = findViewById(R.id.quayOrderButton);
        quayBackButton = findViewById(R.id.quayBackButton);
    }
}
