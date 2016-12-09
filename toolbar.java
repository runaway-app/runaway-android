package com.example.app.testcards;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class toolbar extends AppCompatActivity {
    Toolbar toolbar;
    private String f,n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        final TextView tv = (TextView) findViewById(R.id.textView2);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbarfrag);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setTitle("Runaway");
        final String[] colors = {"#96CC7A", "#EA705D", "#66BBCC", "#994477"};

        final frag fragment = new frag();
        Bundle bundle = new Bundle();
        bundle.putInt("color", Color.parseColor(colors[0]));
        fragment.setArguments(bundle);

        //Use to swap fragment!
//        NewFragment newFragment = new NewFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame, newFragment, fragment.getClass().getName()).commit();

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragment, "square").commit();
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("", R.drawable.ic_favorite_white_24dp, Color.parseColor(colors[0]));
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("", R.drawable.ic_local_dining_white_24dp, Color.parseColor(colors[1]));
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("", R.drawable.account, Color.parseColor(colors[2]));
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("", R.drawable.ic_location_on_white_24dp, Color.parseColor("#994477"));

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

        //  Enables Reveal effect
        bottomNavigation.setColored(true);
        bottomNavigation.setCurrentItem(0);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                if(position==1){
                    newFoldingCards newFragment = new newFoldingCards();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, newFragment, fragment.getClass().getName()).commit();
                }
                else if(position==0){
                    frag newFragment = new frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, newFragment, fragment.getClass().getName()).commit();
                }
                else if(position == 2){
                    profileFrag newF = new profileFrag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, newF, fragment.getClass().getName()).commit();
                }
                else if(position == 3){
                    frag newFragment = new frag();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, newFragment, fragment.getClass().getName()).commit();
                }
//                fragment.updateColor(Color.parseColor(colors[position]));
            }
        });

    }

}
