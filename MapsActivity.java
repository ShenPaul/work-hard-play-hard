package com.example.jazzyw.whph;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Button mFirebaseBtn;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFirebaseBtn = (Button) findViewById(R.id.firebase_btn);

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

        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {

            final Double[] latitu = {0.0};
            final Double[] longitu = {0.0};
            //final List<ArrayList<LatLng>> coordinates_list = new ArrayList<ArrayList<LatLng>>();

            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

            @Override
            public void onClick(View v) {
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //for (int i = 0; i < 5000; i = i + 1000) {
                            DataSnapshot e = dataSnapshot.child("0");

                            DataSnapshot start = e.child("start_coordinates:");
                            latitu[0] = ((Double) start.child("1").getValue());
                            longitu[0] = ((Double) start.child("0").getValue());

                            LatLng coordinate = new LatLng(latitu[0], longitu[0]);

                            mMap.addMarker(new MarkerOptions()
                                .position(coordinate)
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));

                            DataSnapshot end = e.child("end_coordinates");
                            latitu[0] = ((Double) start.child("1").getValue());
                            longitu[0] = ((Double) start.child("0").getValue());

                            coordinate = new LatLng(latitu[0], longitu[0]);

                            mMap.addMarker(new MarkerOptions()
                                .position(coordinate)
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));
                            /*
                            ArrayList<LatLng> coordinates = new ArrayList<LatLng>();
                            for (DataSnapshot f : e.child("geometry").child("coordinates").getChildren()) {
                                coordinates.add(new LatLng((Double) f.child("1").getValue(), (Double) f.child("0").getValue()));
                            }

                            coordinates_list.add(coordinates);

                            for (int j = 0; j < coordinates.size() - 1; j++) {
                            LatLng src = coordinates.get(j);
                            LatLng dest = coordinates.get(j + 1);

                            mMap.addPolyline(new PolylineOptions().add(src, dest)
                                        .width(10)
                                        .color(Color.GREEN)

                            );*/
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Log.w("Exception FB", databaseError.toException());
                        }
                    });

                }
                /*
                for (int i = 0; i < 2; i++) {
                    LatLng coordinate = new LatLng(latitu_start.get(i), longitu_start.get(i));

                    mMap.addMarker(new MarkerOptions()
                            .position(coordinate)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));

                    coordinate = new LatLng(latitu_end.get(i), longitu_end.get(i));

                    mMap.addMarker(new MarkerOptions()
                            .position(coordinate)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));

                    for (int j = 0; j < coordinates_list.get(i).size() - 1; j++) {
                        LatLng src = coordinates_list.get(i).get(j);
                        LatLng dest = coordinates_list.get(i).get(j + 1);

                        mMap.addPolyline(new PolylineOptions().add(src, dest)
                                .width(10)
                                .color(Color.GREEN)

                        );
                    }
                }*/
            });
        }
    }
/*
         LatLng coordinate = new LatLng(latitu[0], longitu[0]);
           mMap.addMarker(new MarkerOptions()
                   .position(coordinate)
                   .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));
          //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

          //LatLng temp_coord = new LatLng(latitu[20], longitu[-90]);
          mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 0));


        LatLng point_one = new LatLng(39.435857, -81.224072);
        mMap.addMarker(new MarkerOptions()
                .position(point_one)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

        LatLng pointtwo = new LatLng(39.437109, -81.225626);
        mMap.addMarker(new MarkerOptions()
                .position(pointtwo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.forest)));

        mMap.addPolyline(new PolylineOptions().add(
                point_one,
                new LatLng(39.4365, -81.2244),
                new LatLng(39.4367, -81.2248),
                pointtwo
                )
                        .width(10)
                        .color(Color.GREEN)

        );

        LatLng next_point = new LatLng(46.304734, -75.255869);
        mMap.addMarker(new MarkerOptions()
                .position(point_one)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));

        LatLng end_point = new LatLng(46.307623, -75.250209);
        mMap.addMarker(new MarkerOptions()
                .position(pointtwo)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.road)));

        mMap.addPolyline(new PolylineOptions().add(
                next_point,
                new LatLng(46.3056, -75.25456),
                new LatLng(46.3068, -75.25342),
                end_point
                )
                    .width(10)
                    .color(Color.BLACK)

        );*/


        // forest = forest --green
        // desert = desert123 --yellow
        // mountains = mountains123 --red
        // road = road123 --black
        // snow = snow123 --blue

