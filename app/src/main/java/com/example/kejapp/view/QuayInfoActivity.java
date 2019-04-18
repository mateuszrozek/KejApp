package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quay_info);

        initializeGlobalData();
        bindTextViews();

        textViewQuayInfo = findViewById(R.id.textViewQuayInfo);
        textViewQuayInfo.setText(quayInfoTO.getQuayNumber().toString());
    }

    private void bindTextViews() {


//        portNameTextView;
//        latitudeTextView;
//        longitudeTextView;
//        pierTextView;
//        quayNumberTextView;
//        maxVesselLengthTextView;
//        maxVesselWidthTextView;
//        maxVesselSubmersionTextView;
//        mooringAvailableTextView;
//        mooringTypeTextView;
//        buoyAvailableTextView;
//        anchorRequiredTextView;
//        electricityAvailableTextView;
//        currentWaterAvailableTextView;
//        calculatedPriceTextView;
//        notesTextView;
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
}
