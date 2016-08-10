package org.jcapps.explorechicago;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public BakeryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        @Override
//        public void onMapReady(GoogleMap googleMap) {
//            mMap = googleMap;
       // SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
         //       .findFragmentById(R.id.map);
//        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);


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

        // Create Bakery Markers List
        List<Marker> markersList = new ArrayList<Marker>();
        Marker chiuquon = mMap.addMarker(new MarkerOptions().position(new LatLng(41.851629, -87.63221999999996)).title("Chiu Quon Bakery").snippet("2242 S. Wentworth Ave."));
        Marker feida = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8520082, -87.63221999999996)).title("Mui's Feida Bakery").snippet("2228 S. Wentworth Ave."));
        Marker stanna = mMap.addMarker(new MarkerOptions().position(new LatLng(41.853549, -87.634411)).title("Saint Anna Bakery").snippet("2158 S Archer Ave."));
        Marker captain = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8537, -87.634759)).title("Captain Cafe and Bakery").snippet("2161A S. China Place"));
        Marker cafedevictoria = mMap.addMarker(new MarkerOptions().position(new LatLng(41.85661749999999, -87.63863329999998)).title("Cafe De Victoria").snippet("1835 S. Canal Street"));
        Marker dimdim = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8419362, -87.6322435)).title("Dim Dim Dim-Sum and Bakery").snippet("2820 S. Wentworth Ave."));
        Marker goldenapple = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8488125, -87.6316028)).title("Golden Apple Cafe and Bakery").snippet("2409 S. Wentworth"));
        Marker sunlight = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8526102, -87.63302720000002)).title("Sunlight Cafe and Bakery").snippet("227 W. Cermak Road"));
        Marker tastyplace1 = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8499357, -87.6317359)).title("Tasty Place Bakery and Cafe").snippet("2339A S. Wentworth Ave."));
        Marker tastyplace2 = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8507099, -87.63222180000002)).title("Tasty Place Bakery and Cafe").snippet("2306 S. Wentworth Ave."));

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
            public boolean onMarkerClick(Marker marker) {Toast.makeText(getActivity(),
                    marker.getTitle() + " : " + marker.getSnippet(),
                    Toast.LENGTH_LONG).show();
                mMap.moveCamera(CameraUpdateFactory.zoomTo(20));
                return false;
            }
        });
    }
}

