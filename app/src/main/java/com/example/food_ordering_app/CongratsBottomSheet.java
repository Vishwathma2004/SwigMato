package com.example.food_ordering_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CongratsBottomSheet extends Fragment {





    public CongratsBottomSheet() {
        // Required empty public constructor
    }


    public static CongratsBottomSheet newInstance(String param1, String param2) {
        CongratsBottomSheet fragment = new CongratsBottomSheet();
        Bundle args = new Bundle();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_congrats_bottom_sheet, container, false);
    }
}