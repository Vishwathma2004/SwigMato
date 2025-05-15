package com.example.food_ordering_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.food_ordering_app.R;
import com.example.food_ordering_app.adapter.CartAdapter;
import com.example.food_ordering_app.databinding.FragmentCartBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class CartFragment extends Fragment {

    private FragmentCartBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCartBinding.inflate(inflater, container, false);

        ArrayList<String> cartFoodName = new ArrayList<>(Arrays.asList("Paneer-Special", "Poori", "Mango-Sundae", "Mangalore Biriyani"));
        ArrayList<String> cartFoodPrice = new ArrayList<>(Arrays.asList("$5", "$7", "$6", "$10"));
        ArrayList<Integer> cartItemImage = new ArrayList<>(Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu4,
                R.drawable.menu5
        ));

        CartAdapter adapter = new CartAdapter(cartFoodName, cartFoodPrice, cartItemImage);
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.cartRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
