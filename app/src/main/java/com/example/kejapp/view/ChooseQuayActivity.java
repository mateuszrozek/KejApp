package com.example.kejapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.model.QuayTO;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.QuayAdapter;
import com.example.kejapp.utils.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseQuayActivity extends AppCompatActivity {

    private List<QuayTO> quayTOs;
    private Intent intent;
    private PierTO pierTO;
    private GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    private QuayAdapter quayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_quay);

        initializeGlobalData();
        loadData(); //loadFromDB or mockDecks

//        mockQuays();

        GridView gridView = findViewById(R.id.gridViewChooseQuay);
        gridView.setAdapter(quayAdapter);
    }

    private void initializeGlobalData() {

        intent = getIntent();
        pierTO = (PierTO) intent.getSerializableExtra("pierTO");
    }

    private void loadData() {

        loadQuaysFromDB();
        if (quayTOs == null) {
            mockQuays();
        }
    }


    private void loadQuaysFromDB() {

        Call<List<QuayTO>> call = service.findQuaysByPortId(pierTO.getPortId());
        call.enqueue(new Callback<List<QuayTO>>() {

            @Override
            public void onResponse(Call<List<QuayTO>> call, Response<List<QuayTO>> response) {
                quayTOs = response.body();
                quayAdapter = new QuayAdapter(getApplicationContext(), quayTOs);

            }

            @Override
            public void onFailure(Call<List<QuayTO>> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mockQuays() {
        quayTOs = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            QuayTO quay = new QuayTO();
            Long id = new Long(i);
            quay.setQuayNumber(id);
            quay.setPortId(id);
            quay.setPier("A");
            quayTOs.add(quay);
        }
        quayAdapter = new QuayAdapter(getApplicationContext(), quayTOs);
    }
}
