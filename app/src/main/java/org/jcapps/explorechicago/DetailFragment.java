package org.jcapps.explorechicago;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


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
        mTxtAddress = (TextView) detailFragment.findViewById(R.id.tv_det_address);
        mTxtCity = (TextView) detailFragment.findViewById(R.id.tv_det_city);
        mTxtPhone = (TextView) detailFragment.findViewById(R.id.tv_det_phone);
        mTxtHours = (TextView) detailFragment.findViewById(R.id.tv_det_hours);
        mTxtWeb = (TextView) detailFragment.findViewById(R.id.tv_det_web);

        mImage = (ImageView) detailFragment.findViewById(R.id.iv_det_image);

        //Intent markerIntent = getIntent();
        Bundle bundle = this.getArguments();
        String name = bundle.getString("NAME");
        String address = bundle.getString("ADDRESS");
        String city = bundle.getString("CITY");
        String state = bundle.getString("STATE");
        String zip = bundle.getString("ZIP");
        String phone = bundle.getString("PHONE");
        String hours = bundle.getString("HOURS");
        String web = bundle.getString("WEB");
        String storeimage = bundle.getString("IMAGE");

        int id = getResources().getIdentifier("org.jcapps.explorechicago:drawable/" + storeimage, null, null);
        Picasso.with(getContext()).load(id).resize(1315,900).centerCrop().into(mImage);


        mTxtName.setText(name);
        mTxtAddress.setText(address);
        mTxtCity.setText(city + ", " + state + " " + zip);
        mTxtPhone.setText(phone);
        mTxtHours.setText(hours);
        mTxtWeb.setText(web);

        // Inflate the layout for this fragment
        return detailFragment;
    }

}
