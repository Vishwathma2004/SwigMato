package com.example.food_ordering_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food_ordering_app.databinding.FragmentCongratsBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class CongratsBottomSheet extends BottomSheetDialogFragment {

    private FragmentCongratsBottomSheetBinding binding;



    public CongratsBottomSheet() {
        // Required empty public constructor
    }


    public static CongratsBottomSheet newInstance(String param1, String param2) {
        CongratsBottomSheet fragment = new CongratsBottomSheet();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCongratsBottomSheetBinding.inflate(getLayoutInflater(),container,false);
        // Inflate the layout for this fragment
        binding.gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        return binding.getRoot();
    }
}