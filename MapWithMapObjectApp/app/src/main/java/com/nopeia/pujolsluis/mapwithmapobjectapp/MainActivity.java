package com.nopeia.pujolsluis.mapwithmapobjectapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    boolean mapReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tokyoButton = (Button) findViewById(R.id.tokyo_button);
        tokyoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady) {
                    LatLng tokyo = new LatLng(35.6585,139.7454);
                    CameraPosition cameraPosition = CameraPosition.builder()
                            .target(tokyo)
                            .zoom(17)
                            .tilt(45)
                            .bearing(90)
                            .build();

                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                            10000, null);
//                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }
        });

        Button newYorkButton = (Button) findViewById(R.id.newyork_button);
        newYorkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady) {
                    LatLng newyork = new LatLng(40.7127,-74.0059);
                    CameraPosition cameraPosition = CameraPosition.builder()
                            .target(newyork)
                            .zoom(21)
                            .tilt(45)
                            .bearing(0)
                            .build();

                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                            10000, null);
//                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }
        });

        Button dublinButton = (Button) findViewById(R.id.dublin_button);
        dublinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mapReady) {
                    LatLng dublin = new LatLng(53.3474,-6.2597);
                    CameraPosition cameraPosition = CameraPosition.builder()
                            .target(dublin)
                            .zoom(17)
                            .tilt(45)
                            .bearing(90)
                            .build();

                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition),
                            10000, null);
//                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mapReady = true;
        googleMap = map;
        LatLng newYork = new LatLng(40.7484, -73.9857);
        CameraPosition target = CameraPosition.builder().target(newYork).zoom(14).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

    }
}
