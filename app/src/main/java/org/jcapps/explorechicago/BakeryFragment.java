package org.jcapps.explorechicago;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

//        Context ctx = getContext(); // singleton
//        BusinessDBHelper db = BusinessDBHelper.getInstance(ctx);

//        cursor = db.getBakeryList();
//        try {
//            while (cursor.moveToNext()) {
//                String namecode = cursor.getString(cursor.getColumnIndex("NAMECODE"));
//                Double latitude = Double.parseDouble(cursor.getString(cursor.getColumnIndex("LATITUDE")));
//                Double longitude = Double.parseDouble(cursor.getString(cursor.getColumnIndex("LONGITUDE")));
//                String name = cursor.getString(cursor.getColumnIndex("NAME"));
//                String address = cursor.getString(cursor.getColumnIndex("ADDRESS"));
//                String city = cursor.getString(cursor.getColumnIndex("CITY"));
//                String state = cursor.getString(cursor.getColumnIndex("STATE"));
//                String zip = cursor.getString(cursor.getColumnIndex("ZIP"));
//                String phone = cursor.getString(cursor.getColumnIndex("PHONE"));
//                String hours = cursor.getString(cursor.getColumnIndex("HOURS"));
//                String web = cursor.getString(cursor.getColumnIndex("WEB"));
//
//                // Create Bakery Markers List
//                Marker chiuquon = mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(name).snippet(address + "\n" + city + ", " + state + " " + zip + "\n" + phone + "\n" + hours + "\n" + web));
//
//                /**Put all the markers into arraylist*/
//                markersList.add(namecode);
//
//            }
//        } finally {
//            cursor.close();
//        }

        // Create Bakery Markers List
        List<Marker> markersList = new ArrayList<Marker>();
        Marker chiuquon = mMap.addMarker(new MarkerOptions().position(new LatLng(41.851629, -87.63221999999996)).title("Chiu Quon Bakery").snippet("2242 S. Wentworth Ave.\nChicago, IL 60616\n(312) 225-6608\nHours M-Su 7am-9:30pm\nwww.bakery.com"));
        Marker feida = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8520082, -87.63221999999996)).title("Feida Bakery").snippet("2228 S. Wentworth Ave.\nChicago, IL 60616\n(312) 808-1113\nHours M-Su 7am-9pm"));
        Marker stanna = mMap.addMarker(new MarkerOptions().position(new LatLng(41.853549, -87.634411)).title("Saint Anna Bakery").snippet("2158 S Archer Ave.\nChicago, IL 60616\n(312) 225-3168\nHours: M-Su 8am-8pm"));
        Marker captain = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8537, -87.634759)).title("Captain Cafe and Bakery").snippet("2161A S. China Place\nChicago, IL 60616\n(312) 791-0888\nHours: M-Su 7:30am-8:30pm"));
        Marker cafedevictoria = mMap.addMarker(new MarkerOptions().position(new LatLng(41.85661749999999, -87.63863329999998)).title("Cafe De Victoria\n(Inside Richwell Market)").snippet("1835 S. Canal Street\nChicago, IL 60616\n(312) 492-7030\nHours: M-Su 9am-8pm"));
        Marker dimdim = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8419362, -87.6322435)).title("Dim Dim Dim-Sum and Bakery").snippet("2820 S. Wentworth Ave.\nChicago, IL 60616\n(312) 842-2822\nHours: M-Su 7:30am-9:30pm\nwww.locu.com"));
        Marker goldenapple = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8488125, -87.6316028)).title("Golden Apple Cafe and Bakery").snippet("2409 S. Wentworth\nChicago, IL 60616\n(312) 842-6888\nHours: M-Su 7am-6pm"));
        Marker sunlight = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8526102, -87.63302720000002)).title("Sunlight Cafe and Bakery").snippet("227 W. Cermak Road\nChicago, IL 60616\n(312) 674-1368\nHours: M-Su 7am-8pm\n www.sunlightcafechicago.com"));
        Marker tastyplace1 = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8499357, -87.6317359)).title("Tasty Place Bakery and Cafe").snippet("2339A S. Wentworth Ave.\nChicago, IL 60616\n(312) 225-5678\nHours: M-Su 7:30am-10pm"));
        Marker tastyplace2 = mMap.addMarker(new MarkerOptions().position(new LatLng(41.8507099, -87.63222180000002)).title("Tasty Place Bakery and Cafe").snippet("2306 S. Wentworth Ave.\nChicago, IL 60616\n(312) 842-8802\nHours: M-Su 7:30am-10pm"));

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
                Toast.makeText(getActivity(),
                        marker.getTitle() + "\n" + marker.getSnippet(),
                        Toast.LENGTH_LONG).show();


//                // get your custom_toast.xml ayout
//                LayoutInflater inflater = getLayoutInflater();
//                View layout = inflater.inflate(R.layout.custom_toast,
//                        (ViewGroup) layout.findViewById(R.id.custom_toast_container));
//
//                // set a dummy image
//                ImageView image = (ImageView) layout.findViewById(R.id.image);
//                image.setImageResource(R.drawable.dragon);
//
//                // set a message
//                TextView text = (TextView) layout.findViewById(R.id.text);
//                text.setText("Button is clicked!");
//
//                // Toast...
//                Toast toast = new Toast(getActivity());
//                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
//                toast.setDuration(Toast.LENGTH_LONG);
//                toast.setView(layout);
//                toast.show();
//

            }
        });

    }
}

