package org.jcapps.explorechicago;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    TextView mTxtName, mTxtAddress, mTxtCity, mTxtState, mTxtZip, mTxtPhone, mTxtHours, mTxtWeb;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTxtName = (TextView) findViewById(R.id.tv_det_name);
        mTxtAddress = (TextView) findViewById(R.id.tv_det_address);
        mTxtCity = (TextView) findViewById(R.id.tv_det_city);
        mTxtPhone = (TextView) findViewById(R.id.tv_det_phone);
        mTxtHours = (TextView) findViewById(R.id.tv_det_hours);
        mTxtWeb = (TextView) findViewById(R.id.tv_det_web);

        mImage = (ImageView) findViewById(R.id.iv_det_image);

        Intent markerIntent = getIntent();
        String name = markerIntent.getStringExtra("NAME");
        String address = markerIntent.getStringExtra("ADDRESS");
        String city = markerIntent.getStringExtra("CITY");
        String state = markerIntent.getStringExtra("STATE");
        String zip = markerIntent.getStringExtra("ZIP");
        String phone = markerIntent.getStringExtra("PHONE");
        String hours = markerIntent.getStringExtra("HOURS");
        String web = markerIntent.getStringExtra("WEB");
        String storeimage = markerIntent.getStringExtra("IMAGE");

        int id = getResources().getIdentifier("org.jcapps.explorechicago:drawable/" + storeimage, null, null);
        //mImage.setImageResource(id);
        Picasso.with(getApplicationContext()).load(id).resize(1315,900).centerCrop().into(mImage);

        mTxtName.setText(name);
        mTxtAddress.setText(address);
        mTxtCity.setText(city + ", " + state + " " + zip);
        mTxtPhone.setText(phone);
        mTxtHours.setText(hours);
        mTxtWeb.setText(web);

//
//        Picasso.with(this).load(restaurant.image).placeholder(R.drawable.ghost).resize(300,300).into(mImage);

    }
}