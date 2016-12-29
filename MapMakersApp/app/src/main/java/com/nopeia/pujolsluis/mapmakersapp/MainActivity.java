package com.nopeia.pujolsluis.mapmakersapp;

import android.content.res.Resources;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    boolean mapReady = false;

    MarkerOptions renton;
    MarkerOptions kirkland;
    MarkerOptions everett;
    MarkerOptions lynnwood;
    MarkerOptions montlake;
    MarkerOptions kent;
    MarkerOptions showare;

    static final CameraPosition SEATTLE = CameraPosition.builder()
            .target(new LatLng(47.6204, -122.2491))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();

    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        renton = new MarkerOptions()
                .position(new LatLng(47.489805, -122.120502))
                .title("Renton");

        kirkland = new MarkerOptions()
                .position(new LatLng(47.7301986, -122.1768858))
                .title("Kirkland");

        everett = new MarkerOptions()
                .position(new LatLng(47.978748, -122.202001))
                .title("Everett");

        lynnwood = new MarkerOptions()
                .position(new LatLng(47.819533, -122.32288))
                .title("Lynnwood");

        montlake = new MarkerOptions()
                .position(new LatLng(47.7973733, -122.3281771))
                .title("Montlake Terrace");

        kent = new MarkerOptions()
                .position(new LatLng(47.385938, -122.258212))
                .title("Kent Valley");

        showare = new MarkerOptions()
                .position(new LatLng(47.38702, -122.23986))
                .title("Showare Center");


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        mapReady = true;
        googleMap.addMarker(renton);
        googleMap.addMarker(kirkland);
        googleMap.addMarker(everett);
        googleMap.addMarker(lynnwood);
        googleMap.addMarker(montlake);
        googleMap.addMarker(kent);
        googleMap.addMarker(showare);
        flyTo(SEATTLE);

    }

    public void flyTo(CameraPosition cameraPosition){
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
