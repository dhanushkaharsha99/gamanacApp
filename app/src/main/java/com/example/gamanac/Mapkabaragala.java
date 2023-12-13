package com.example.gamanac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;
import android.view.View;
import android.view.Window;

import com.example.gamanac.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapkabaragala extends AppCompatActivity implements OnMapReadyCallback {
    // Variables
    private GoogleMap mMap;
    private boolean isSatelliteView = false;

    private static final int LOCATION_PERMISSION_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the action bar
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mapkabaragala);

        //Checks if the location permission is granted
        if (isLocationPermissionGranted()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map_fragment);
            mapFragment.getMapAsync(this);
        } else {
            requestLocationPermission();
        }
    }
        //when map is ready
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
            //if location permission granted enable map
        if (isLocationPermissionGranted()) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
        }
            // lantitude, latitude for current location
        LatLng Kandykabaragala = new LatLng(7.07331313915596, 80.50346320803615);
        mMap.addMarker(new MarkerOptions().position(Kandykabaragala).title("Kabaragala"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Kandykabaragala, 18.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }

    public void onSwitchMapTypeClick(View view) {
        switchMapType();
    }

    //switch between satelite view and normal view
    private void switchMapType() {
        if (mMap != null) {
            isSatelliteView = !isSatelliteView;
            mMap.setMapType(isSatelliteView ? GoogleMap.MAP_TYPE_SATELLITE : GoogleMap.MAP_TYPE_NORMAL);
        }
    }
            // check location permission granted
    private boolean isLocationPermissionGranted() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED;
    }
            // request location permission
    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_PERMISSION_CODE);
    }
}
