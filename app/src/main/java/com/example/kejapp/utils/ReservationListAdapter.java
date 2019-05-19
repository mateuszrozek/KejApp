package com.example.kejapp.utils;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kejapp.R;
import com.example.kejapp.model.ReservationTO;
import com.example.kejapp.view.ReservationInfoActivity;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ReservationListAdapter extends RecyclerView.Adapter<ReservationListAdapter.ViewHolder> {

    private List<ReservationTO> reservationTOList;

    public ReservationListAdapter(List<ReservationTO> reservationTOList) {
        this.reservationTOList = reservationTOList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View listItem = layoutInflater.inflate(R.layout.reservation_item, parent, false);

        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final ReservationTO reservationTO = reservationTOList.get(position);

        int num = position + 1;
        holder.reservationNumberLabel.setText(num + "");
        holder.reservationPortNameLabel.setText(reservationTO.getQuayInfoTO().getPortName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ReservationInfoActivity.class);
                intent.putExtra("reservationTO", reservationTO);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return reservationTOList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView reservationNumberLabel;
        public TextView reservationPortNameLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            this.reservationNumberLabel = itemView.findViewById(R.id.reservationNumberLabel);
            this.reservationPortNameLabel = itemView.findViewById(R.id.reservationPortNameLabel);
        }
    }
}
