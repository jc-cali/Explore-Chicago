package org.jcapps.explorechicago;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    TextView mTxtName, mTxtAddress, mTxtCity, mTxtState, mTxtZip, mTxtPhone, mTxtHours, mTxtWeb;
    ImageView mImage;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View detailFragment =  inflater.inflate(R.layout.fragment_detail, container, false);

        mTxtName = (TextView) detailFragment.findViewById(R.id.tv_det_name);
//        mTxtAddress = (TextView) detailFragment.findViewById(R.id.tv_det_address);
//        mTxtCity = (TextView) detailFragment.findViewById(R.id.tv_det_city);
//        mTxtPhone = (TextView) detailFragment.findViewById(R.id.tv_det_phone);
//        mTxtHours = (TextView) detailFragment.findViewById(R.id.tv_det_hours);
//        mTxtWeb = (TextView) detailFragment.findViewById(R.id.tv_det_web);
//
//        mImage = (ImageView) detailFragment.findViewById(R.id.iv_det_image);

        //Intent markerIntent = getIntent();
        Bundle bundle = this.getArguments();
        String name = bundle.getString("NAME");
        //String name=getArguments().getString("NAME");
//        String name = markerIntent.getStringExtra("NAME");
//        String address = markerIntent.getStringExtra("ADDRESS");
//        String city = markerIntent.getStringExtra("CITY");
//        String state = markerIntent.getStringExtra("STATE");
//        String zip = markerIntent.getStringExtra("ZIP");
//        String phone = markerIntent.getStringExtra("PHONE");
//        String hours = markerIntent.getStringExtra("HOURS");
//        String web = markerIntent.getStringExtra("WEB");



        mTxtName.setText(name);
//        mTxtAddress.setText(address);
//        mTxtCity.setText(city + ", " + state + " " + zip);
//        mTxtPhone.setText(phone);
//        mTxtHours.setText(hours);
//        mTxtWeb.setText(web);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

}
