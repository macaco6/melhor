package com.example.tela;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng Goldeplaca = new LatLng(-29.736344, -51.148981);
        LatLng alegrete = new LatLng(-29.790105, -55.794012);
        LatLng novegral = new LatLng(-26.960046, -53.638057);
        LatLng triangle = new LatLng(-28.738795, -53.517749);

        mMap.addMarker(new MarkerOptions().position(triangle).title("TRIANGULO DaS BERMUDAS"));
        mMap.addMarker(new MarkerOptions().position(novegral).title("90º"));
        mMap.addMarker(new MarkerOptions().position(alegrete).title("ONDE FICA O ALEGRETE? FICA AQUI O ALEGRETE!"));
        mMap.addMarker(new MarkerOptions().position(Goldeplaca).title("CACHAÇA a BORDO"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Goldeplaca));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(alegrete));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(novegral));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(triangle));


        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Goldeplaca, 12.0f));

        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.addPolyline(new PolylineOptions().add(Goldeplaca,alegrete,novegral, Goldeplaca)
                .width(5)
                .color(Color.BLACK));
    }
}

