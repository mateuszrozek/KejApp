package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.kejapp.R;
import com.example.kejapp.model.QuayTO;
import com.example.kejapp.utils.QuayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChooseQuayActivity extends AppCompatActivity {

    List<QuayTO> quays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_quay);

        mockQuays();

        GridView gridView = findViewById(R.id.gridViewChooseQuay);
        QuayAdapter quayAdapter = new QuayAdapter(this, quays);
        gridView.setAdapter(quayAdapter);
    }

    private void mockQuays() {
        quays = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            QuayTO quay = new QuayTO();
            Long id = new Long(i);
            quay.setQuayNumber(id);
            quay.setPortId(id);
            quay.setId(id);
            quays.add(quay);
        }

    }


}
