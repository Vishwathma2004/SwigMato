package com.example.food_ordering_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.food_ordering_app.R;
import com.example.food_ordering_app.adapter.BuyAgainAdapter;
import com.example.food_ordering_app.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private BuyAgainAdapter buyAgainAdapter;

    public HistoryFragment() {
        // Required empty public constructor
    }

    public static HistoryFragment newInstance(String param1, String param2) {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        ArrayList<String> buyAgainFoodName = new ArrayList<>(Arrays.asList("Food 1", "Food 2", "Food 3"));
        ArrayList<String> buyAgainFoodPrice = new ArrayList<>(Arrays.asList("$10", "$20", "$30"));
        ArrayList<Integer> buyAgainFoodImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu4
        ));

        buyAgainAdapter = new BuyAgainAdapter(buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage);
        binding.buyAgainRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.buyAgainRecyclerView.setAdapter(buyAgainAdapter);
        binding.buyAgainRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}
