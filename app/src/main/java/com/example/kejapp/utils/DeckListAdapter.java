package com.example.kejapp.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kejapp.R;
import com.example.kejapp.model.PierTO;
import com.example.kejapp.view.ChooseQuayActivity;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DeckListAdapter extends RecyclerView.Adapter<DeckListAdapter.ViewHolder> {

    private List<PierTO> pierTOList;

    public DeckListAdapter(List<PierTO> pierTOList) {
        this.pierTOList = pierTOList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final PierTO pierTO = pierTOList.get(position);

        holder.deckNumberLabel.setText("pomost " + pierTO.getPierId());
        holder.freeQuaysLabel.setText(printAmountOfQuays(pierTO));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ChooseQuayActivity.class);
                intent.putExtra("pierTO", pierTO);
                view.getContext().startActivity(intent);
            }
        });
    }

    private String printAmountOfQuays(PierTO pierTO) {
        int free = pierTO.getFreeQuaysNumbers().size();
        int all = pierTO.getAllQuaysQuantity();

        return free + "/" + all + " miejsc";
    }

    @Override
    public int getItemCount() {
        return pierTOList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView deckNumberLabel;
        public TextView freeQuaysLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            this.deckNumberLabel = itemView.findViewById(R.id.deckNumberLabel);
            this.freeQuaysLabel = itemView.findViewById(R.id.freeQuaysLabel);
        }
    }
}
