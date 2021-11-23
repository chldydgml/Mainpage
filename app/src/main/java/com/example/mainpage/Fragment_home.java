package com.example.mainpage;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment_home extends Fragment {

    private ArrayList<Policy> policylist = new ArrayList<>();
    private MainAdapter mAdapter;
    RecyclerView mainRv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        mainRv = (RecyclerView) v.findViewById(R.id.main_rv);
        mAdapter = new MainAdapter(policylist);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mainRv.setLayoutManager(mLayoutManager);
        mainRv.setAdapter(mAdapter);



        policylist.add(new Policy(R.drawable.p1, "청년 월세 지원정책", " 09.28 ~ 10.05", "20 ~ 39세"));
        policylist.add(new Policy(R.drawable.p2, "국민내일배움카드", " 10.01 ~ 12.05", "0 ~ 75세"));
        policylist.add(new Policy(R.drawable.p3, "국민취업지원제도", "11.01 ~ 12.31", "20 ~ 39세"));

        return v;
    }
}