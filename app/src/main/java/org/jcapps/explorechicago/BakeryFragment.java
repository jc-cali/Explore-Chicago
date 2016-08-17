package org.jcapps.explorechicago;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BakeryFragment extends Fragment implements OnMapReadyCallback{
    private GoogleMap mMap;
    MapView mMapView;
    private CursorAdapter mCursorAdapter;
    Intent mDetailIntent;
    Cursor cursor;

    public BakeryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bakery, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //View rootView = inflater.inflate(R.layout.fragment_bakery, container, false);

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());

            mMapView.getMapAsync(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        Context ctx = getContext(); // singleton
        final BusinessDBHelper db = BusinessDBHelper.getInstance(ctx);


        // Create Bakery Markers List
        List<Marker> markersList = new ArrayList<Marker>();
        Marker chiuquon = mMap.addMarker(new MarkerOptions().position(new LatLng(41.851629,-87.63221999999996)).title("Chiu Quon Bakery").snippet("Click for store info"));
        Marker feida = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8520082,-87.63221999999996)).title("Feida Bakery").snippet("Click for store info"));
        Marker stanna = mMap.addMarker(new MarkerOptions().position(new LatLng(41.853549,-87.634411)).title("Saint Anna Bakery").snippet("Click for store info"));
        Marker captain = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8537,-87.634759)).title("Captain Cafe and Bakery").snippet("Click for store info"));
        Marker cafedevictoria = mMap.addMarker(new MarkerOptions().position(new LatLng(41.85661749999999,-87.63863329999998)).title("Cafe De Victoria\n(Inside Richwell Market)").snippet("Click for store info"));
        Marker dimdim = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8419362,-87.6322435)).title("Dim Dim Dim-Sum and Bakery").snippet("Click for store info"));
        Marker goldenapple = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8488125,-87.6316028)).title("Golden Apple Cafe and Bakery").snippet("Click for store info"));
        Marker sunlight = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8526102,-87.63302720000002)).title("Sunlight Cafe and Bakery").snippet("Click for store info"));
        Marker tastyplace1 = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8499357,-87.6317359)).title("Tasty Place Bakery and Cafe").snippet("Click for store info"));
        Marker tastyplace2 = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8507099,-87.63222180000002)).title("Tasty Place Bakery and Cafe").snippet("Click for store info"));

        /**Put all the markers into arraylist*/
        markersList.add(chiuquon);
        markersList.add(feida);
        markersList.add(stanna);
        markersList.add(captain);
        markersList.add(cafedevictoria);
        markersList.add(dimdim);
        markersList.add(goldenapple);
        markersList.add(sunlight);
        markersList.add(tastyplace1);
        markersList.add(tastyplace2);

        /**create for loop for get the latLngbuilder from the marker list*/
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker m : markersList) {
            builder.include(m.getPosition());
        }
        /**initialize the padding for map boundary*/
        int padding = 50;
        /**create the bounds from latlngBuilder to set into map camera*/
        LatLngBounds bounds = builder.build();
        /**create the camera with bounds and padding to set into map*/
        final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        /**call the map call back to know map is loaded or not*/
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                /**set animated zoom camera into map*/
                mMap.animateCamera(cu);

            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getActivity(),
                    "Click marker for directions icon on lower right corner ",
                    Toast.LENGTH_SHORT).show();
                mMap.moveCamera(CameraUpdateFactory.zoomTo(20));
//                mMap.animateCamera(CameraUpdateFactory.newLatLng(marker.getPosition()));
                return false;
            }
        });

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Double latitude = marker.getPosition().latitude;
                Double longitude = marker.getPosition().longitude;
//                Toast.makeText(getActivity(),
//                        marker.getTitle() + "\n" + marker.getSnippet(),
//                        Toast.LENGTH_LONG).show();

                cursor = db.getmarkerInfo(String.valueOf(latitude) + "," + String.valueOf(longitude));

                if(cursor!=null) {
                    cursor.moveToFirst();

                    mDetailIntent = new Intent(getActivity(), DetailActivity.class);

                    String name = cursor.getString(cursor.getColumnIndex("NAME"));
                    String address = cursor.getString(cursor.getColumnIndex("ADDRESS"));
                    String city = cursor.getString(cursor.getColumnIndex("CITY"));
                    String state = cursor.getString(cursor.getColumnIndex("STATE"));
                    String zip = cursor.getString(cursor.getColumnIndex("ZIP"));
                    String phone = cursor.getString(cursor.getColumnIndex("PHONE"));
                    String hours = cursor.getString(cursor.getColumnIndex("HOURS"));
                    String web = cursor.getString(cursor.getColumnIndex("WEB"));


//                    Bundle bundle=new Bundle();
//                    bundle.putString("NAME", name);
//                    //set Fragmentclass Arguments
//                    DetailFragment fragobj=new DetailFragment();
//                    fragobj.setArguments(bundle);

                    mDetailIntent.putExtra("NAME", name);
                    mDetailIntent.putExtra("ADDRESS", address);
                    mDetailIntent.putExtra("CITY", city);
                    mDetailIntent.putExtra("STATE", state);
                    mDetailIntent.putExtra("ZIP", zip);
                    mDetailIntent.putExtra("PHONE", phone);
                    mDetailIntent.putExtra("HOURS", hours);
                    mDetailIntent.putExtra("WEB", web);
                    startActivity(mDetailIntent);
                }
                cursor.close();
            }
        });

    }

}

