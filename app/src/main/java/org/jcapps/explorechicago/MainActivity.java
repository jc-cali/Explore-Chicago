package org.jcapps.explorechicago;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    Intent mBakeryIntent;
    BusinessDBHelper db;
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = BusinessDBHelper.getInstance(this);

        importDb();

        image = (ImageView) findViewById(R.id.image_main);
        image.setImageResource(R.drawable.chinatownsign);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Pushing MapView Fragment
//        Fragment fragment = Fragment.instantiate(this, BakeryFragment.class.getName());
//        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.fragment_container, fragment);
//        ft.commit();


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bakery) {
            image.setImageDrawable(null);
            Fragment fragment = Fragment.instantiate(this, BakeryFragment.class.getName());
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } //else if (id == R.id.nav_share) {

//        } else if (id == R.id.nav_send) {

//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void importDb() {

        // import Bakery Businesses
        db.insertBusiness("Bakery", "Chiu Quon Bakery", "2242 S. Wentworth Ave.",  "Chicago", "IL", "60616", "(312) 225-6608", "Hours: M-Su 7am-9:30pm", "www.cqbakery.com");
        db.insertBusiness("Bakery", "Feida Bakery", "2228 S. Wentworth Ave",  "Chicago", "IL", "60616", "(312) 808-1113", "Hours: M-Su 7am-9pm", null);
        db.insertBusiness("Bakery", "Saint Anna Bakery and Cafe", "2158 S. Archer Ave.",  "Chicago", "IL", "60616", "(312) 225-3168", "Hours: M-Su 8am-8pm", null);
        db.insertBusiness("Bakery", "Captain Cafe and Bakery", "2161A S. China Place",  "Chicago", "IL", "60616", "(312) 791-0888", "Hours: M-Su 7:30am-8:30pm", null);
        db.insertBusiness("Bakery", "Cafe De Victoria (inside Richwell Market)", "1835 S. Canal Street",  "Chicago", "IL", "60616", "(312) 492-7030", "Hours: M-Su 9am-8pm", null);
        db.insertBusiness("Bakery", "Dim Dim Dim-Sum and Bakery", "2820 S. Wentworth Ave.",  "Chicago", "IL", "60616", "(312) 842-2822", "Hours: M-Su 7:30am-9:30pm", "www.locu.com");
        db.insertBusiness("Bakery", "Golden Apple Cafe and Bakery", "2409 S. Wentworth Ave.",  "Chicago", "IL", "60616", "(312) 842-6888", "Hours: M-Su 7am-6pm", null);
        db.insertBusiness("Bakery", "Sunlight Cafe and Bakery", "227 W. Cermak Road",  "Chicago", "IL", "60616", "(312) 674-1368", "Hours: M-Su 7am-8pm", "www.sunlightcafechicago.com");
        db.insertBusiness("Bakery", "Tasty Place Bakery and Cafe", "2339A S. Wentworth Ave.",  "Chicago", "IL", "60616", "(312) 225-5678", "Hours: M-Su 7:30am-10pm", null);
        db.insertBusiness("Bakery", "Tasty Place Bakery and Cafe", "2306 S. Wentworth Ave.",  "Chicago", "IL", "60616", "(312) 842-8802", "Hours: M-Su 7:30am-10pm", null);

    }

}
