package com.example.kejapp.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.utils.Formatter;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;
import com.google.android.gms.common.util.Strings;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PortInfoActivity extends AppCompatActivity {


    private static final String PREFERENCES_NAME = "myPreferences";
    private static final String PREFERENCES_TEXT_FIELD = "userToken";
    private TextView portNameLabel;
    private TextView entranceWidthLabel;
    private TextView entranceDepthLabel;
    private TextView maxVesselSubmersionLabel;
    private TextView maxVesselLengthLabel;
    private TextView maxVesselWidthLabel;
    private TextView dailyWaterLevelUpLabel;
    private TextView dailyWaterLevelDownLabel;
    private TextView showerPriceLabel;
    private TextView bathroomPriceLabel;
    private TextView electricityPriceLabel;
    private TextView currentWaterPriceLabel;
    private TextView toiletEmptyingPriceLabel;
    private Button portInfoButton;
    private PortMapTO portMapTO;
    private PortInfoTO portInfoTO;
    private Intent intent;
    private SharedPreferences preferences;

    private GetDataService service;
    private Formatter formatter;

    @Override
    protected synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = RetrofitClientInstance.getRetrofitInstance(getApplicationContext()).create(GetDataService.class);
        setContentView(R.layout.activity_port_info);
        preferences = getSharedPreferences(PREFERENCES_NAME, Activity.MODE_PRIVATE);

        bindTextViews();
        initializeGlobalData();

        if (portInfoTO == null) {
            portInfoTO = new PortInfoTO();
            portInfoTO.setId(1L);
        }

        portInfoButton = findViewById(R.id.portInfoButton);
        portInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tokenFromSharedPreferences = preferences.getString(PREFERENCES_TEXT_FIELD, "");
                if (Strings.isEmptyOrWhitespace(tokenFromSharedPreferences)) {
                    showWarning();
                } else {
                    Intent intent = new Intent(PortInfoActivity.this, ChooseDeckActivity.class);
                    intent.putExtra("portInfoTO", portInfoTO);
                    startActivity(intent);
                }
            }
        });
    }

    public void showWarning() {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(PortInfoActivity.this);
        builder1.setMessage("Opcja dostępna tylko dla zalogowanych użytkowników.");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "ZALOGUJ",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(PortInfoActivity.this, LoginActivity.class);
                        intent.putExtra("portInfoTO", portInfoTO);
                        startActivity(intent);
                    }
                });
        builder1.setNegativeButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void initializeGlobalData() {
        intent = getIntent();
        portMapTO = (PortMapTO) intent.getSerializableExtra("portMapTO");
        loadPortInfoTO(portMapTO.getId());
        formatter = new Formatter();
    }

    private void bindTextViews() {
        portNameLabel = findViewById(R.id.portNameLabel);
        entranceWidthLabel = findViewById(R.id.entranceWidthLabel);
        entranceDepthLabel = findViewById(R.id.entranceDepthLabel);
        maxVesselSubmersionLabel = findViewById(R.id.maxVesselSubmersionLabel);
        maxVesselLengthLabel = findViewById(R.id.maxVesselLengthLabel);
        maxVesselWidthLabel = findViewById(R.id.maxVesselWidthLabel);
        dailyWaterLevelUpLabel = findViewById(R.id.dailyWaterLevelUpLabel);
        dailyWaterLevelDownLabel = findViewById(R.id.dailyWaterLevelDownLabel);

        showerPriceLabel = findViewById(R.id.showerPriceLabel);
        bathroomPriceLabel = findViewById(R.id.bathroomPriceLabel);
        electricityPriceLabel = findViewById(R.id.electricityPriceLabel);
        currentWaterPriceLabel = findViewById(R.id.currentWaterPriceLabel);
        toiletEmptyingPriceLabel = findViewById(R.id.toiletEmptyingPriceLabel);
    }

    private void fillTextViews(PortInfoTO portInfoTO) {
        portNameLabel.setText(formatter.printNamesFromString(portInfoTO.getName()));
        entranceWidthLabel.setText(formatter.printMetersFromDouble(portInfoTO.getEntranceWidth()));
        entranceDepthLabel.setText(formatter.printMetersFromDouble(portInfoTO.getEntranceDepth()));
        maxVesselSubmersionLabel.setText(formatter.printMetersFromDouble(portInfoTO.getMaxVesselSubmersion()));
        maxVesselLengthLabel.setText(formatter.printMetersFromDouble(portInfoTO.getMaxVesselLength()));
        maxVesselWidthLabel.setText(formatter.printMetersFromDouble(portInfoTO.getMaxVesselWidth()));
        dailyWaterLevelUpLabel.setText(formatter.printMetersFromDouble(portInfoTO.getDailyWaterLevelUp()));
        dailyWaterLevelDownLabel.setText(formatter.printMetersFromDouble(portInfoTO.getDailyWaterLevelDown()));

        showerPriceLabel.setText(formatter.printPriceFromDouble(portInfoTO.getShowerPrice()));
        bathroomPriceLabel.setText(formatter.printPriceFromDouble(portInfoTO.getBathroomPrice()));
        electricityPriceLabel.setText(formatter.printPriceFromDouble(portInfoTO.getElectricityPrice()));
        currentWaterPriceLabel.setText(formatter.printPriceFromDouble(portInfoTO.getCurrentWaterPrice()));
        toiletEmptyingPriceLabel.setText(formatter.printPriceFromDouble(portInfoTO.getToiletEmptyingPrice()));
    }

    private void loadPortInfoTO(Long id) {
        Call<PortInfoTO> call = service.findPortById(id);

        call.enqueue(new Callback<PortInfoTO>() {

            @Override
            public void onResponse(Call<PortInfoTO> call, Response<PortInfoTO> response) {
                portInfoTO = response.body();
                fillTextViews(portInfoTO);
            }

            @Override
            public void onFailure(Call<PortInfoTO> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
