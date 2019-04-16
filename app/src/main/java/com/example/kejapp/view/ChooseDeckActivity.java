package com.example.kejapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kejapp.R;
import com.example.kejapp.utils.Deck;
import com.example.kejapp.utils.DeckListAdapter;

import java.util.ArrayList;

public class ChooseDeckActivity extends AppCompatActivity {

    ArrayList<Deck> decks;
//    ArrayList<Quay> quays;

    /*TODO
    initialize decksto avoid NPE - additional service needed?
    * */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_deck);

        mockDecks(); //mock

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DeckListAdapter adapter = new DeckListAdapter(decks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void mockDecks() {
        decks = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            decks.add(new Deck(i+1, i+6));
        }
    }
}
