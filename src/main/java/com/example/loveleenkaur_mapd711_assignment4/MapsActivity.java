package com.example.loveleenkaur_mapd711_assignment4;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String selectedLocation;

    Button geocode;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Intent intent = getIntent();

        String brandName = intent.getStringExtra("Brand");

        String message = "Stores for '"+ brandName + "'";

        // set text of title for map activity
        textView = (TextView)findViewById(R.id.textView2);
        textView.setText(message);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        locationManger = (LocationManager) getSystemService(LOCATION_SERVICE);
//        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    Activity#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for Activity#requestPermissions for more details.
//            return;
//        }
//
//        if(locationManger.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//            locationManger.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//                    // get the latitude
//                    double latitude = location.getLatitude();
//
//                    // get the longitude
//                    double longitude = location.getLongitude();
//
//                    // instantiate the class, Latlng
//                    LatLng latLng = new LatLng(latitude, longitude);
//
//                    // instantiate the class, Geocoder
//                    Geocoder geocoder = new Geocoder(getApplicationContext());
//
//                    try {
//                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
//
//                        String str = addressList.get(0).getLocality()+",";
//                        str += addressList.get(0).getCountryName();
//
//                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
//                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String provider) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String provider) {
//
//                }
//            });
//        }
//
//        else if (locationManger.isProviderEnabled(LocationManager.GPS_PROVIDER)){
//            locationManger.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(Location location) {
//                    // get the latitude
//                    double latitude = location.getLatitude();
//
//                    // get the longitude
//                    double longitude = location.getLongitude();
//
//                    // instantiate the class, Latlng
//                    LatLng latLng = new LatLng(latitude, longitude);
//
//                    // instantiate the class, Geocoder
//                    Geocoder geocoder = new Geocoder(getApplicationContext());
//
//                    try {
//                        List<Address> addressList = geocoder.getFromLocation(latitude, longitude, 1);
//
//                        String str = addressList.get(0).getLocality()+",";
//                        str += addressList.get(0).getCountryName();
//
//                        mMap.addMarker(new MarkerOptions().position(latLng).title(str));
//                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10.2f));
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
//
//                }
//
//                @Override
//                public void onStatusChanged(String provider, int status, Bundle extras) {
//
//                }
//
//                @Override
//                public void onProviderEnabled(String provider) {
//
//                }
//
//                @Override
//                public void onProviderDisabled(String provider) {
//
//                }
//            });
//        }

    }

    // get specific location name and find the relative store location in that area
    public void getLocationName(View v) {

        Intent intent = getIntent();

        final String brandName = intent.getStringExtra("Brand");

        Toast toast ;
        switch (v.getId()) {
            case R.id.B_Scarborough:
                selectedLocation = "Scarborough";
                geocode = findViewById(R.id.B_Scarborough);
                toast = Toast.makeText(getApplicationContext(),brandName + " Stores in Scarborough" ,
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 300);
                toast.show();
                break;
            case R.id.B_Oakville:
                selectedLocation = "Oakville";
                geocode = findViewById(R.id.B_Oakville);

                toast = Toast.makeText(getApplicationContext(),brandName + " Stores in Oakville" ,
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 300);
                toast.show();
                break;
            case R.id.B_DownTown:
                selectedLocation = "Toronto Downtown";
                geocode = findViewById(R.id.B_DownTown);

                toast = Toast.makeText(getApplicationContext(),brandName + " Stores in Toronto DownTown" ,
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 300);
                toast.show();
                break;
            case R.id.B_NorthYork:
                selectedLocation = "NorthYork";
                geocode = findViewById(R.id.B_NorthYork);

                toast = Toast.makeText(getApplicationContext(),brandName + " Stores in North York" ,
                        Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 300);
                toast.show();
                break;
        }

        final Geocoder coder = new Geocoder(getApplicationContext());

        String placeName = brandName + " " + selectedLocation;

        // clear previous map marker
        mMap.clear();

        // show relative current location
        LatLng my_location = new LatLng(43.785464, -79.226620);
        mMap.addMarker(new MarkerOptions().position(my_location).title("Centennial College").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("current_location",140,140))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(my_location, 10.2f));

        try {
            //using geocoder object getting maximum 5 addresses for given place name / address
            List<Address> geocodeResults = coder.getFromLocationName(placeName, 3);
            Iterator<Address> locations = geocodeResults.iterator();

            // get location names and relative addrress and show them on google map
            String locInfo = "";
            while (locations.hasNext()) {
                Address loc = locations.next();

                LatLng store = new LatLng(loc.getLatitude(), loc.getLongitude());
                int addIdx = loc.getMaxAddressLineIndex();
                for (int idx = 0; idx <= addIdx; idx++)
                {
                    String addLine = loc.getAddressLine(idx);
                    locInfo = String.format("%s", addLine);
                }
                mMap.addMarker(new MarkerOptions().position(store).title(brandName +", "+ locInfo));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(store, 10.2f));

            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Failed to get location info " +e,Toast.LENGTH_LONG).show();
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

         //Add a marker in current location and move the camera
        LatLng my_location = new LatLng(43.785464, -79.226620);
        mMap.addMarker(new MarkerOptions().position(my_location).title("Centennial College").icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("current_location",140,140))));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(my_location, 10.2f));

    }

    // function for setting the icon size for current location
    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    // function for zoom in / zoom out the google map
    public void onZoom(View view){
        if(view.getId() == R.id.ZoomIn){
            mMap.animateCamera(CameraUpdateFactory.zoomIn());
        }else if(view.getId() == R.id.ZoomOut){
            mMap.animateCamera(CameraUpdateFactory.zoomOut());
        }
    }

    // function for switching between normal view and satellite view
    public void satView(View view){
        Toast toast;
        if(mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL){
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            toast = Toast.makeText(getApplicationContext(),"Switching to Satellite Map View" ,
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 300);
            toast.show();
        }else if(mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE){
            toast = Toast.makeText(getApplicationContext(),"Switching to Standard Map View" ,
                    Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM | Gravity.BOTTOM, 0, 300);
            toast.show();
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }
}
