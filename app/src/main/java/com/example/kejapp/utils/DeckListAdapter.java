package com.example.kejapp.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.kejapp.R;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.view.ChooseQuayActivity;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DeckListAdapter extends  RecyclerView.Adapter<DeckListAdapter.ViewHolder>{

    private List<PierTO> pierTOS;

    public DeckListAdapter(List<PierTO> pierTOS) {
        this.pierTOS = pierTOS;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);


        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ChooseQuayActivity.class);
                intent.putExtra("pierTO", "dupa");
                view.getContext().startActivity(intent);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final PierTO pierTO = pierTOS.get(position);

        holder.deckNumberLabel.setText(mapToLetter(position));
        /*TODO*
        create nice look of x/y where x are free places and y are all places insetad of printAmountOfQuays()
        /
         */
                holder.freeQuaysLabel.setText(printAmountOfQuays(6, 9));


        holder.chooseQuayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ChooseQuayActivity.class);
                intent.putExtra("pierTO", pierTO);
                view.getContext().startActivity(intent);
            }
        });
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
        return pierTOS.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView deckNumberLabel;
        public TextView freeQuaysLabel;
        public Button chooseQuayButton;

        public ViewHolder(View itemView) {
            super(itemView);
            this.deckNumberLabel = itemView.findViewById(R.id.deckNumberLabel);
            this.freeQuaysLabel = itemView.findViewById(R.id.freeQuaysLabel);
            this.chooseQuayButton = itemView.findViewById(R.id.chooseQuayButton);
        }
    }
}
