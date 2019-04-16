package com.example.kejapp.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.kejapp.R;
import com.example.kejapp.model.QuayTO;
import com.example.kejapp.view.QuayInfoActivity;
import java.util.List;

public class QuayAdapter extends BaseAdapter {

    private final Context context;
    private final List<QuayTO> quays;

    public QuayAdapter(Context context, List<QuayTO> quays) {
        this.context = context;
        this.quays = quays;
    }

    @Override
    public int getCount() {
        return quays.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (view == null) {

            gridView = inflater.inflate(R.layout.choose_quay_item, null);
            final TextView textViewQuay = gridView.findViewById(R.id.textViewQuay);
            textViewQuay.setText(quays.get(position).getQuayNumber().toString());

            textViewQuay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), QuayInfoActivity.class);
                    intent.putExtra("quay", textViewQuay.getText());
                    view.getContext().startActivity(intent);
                }
            });

        } else {
            gridView = view;
        }
        return gridView;
    }
}
