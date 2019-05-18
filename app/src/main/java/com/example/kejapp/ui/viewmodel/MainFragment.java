package com.example.kejapp.ui.viewmodel;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.kejapp.view.ChooseDeckActivity;
import com.example.kejapp.view.LoginActivity;
import com.example.kejapp.view.LogoutActivity;
import com.example.kejapp.view.PortInfoActivity;
import com.example.kejapp.R;
import com.example.kejapp.model.PortMapTO;
import com.example.kejapp.utils.CustomInfoWindowGoogleMap;
import com.example.kejapp.utils.GetDataService;
import com.example.kejapp.utils.RetrofitClientInstance;
import com.google.android.gms.common.util.Strings;
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
    private GetDataService service;
    private List<PortMapTO> portsMapTO;
    
    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        service = RetrofitClientInstance.getRetrofitInstance(getContext()).create(GetDataService.class);
//        loadPortsFromDB();
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
        loadPortsFromDB(googleMap);

//        if (portsMapTO!=null){
//            loadMarkers(googleMap);
//        }
//        else {
//            loadDummyMarker(googleMap);
//        }

        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(getActivity());
        googleMap.setInfoWindowAdapter(customInfoWindow);
        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(getActivity(), PortInfoActivity.class);
                intent.putExtra("portMapTO", (PortMapTO)marker.getTag());
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

        //set position for work purposes
        LatLng wilkasy = new LatLng(54.009, 21.736);
        float zoomLevel = (float) 12.0;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wilkasy, zoomLevel));
    }

    private void loadDummyMarker(GoogleMap googleMap) {
        PortMapTO wilkasyDummy = new PortMapTO();
        wilkasyDummy.setName("WilkasyDummy");
        wilkasyDummy.setId(1L);
        wilkasyDummy.setLatitude(54.009);
        wilkasyDummy.setLongitude(21.736);
        Marker dummyMarker = googleMap.addMarker(new MarkerOptions().position(new LatLng(wilkasyDummy.getLatitude(), wilkasyDummy.getLongitude())).title(wilkasyDummy.getName()));
        dummyMarker.setTag(wilkasyDummy);
    }

    private void loadMarkers(GoogleMap googleMap) {
        for (PortMapTO port : portsMapTO) {
            LatLng latLng = new LatLng(port.getLatitude(), port.getLongitude());
            String portName = port.getName();
            Marker marker = googleMap.addMarker(new MarkerOptions().position(latLng).title(portName));
            marker.setTag(port);
        }
    }

    private void loadPortsFromDB(final GoogleMap googleMap) {
        Call<List<PortMapTO>> call = service.findAllPorts();
        call.enqueue(new Callback<List<PortMapTO>>() {

            @Override
            public void onResponse(Call<List<PortMapTO>> call, Response<List<PortMapTO>> response) {
                try {
                    portsMapTO = response.body();
                    loadMarkers(googleMap);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<List<PortMapTO>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                loadDummyMarker(googleMap);
            }
        });
    }
}
