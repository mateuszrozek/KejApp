package com.example.kejapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kejapp.R;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.model.PortInfoTO;
import com.example.kejapp.utils.DeckListAdapter;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseDeckActivity extends AppCompatActivity {

    private Intent intent;
    private PortInfoTO portInfoTO;
    private List<PierTO> pierTOList;
    private GetDataService service;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private DeckListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        service = RetrofitClientInstance.getRetrofitInstance(getApplicationContext()).create(GetDataService.class);
        setContentView(R.layout.activity_choose_deck);

        initializeGlobalData();
        loadData(); //loadFromDB or mockDecks
    }

    private void initializeGlobalData() {

        intent = getIntent();
        portInfoTO = (PortInfoTO) intent.getSerializableExtra("portInfoTO");
        imageView = findViewById(R.id.imageView);
        int id = portInfoTO.getId().intValue();
        switch (id) {
            case 1:
                imageView.setImageResource(R.drawable.wilkasy_piers);
                break;
            case 2:
                imageView.setImageResource(R.drawable.mikolajki_piers);
                break;
            case 3:
                imageView.setImageResource(R.drawable.wegorzewo_piers);
                break;
            case 4:
                imageView.setImageResource(R.drawable.gizycko_piers);
                break;
            case 5:
                imageView.setImageResource(R.drawable.ruciane_piers);
                break;
        }
    }

    private void loadData() {

        loadDecksFromDB();
    }

    private void loadDecksFromDB() {

        Call<List<PierTO>> call = service.findPiersByPortId(portInfoTO.getId());
        call.enqueue(new Callback<List<PierTO>>() {

            @Override
            public void onResponse(Call<List<PierTO>> call, Response<List<PierTO>> response) {
                pierTOList = response.body();
                adapter = new DeckListAdapter(pierTOList);
                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PierTO>> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                mockDecks();
            }
        });
    }


    private void mockDecks() {
        pierTOList = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            PierTO pierTO = new PierTO();
            pierTO.setPierId("A");
            pierTO.setPortId(Long.valueOf(i));
            pierTO.setAllQuaysQuantity(7);
            ArrayList<Long> longs = new ArrayList<>();
            longs.add(1L);
            longs.add(2L);
            longs.add(3L);
            longs.add(4L);
            longs.add(5L);
            pierTO.setFreeQuaysNumbers(longs);
            pierTOList.add(pierTO);
        }
        adapter = new DeckListAdapter(pierTOList);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
