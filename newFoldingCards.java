package com.example.app.testcards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;

public class newFoldingCards extends Fragment {

    public static final int NEWS = 2;

    private static final String ARG_COLOR = "color";
    private int color;

    public newFoldingCards() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            color = getArguments().getInt(ARG_COLOR);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.newfoldingcards, container, false);

        RecyclerView mRecyclerView;
        CustomAdapter mAdapter;
        RecyclerView.LayoutManager mLayoutManager;
        String[] mDataset = {"", "", "", "", "", "", "", "", ""};
        int mDatasetTypes[] = { NEWS, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS, NEWS}; //view types

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //Adapter is created in the last step
        mAdapter = new CustomAdapter(mDataset, mDatasetTypes);
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

}
