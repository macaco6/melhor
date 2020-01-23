package com.example.tela;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private DrawerLayout drawer;
    private static final String[] LOCATION_PERMS = {
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private static final int INITIAL_REQUEST = 1337;
    private static final int LOCATION_REQUEST = INITIAL_REQUEST + 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng Goldeplaca = new LatLng(-28.905395, -51.219668);
        LatLng alegrete = new LatLng(-29.790105, -55.794012);
        LatLng novegral = new LatLng(-26.960046, -53.638057);
        LatLng triangle = new LatLng(-28.738795, -53.517749);

        mMap.addMarker(new MarkerOptions().position(triangle).title("1 charezard foi encontrado").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.poke1)));
        mMap.addMarker(new MarkerOptions().position(novegral).title("90º").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.poke2)));
        mMap.addMarker(new MarkerOptions().position(alegrete).title("ONDE FICA O ALEGRETE? FICA AQUI O ALEGRETE!").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.poke2)));
        mMap.addMarker(new MarkerOptions().position(Goldeplaca).title("CACHAÇA a BORDO").icon(
                BitmapDescriptorFactory.fromResource(R.drawable.poke2)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Goldeplaca));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(alegrete));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(novegral));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(triangle));


        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Goldeplaca, 12.0f));

        mMap.getUiSettings().setZoomControlsEnabled(true);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)

            mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
    } else{



        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
            requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);


            mMap.addPolyline(new PolylineOptions().add(Goldeplaca, alegrete, novegral, Goldeplaca)
                    .width(5)
                    .color(Color.BLACK));

            mMap.addCircle(
                    new CircleOptions()
                            .center(triangle)
                            .radius(15280.0)
                            .strokeWidth(3f)
                            .strokeColor(Color.RED)
                            .fillColor(Color.argb(70, 150, 50, 50)));


        }

    }

}

