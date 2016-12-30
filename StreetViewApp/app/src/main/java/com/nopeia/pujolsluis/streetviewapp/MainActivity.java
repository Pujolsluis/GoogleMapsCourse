package com.nopeia.pujolsluis.streetviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class MainActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    StreetViewPanoramaFragment streetViewPanorama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        streetViewPanorama = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streeviewpanorama);
        streetViewPanorama.getStreetViewPanoramaAsync(this);
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama1) {
        streetViewPanorama1.setPosition(new LatLng(36.0579667, -112.1430996));
        StreetViewPanoramaCamera camera = new StreetViewPanoramaCamera.Builder()
                .bearing(180)
                .build();
        streetViewPanorama1.animateTo(camera, 1000);


    }
}
