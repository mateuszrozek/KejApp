package com.example.kejapp.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.kejapp.R;
import com.example.kejapp.view.ChooseQuayActivity;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class DeckListAdapter extends  RecyclerView.Adapter<DeckListAdapter.ViewHolder>{

    private ArrayList<Deck> decks;

    public DeckListAdapter(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ChooseQuayActivity.class);
                intent.putExtra("object 1", "dupa");
                view.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Deck deck = decks.get(position);

        holder.deckNumberLabel.setText(mapToLetter(position));
        holder.freeQuaysLabel.setText(printAmountOfQuays(deck.getFreeQuays(), deck.getTotalQuays()));

//        holder.chooseQuayButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(view.getContext(), ChooseQuayActivity.class);
//                intent.putExtra("object 1", "dupa");
//                view.getContext().startActivity(intent);
//            }
//        });
    }

    private String printAmountOfQuays(int freeQuays, int totalQuays) {
        return freeQuays + "/" + totalQuays;
    }


    private String mapToLetter(int position) {

        char[] letters = {'A', 'B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','R'};

        return Character.toString(letters[position]);
    }


    @Override
    public int getItemCount() {
        return decks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView deckNumberLabel;
        public TextView freeQuaysLabel;
//        public Button chooseQuayButton;

        public ViewHolder(View itemView) {
            super(itemView);
            this.deckNumberLabel = itemView.findViewById(R.id.deckNumberLabel);
            this.freeQuaysLabel = itemView.findViewById(R.id.freeQuaysLabel);
//            this.chooseQuayButton = itemView.findViewById(R.id.chooseQuayButton);
        }
    }
}
