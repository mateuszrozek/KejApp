package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.kejapp.R;
import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.model.QuayInfoTO;

public class QuayInfoActivity extends AppCompatActivity {

    QuayInfoTO quayInfoTO;
    private Intent intent;

    TextView textViewQuayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quay_info);

        initializeGlobalData();

        textViewQuayInfo = findViewById(R.id.textViewQuayInfo);
        textViewQuayInfo.setText(quayInfoTO.getQuayNumber().toString());
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
