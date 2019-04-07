package com.example.kejapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.model.PortInfoTO;

public class PortInfoActivity extends AppCompatActivity {


    TextView portNameLabel;
    TextView entranceWidthLabel;
    TextView entranceDepthLabel;
    TextView maxVesselSubmersionLabel;
    TextView maxVesselLengthLabel;
    TextView maxVesselWidthLabel;
    TextView dailyWaterLevelUpLabel;
    TextView dailyWaterLevelDownLabel;
    TextView showerPriceLabel;
    TextView bathroomPriceLabel;
    TextView electricityPriceLabel;
    TextView currentWaterPriceLabel;
    TextView toiletEmptyingPriceLabel;

    Button portInfoButton;

    PortMapTO portMapTO;
    PortInfoTO portInfoTO;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_port_info);
        
        initializeGlobalData();
        bindTextViews();
        portInfoTO = new PortInfoTO();
        fillTextViews(portInfoTO);

        portInfoButton = findViewById(R.id.portInfoButton);
        portInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PortInfoActivity.this, ChooseDeckActivity.class);
                intent.putExtra("object 1", "dupa");
                startActivity(intent);
            }
        });
    }



    private void initializeGlobalData() {
        intent = getIntent();
        portMapTO = (PortMapTO)intent.getSerializableExtra("port");
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
        portNameLabel.setText(portMapTO.getName());

    }
}
