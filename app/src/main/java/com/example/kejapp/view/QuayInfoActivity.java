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
import com.example.kejapp.model.PierTO;
import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.model.QuayInfoTO;
import com.example.kejapp.model.QuayTO;
import com.example.kejapp.utils.DeckListAdapter;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuayInfoActivity extends AppCompatActivity {

    QuayTO quayTO;
    QuayInfoTO quayInfoTO;
    private Intent intent;

    private GetDataService service;

    TextView textViewQuayInfo;

    TextView quayInfoPortNameTextView;
    TextView quayInfoLatitudeTextView;
    TextView quayInfoLongitudeTextView;
    TextView quayInfoPierTextView;
    TextView quayInfoQuayNumberTextView;
    TextView quayInfoMaxVesselLengthTextView;
    TextView quayInfoMaxVesselWidthTextView;
    TextView quayInfoMaxVesselSubmersionTextView;
    TextView quayInfoMooringAvailableTextView;
    TextView quayInfoMooringTypeTextView;
    TextView quayInfoBuoyAvailableTextView;
    TextView quayInfoAnchorRequiredTextView;
    TextView quayInfoElectricityAvailableTextView;
    TextView quayInfoCurrentWaterAvailableTextView;
    TextView quayInfoCalculatedPriceTextView;
    TextView quayInfoNotesTextView;
    Button quayInfoQuayOrderButton;
    Button quayInfoQuayBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = RetrofitClientInstance.getRetrofitInstance(getApplicationContext()).create(GetDataService.class);
        setContentView(R.layout.activity_quay_info);

        initializeGlobalData();
        loadData(); //loadFromDB or mockQuayInfo
        bindTextViews();

        quayInfoQuayOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("dupa", "dupa"); 
                /*TODO 
                tu coś dodawać czy puścić requesta tylko?*/
                Toast.makeText(getApplicationContext(), "Keja została zarezerwowana", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        quayInfoQuayBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initializeGlobalData() {
        intent = getIntent();
        quayTO = (QuayTO) intent.getSerializableExtra("quayTO");
    }

    private void loadData() {

        loadQuayInfoFromDB();
        if (quayInfoTO == null) {
            mockQuayInfo();
        }
    }

    private void mockQuayInfo() {
        quayInfoTO = new QuayInfoTO();
        quayInfoTO.setPortName("WilkasyDummy");
    }

    private void loadQuayInfoFromDB() {
        Call<QuayInfoTO> call = service.findQuayByPortIdAndPierAndQuayNumber(quayTO.getPortId(), quayTO.getPier(), quayTO.getQuayNumber());
        call.enqueue(new Callback<QuayInfoTO>() {

            @Override
            public void onResponse(Call<QuayInfoTO> call, Response<QuayInfoTO> response) {
                quayInfoTO = response.body();
                fillTextViews(quayInfoTO);
            }

            @Override
            public void onFailure(Call<QuayInfoTO> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fillTextViews(QuayInfoTO quayInfoTO) {

        quayInfoPortNameTextView.setText(printNamesFromString(quayInfoTO.getPortName()));
        quayInfoLatitudeTextView.setText(printMetersFromDouble(quayInfoTO.getLatitude()));
        quayInfoLongitudeTextView.setText(printMetersFromDouble(quayInfoTO.getLongitude()));

        quayInfoPierTextView.setText(printNamesFromString(quayInfoTO.getPier()));
        quayInfoQuayNumberTextView.setText(printNamesFromString(quayInfoTO.getQuayNumber().toString()));

        quayInfoMaxVesselLengthTextView.setText(printMetersFromDouble(quayInfoTO.getMaxVesselLength()));
        quayInfoMaxVesselWidthTextView.setText(printMetersFromDouble(quayInfoTO.getMaxVesselWidth()));
        quayInfoMaxVesselSubmersionTextView.setText(printMetersFromDouble(quayInfoTO.getMaxVesselSubmersion()));;

        quayInfoMooringAvailableTextView.setText(printNamesFromString(quayInfoTO.getMooringAvailable().toString()));
        quayInfoMooringTypeTextView.setText(printNamesFromString(quayInfoTO.getMooringType()));
        quayInfoBuoyAvailableTextView.setText(printNamesFromString(quayInfoTO.getBuoyAvailable().toString()));
        quayInfoAnchorRequiredTextView.setText(printNamesFromString(quayInfoTO.getAnchorRequired().toString()));
        quayInfoElectricityAvailableTextView.setText(printNamesFromString(quayInfoTO.getElectricityAvailable().toString()));
        quayInfoCurrentWaterAvailableTextView.setText(printNamesFromString(quayInfoTO.getCurrentWaterAvailable().toString()));
        quayInfoCalculatedPriceTextView.setText(printPriceFromDouble(quayInfoTO.getCalculatedPrice()));
        quayInfoNotesTextView.setText(printNamesFromString(quayInfoTO.getNotes()));
    }

    private void bindTextViews() {

        quayInfoPortNameTextView = findViewById(R.id.quayInfoPortNameTextView);
        quayInfoLatitudeTextView = findViewById(R.id.quayInfoLatitudeTextView);
        quayInfoLongitudeTextView = findViewById(R.id.quayInfoLongitudeTextView);
        quayInfoPierTextView = findViewById(R.id.quayInfoPierTextView);
        quayInfoQuayNumberTextView = findViewById(R.id.quayInfoQuayNumberTextView);
        quayInfoMaxVesselLengthTextView = findViewById(R.id.quayInfoMaxVesselLengthTextView);
        quayInfoMaxVesselWidthTextView = findViewById(R.id.quayInfoMaxVesselWidthTextView);
        quayInfoMaxVesselSubmersionTextView = findViewById(R.id.quayInfoMaxVesselSubmersionTextView);
        quayInfoMooringAvailableTextView = findViewById(R.id.quayInfoMooringAvailableTextView);
        quayInfoMooringTypeTextView = findViewById(R.id.quayInfoMooringTypeTextView);
        quayInfoBuoyAvailableTextView = findViewById(R.id.quayInfoBuoyAvailableTextView);
        quayInfoAnchorRequiredTextView = findViewById(R.id.quayInfoAnchorRequiredTextView);
        quayInfoElectricityAvailableTextView = findViewById(R.id.quayInfoElectricityAvailableTextView);
        quayInfoCurrentWaterAvailableTextView = findViewById(R.id.quayInfoCurrentWaterAvailableTextView);
        quayInfoCalculatedPriceTextView = findViewById(R.id.quayInfoCalculatedPriceTextView);
        quayInfoNotesTextView = findViewById(R.id.quayInfoNotesTextView);
        quayInfoQuayOrderButton = findViewById(R.id.quayInfoQuayOrderButton);
        quayInfoQuayBackButton = findViewById(R.id.quayInfoBackButton);
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
