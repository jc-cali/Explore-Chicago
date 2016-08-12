package org.jcapps.explorechicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {

    TextView mName, mAddress, mCity, mState, mZip, mPhone, mWeb;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mName = (TextView) findViewById(R.id.tv_det_name);
        mAddress = (TextView) findViewById(R.id.tv_det_address);
        mCity = (TextView) findViewById(R.id.tv_det_city);
        mPhone = (TextView) findViewById(R.id.tv_det_phone);
        mWeb = (TextView) findViewById(R.id.tv_det_web);

        mImage = (ImageView) findViewById(R.id.iv_det_image);

        Restaurant restaurant = (Restaurant) getIntent().getSerializableExtra("RESTAURANT");

        mName.setText(restaurant.name);
        mCategories.setText(restaurant.categories);
        mSnippetText.setText(restaurant.snippetText);
        mAddress.setText(restaurant.address);
        mPhone.setText(restaurant.phone);
        mReviews.setText(String.format(Locale.ENGLISH, "%d reviews", restaurant.reviewCount));
        mDistance.setText(String.format(Locale.ENGLISH, "%.0f m", restaurant.distance));

        Picasso.with(this).load(restaurant.image).placeholder(R.drawable.ghost).resize(300,300).into(mImage);

    }
}