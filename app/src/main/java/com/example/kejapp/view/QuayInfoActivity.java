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
import com.example.kejapp.model.MakeReservationRequest;
import com.example.kejapp.model.QuayInfoTO;
import com.example.kejapp.model.QuayTO;
import com.example.kejapp.utils.Formatter;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;

public class QuayInfoActivity extends AppCompatActivity {

    QuayTO quayTO;
    QuayInfoTO quayInfoTO;
    private Intent intent;

    private Formatter formatter;

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

        bindTextViews();
        initializeGlobalData();
        loadData(); //loadFromDB or mockQuayInfo

        quayInfoQuayOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeReservationRequest();
            }
        });
        quayInfoQuayBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void makeReservationRequest(){
        MakeReservationRequest makeReservationRequest = new MakeReservationRequest();
        makeReservationRequest.setPortId(quayTO.getPortId());
        makeReservationRequest.setPier(quayTO.getPier());
        makeReservationRequest.setQuayNumber(new Long(quayTO.getQuayNumber()).doubleValue());
        sendReservationRequest(makeReservationRequest);
    }

    private void sendReservationRequest(MakeReservationRequest makeReservationRequest) {
        try {
            Call<Void> call = service.makeReservation(makeReservationRequest);
            call.enqueue(new Callback<Void>() {

                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    if (response.code() == 201) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("dupa", "dupa");
                        Toast.makeText(getApplicationContext(), "Keja została zarezerwowana", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplication(), "Nie można dokonaćrezerwacji kei, spróbuj ponownie później.", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                    mockQuayInfo();
                }
            });
        } catch(Exception ex){
            System.out.println(ex.getStackTrace());
        }
    }

    private void initializeGlobalData() {
        intent = getIntent();
        quayTO = (QuayTO) intent.getSerializableExtra("quayTO");
        formatter = new Formatter();
    }

    private void loadData() {
        loadQuayInfoFromDB();
    }

    private void mockQuayInfo() {
        quayInfoTO = new QuayInfoTO();
        quayInfoTO.setPortName("WilkasyDummy");
        fillTextViews(quayInfoTO);
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
                mockQuayInfo();
            }
        });
    }

    private void fillTextViews(QuayInfoTO quayInfoTO) {

        quayInfoPortNameTextView.setText(formatter.printNamesFromString(quayInfoTO.getPortName()));
        quayInfoLatitudeTextView.setText(formatter.printLatLngFromDouble(quayInfoTO.getLatitude()));
        quayInfoLongitudeTextView.setText(formatter.printLatLngFromDouble(quayInfoTO.getLongitude()));

        quayInfoPierTextView.setText(formatter.printNamesFromString(quayInfoTO.getPier()));
        quayInfoQuayNumberTextView.setText(formatter.printStringFromNumber(quayInfoTO.getQuayNumber()));

        quayInfoMaxVesselLengthTextView.setText(formatter.printMetersFromDouble(quayInfoTO.getMaxVesselLength()));
        quayInfoMaxVesselWidthTextView.setText(formatter.printMetersFromDouble(quayInfoTO.getMaxVesselWidth()));
        quayInfoMaxVesselSubmersionTextView.setText(formatter.printMetersFromDouble(quayInfoTO.getMaxVesselSubmersion()));;

        quayInfoMooringAvailableTextView.setText(formatter.printStringFromBoolean(quayInfoTO.getMooringAvailable()));
        quayInfoMooringTypeTextView.setText(formatter.printNamesFromString(quayInfoTO.getMooringType()));
        quayInfoBuoyAvailableTextView.setText(formatter.printStringFromBoolean(quayInfoTO.getBuoyAvailable()));
        quayInfoAnchorRequiredTextView.setText(formatter.printStringFromBoolean(quayInfoTO.getAnchorRequired()));
        quayInfoElectricityAvailableTextView.setText(formatter.printStringFromBoolean(quayInfoTO.getElectricityAvailable()));
        quayInfoCurrentWaterAvailableTextView.setText(formatter.printStringFromBoolean(quayInfoTO.getCurrentWaterAvailable()));
        quayInfoCalculatedPriceTextView.setText(formatter.printPriceFromDouble(quayInfoTO.getCalculatedPrice()));
        quayInfoNotesTextView.setText(formatter.printNamesFromString(quayInfoTO.getNotes()));
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
}
