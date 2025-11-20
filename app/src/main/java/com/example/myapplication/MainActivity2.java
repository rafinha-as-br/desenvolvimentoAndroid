package com.example.myapplication;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MainActivity2 extends AppCompatActivity{

    LocationManager locationManager;
    TextView textView;

    MapView mapView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mapView = findViewById(R.id.mapView);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(v-> getLocation());
    }

    @SuppressLint("SetTextI18n")
    public void getLocation(){

        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            requestPermission();
            return;
        }
        //Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0, location1 -> {
            double latitude = location1.getLatitude();
            double longitude = location1.getLongitude();
            textView.setText("longitude: " + latitude + " Longitude: " + longitude);
            showLocationOnMap(latitude, longitude);
        });

//        if(location != null){
//            double latitude = location.getLatitude();
//            double longitude = location.getLongitude();
//            textView.setText("longitude: " + latitude + " Longitude: " + longitude);
//        } else{
//            textView.setText(" A");
//        }

    }

    public void showLocationOnMap(double latitude, double longitude){
        GeoPoint userLocation = new GeoPoint(latitude, longitude);
        mapView.getController().setCenter(userLocation);
        mapView.getController().setZoom(15.0);
        mapView.invalidate();


    }

    public void requestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            requestPermissions(
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1
                    );
        }
    }



}