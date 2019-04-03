package com.example.kejapp.ui.viewmodel;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.kejapp.R;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.utils.CustomInfoWindowGoogleMap;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainFragment extends Fragment implements OnMapReadyCallback {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_location_info, container,
                false);
        MapView mapView = v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(this);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        PortMapTO portMapTO = new PortMapTO();
        portMapTO.setId(1L);
        portMapTO.setName("Wilkasy");

        LatLng wilkasy = new LatLng(54.009, 21.736);
        float zoomLevel = (float) 12.0;


        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getActivity());
        googleMap.setInfoWindowAdapter(customInfoWindow);


        Marker marker = googleMap.addMarker(new MarkerOptions().position(wilkasy).title("Wilkasy"));
        marker.setTag(portMapTO);


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wilkasy, zoomLevel));
    }
}
