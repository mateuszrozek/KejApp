package com.example.kejapp.utils;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kejapp.R;
import com.example.kejapp.model.PortMapTO;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowGoogleMap implements GoogleMap.InfoWindowAdapter {

    private Context context;

    public CustomInfoWindowGoogleMap(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.map_custom_infowindow, null);

        PortMapTO portMapTO = (PortMapTO) marker.getTag();

        TextView textViewName = view.findViewById(R.id.textViewName);
        TextView textViewFreePlaceNumber = view.findViewById(R.id.textViewFreePlaceNumber);


        textViewName.setText(marker.getTitle());
        textViewFreePlaceNumber.setText(setPlaces(portMapTO));


        return view;
    }

    private String setPlaces(PortMapTO portMapTO) {
        return portMapTO.getFreeQuaysQuantity() + "/" + portMapTO.getAllQuaysQuantity();
    }
}

