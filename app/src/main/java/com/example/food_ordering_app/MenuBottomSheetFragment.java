package com.example.food_ordering_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.food_ordering_app.adapter.CartAdapter;
import com.example.food_ordering_app.databinding.FragmentMenuBottomSheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuBottomSheetFragment extends BottomSheetDialogFragment {
    private FragmentMenuBottomSheetBinding binding;

    public MenuBottomSheetFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false);
        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        ArrayList<String> menuFoodName = new ArrayList<>(Arrays.asList("Paneer-Special", "Poori", "Mango-Sundae", "Mangalore Biriyani"));
        ArrayList<String> menuFoodPrice = new ArrayList<>(Arrays.asList("$5", "$7", "$6", "$10"));
        ArrayList<Integer> menuItemImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu4,
                R.drawable.menu5
        ));
        CartAdapter adapter = new CartAdapter(menuFoodName, menuFoodPrice, menuItemImage);
        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.menuRecyclerView.setAdapter(adapter);
        return binding.getRoot();
    }
}
