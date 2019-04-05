package com.example.kejapp.ui.viewmodel;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kejapp.ChooseDeckActivity;
import com.example.kejapp.PortInfoActivity;
import com.example.kejapp.R;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.utils.CustomInfoWindowGoogleMap;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MainFragment extends Fragment implements OnMapReadyCallback {

    private MainViewModel mViewModel;
    private GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    private List<PortMapTO> portsMapTO;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        create();
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

        LatLng wilkasy = new LatLng(portsMapTO.get(0).getLongitude(), portsMapTO.get(0).getLatitude());
        float zoomLevel = (float) 12.0;

        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getActivity());
        googleMap.setInfoWindowAdapter(customInfoWindow);
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(getActivity(), PortInfoActivity.class);
                intent.putExtra("port", portsMapTO.get(0));
                startActivity(intent);
            }
        });
        googleMap.setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() {
            @Override
            public void onInfoWindowLongClick(Marker marker) {
                Intent intent = new Intent(getActivity(), ChooseDeckActivity.class);
                intent.putExtra("object 1", "dupa");
                startActivity(intent);

            }
        });

        Marker marker = googleMap.addMarker(new MarkerOptions().position(wilkasy).title("Wilkasy"));
        marker.setTag(portsMapTO.get(0));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wilkasy, zoomLevel));
    }

    private void create() {
        Call<List<PortMapTO>> call = service.getAllPortMapTOs();
        call.enqueue(new Callback<List<PortMapTO>>() {

            @Override
            public void onResponse(Call<List<PortMapTO>> call, Response<List<PortMapTO>> response) {
                portsMapTO = response.body();
            }

            @Override
            public void onFailure(Call<List<PortMapTO>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
