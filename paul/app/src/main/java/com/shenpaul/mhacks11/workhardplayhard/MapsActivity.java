package com.shenpaul.mhacks11.workhardplayhard;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback{

    //    private static final int REQUEST_INVITE = 1;
    private GoogleMap mMap;
    private Button mButton;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

//        setSupportActionBar(toolbar);
//        ActionBar actionbar = getSupportActionBar();
//        actionbar.setDisplayHomeAsUpEnabled(true);
//        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        switch (menuItem.getItemId()) {
                            case R.id.navigation_menu:
                                Intent mIntent = new Intent(MapsActivity.this, MenuActivity.class);
                                MapsActivity.this.onPause();
                                onWindowFocusChanged(false);
                                startActivity(mIntent);
                                System.out.print("menu" + "YES");
                                return true;
                            case R.id.navigation_map:
                                if (MapsActivity.this.getCurrentFocus() == null) {
                                    MapsActivity.this.onResume();
                                }
                                return true;
                            case R.id.navigation_photos:
//                        Intent myIntent = new Intent(MapsActivity.this, PhotosActivity.class);
//                        MapsActivity.this.onPause();
//                        onWindowFocusChanged(false);
//                        startActivity(mIntent);
                                return true;
                            default:
                                return true;
                        }
                    }
                }
        );

//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(
//                new NavigationView.OnNavigationItemSelectedListener() {
//                    public boolean onNavigationItemSelected(MenuItem menuItem) {
//
//                        // set item as selected to persist highlight
//                        menuItem.setChecked(true);
//
//                        // close drawer when item is tapped
//                        mDrawerLayout.closeDrawers();
//
//                        switch (menuItem.getItemId()) {
//                            case R.id.invite_menu:
//                                sendInvitation();
//                                return true;
//                            case R.id.crash_menu:
//                                Log.w("Crashlytics", "Crash button clicked!");
//                                causeCrash();
//                                return true;
//                            case R.id.sign_out_menu:
//                                Intent myIntent = new Intent(MapsActivity.this, MenuActivity.class);
////                                com.shenpaul.mhacks11.workhardplayhard.MainActivity.mFirebaseAuth.signOut();
////                                Auth.GoogleSignInApi.signOut(com.shenpaul.mhacks11.workhardplayhard.MainActivity.mGoogleApiClient);
////                                com.shenpaul.mhacks11.workhardplayhard.MainActivity.mFirebaseUser = null;
////                                com.shenpaul.mhacks11.workhardplayhard.MainActivity.mUsername = com.shenpaul.mhacks11.workhardplayhard.MainActivity.ANONYMOUS;
////                                com.shenpaul.mhacks11.workhardplayhard.MainActivity.mPhotoUrl = null;
////
////                                AlertDialog alertDialog = new AlertDialog.Builder(com.shenpaul.mhacks11.workhardplayhard.MapsActivity.this).create();
////                                alertDialog.setTitle("Alert");
////                                alertDialog.setMessage("You have successfully signed out!");
////                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
////                                        new DialogInterface.OnClickListener() {
////                                            public void onClick(DialogInterface dialog, int which) {
////                                                dialog.dismiss();
////                                                System.exit(0);
////                                            }
////                                        });
////                                alertDialog.show();
//                                return true;
//                            default:
//                                return true;
//                        }
//                    }
//                }
//        );

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mButton = (Button)(findViewById(R.id.button));
//        mButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                System.out.println("hello");
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    private void causeCrash() {
//        throw new NullPointerException("Fake null pointer exception");
//    }
//
//    private void sendInvitation() {
//        Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
//                .setMessage(getString(R.string.invitation_message))
//                .setCallToActionText(getString(R.string.invitation_cta))
//                .build();
//        startActivityForResult(intent, REQUEST_INVITE);
//    }

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
        //REPLACE WITH CUSTOM PROGRAM ONCE DONE
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
