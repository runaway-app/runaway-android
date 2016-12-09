package com.example.app.testcards;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import android.support.v7.widget.LinearLayoutManager;



public class MainActivity extends AppCompatActivity {

    public static final int WEATHER = 0;
    public static final int SCORE = 1;
    public static final int NEWS = 2;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.three_buttons_activity);

        final BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(int itemId) {
                switch (itemId) {
                    case R.id.recent_item:
                        Snackbar.make(coordinatorLayout, "Recent Item Selected", Snackbar.LENGTH_LONG).show();
                        bottomBar.selectTabAtPosition(itemId, true);
                        break;
                    case R.id.favorite_item:
                        Snackbar.make(coordinatorLayout, "Favorite Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.location_item:
                        Snackbar.make(coordinatorLayout, "Location Item Selected", Snackbar.LENGTH_LONG).show();
                        break;
                }
            }
        });

        bottomBar.setActiveTabColor("#C2185B");

        RecyclerView mRecyclerView;
        CustomAdapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;
        String[] mDataset = {"29 degrees", "Seahawks 24 - 27 Bengals",
                "Flash missing, vanishes in crisis", "Half Life 3 announced", "1", "1", "1", "1", "1", "1", "1"};
        int mDatasetTypes[] = {WEATHER, SCORE, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS}; //view types

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //Adapter is created in the last step
        mAdapter = new CustomAdapter(mDataset, mDatasetTypes);
        mRecyclerView.setAdapter(mAdapter);

    }
}
