package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

public class ChooseDeckActivity extends AppCompatActivity {

    Intent intent;
    PortInfoTO portInfoTO;
    List<PierTO> pierTOS;
    private GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deck);


        initializeGlobalData();
        loadData(); //loadFromDB or mockDecks

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DeckListAdapter adapter = new DeckListAdapter(pierTOS);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void initializeGlobalData() {

        intent = getIntent();
        portInfoTO = (PortInfoTO) intent.getSerializableExtra("portInfoTO");
        imageView = findViewById(R.id.imageView);
        int id = portInfoTO.getId().intValue();
        switch (id){
            case 1: imageView.setBackgroundResource(R.drawable.wilkasy_piers);
                break;
            case 2: imageView.setBackgroundResource(R.drawable.mikolajki_piers);
                break;
            case 3: imageView.setBackgroundResource(R.drawable.wegorzewo_piers);
                break;
            case 4: imageView.setImageResource(R.drawable.gizycko_piers);
                break;
            case 5: imageView.setBackgroundResource(R.drawable.ruciane_piers);
                break;
        }
    }

    private void loadData() {

        loadDecksFromDB();
        if (pierTOS ==null){
            mockDecks();
        }
    }

    private void loadDecksFromDB() {

        Call<List<PierTO>> call = service.findPiersById(portInfoTO.getId());
        call.enqueue(new Callback<List<PierTO>>() {

            @Override
            public void onResponse(Call<List<PierTO>> call, Response<List<PierTO>> response) {
                pierTOS = response.body();
            }

            @Override
            public void onFailure(Call<List<PierTO>> call, Throwable t) {
                Toast.makeText(getApplication(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void mockDecks() {
        pierTOS = new ArrayList<>();

        for (int i = 1; i < 15; i++) {
            PierTO pierTO = new PierTO();
            pierTO.setPierId("A");
            pierTO.setPortId(Long.valueOf(i));
            pierTOS.add(pierTO);
        }
    }
}
