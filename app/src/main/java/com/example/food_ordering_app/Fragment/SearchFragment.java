package com.example.food_ordering_app.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.food_ordering_app.R;
import com.example.food_ordering_app.adapter.MenuAdapter;
import com.example.food_ordering_app.databinding.FragmentSearchBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchFragment extends Fragment {
    private FragmentSearchBinding binding;

    private List<String> filteredMenuFoodName;
    private List<String> filteredMenuItemPrice;
    private List<Integer> filteredMenuImage;

    private MenuAdapter adapter;

    ArrayList<String> originalMenuFoodName = new ArrayList<>(Arrays.asList(
            "Paneer-Special", "Poori", "Mango-Sundae", "Mangalore Biriyani"
    ));
    ArrayList<String> originalMenuItemPrice = new ArrayList<>(Arrays.asList(
            "$5", "$7", "$6", "$10"
    ));
    ArrayList<Integer> originalMenuImage = new ArrayList<>(Arrays.asList(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu4,
            R.drawable.menu5
    ));

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        // Initialize filtered lists with all items initially
        filteredMenuFoodName = new ArrayList<>((Arrays.asList(
                "Paneer-Special", "Poori", "Mango-Sundae", "Mangalore Biriyani"
        )));
        filteredMenuItemPrice = new ArrayList<>((Arrays.asList(
                "$5", "$7", "$6", "$10"
        )));
        filteredMenuImage = new ArrayList<>((Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu4,
                R.drawable.menu5
        )));

        adapter = new MenuAdapter(requireContext(),filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage);
        binding.menuRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.menuRecyclerView.setAdapter(adapter);

        setupSearchView();

        showAllMenu();

        return binding.getRoot();
    }

    private void showAllMenu() {
        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        filteredMenuFoodName.addAll(originalMenuFoodName);
        filteredMenuItemPrice.addAll(originalMenuItemPrice);
        filteredMenuImage.addAll(originalMenuImage);

        adapter.notifyDataSetChanged();
    }


    private void setupSearchView() {
        binding.searchView.setQueryHint("Are U Hungry?? Order Now!!");
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMenuItems(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMenuItems(newText);
                return true;
            }
        });
    }

    private void filterMenuItems(String query) {
        query = query.toLowerCase().trim();

        filteredMenuFoodName.clear();
        filteredMenuItemPrice.clear();
        filteredMenuImage.clear();

        if (query.isEmpty()) {
            // Show all if query is empty
            filteredMenuFoodName.addAll(originalMenuFoodName);
            filteredMenuItemPrice.addAll(originalMenuItemPrice);
            filteredMenuImage.addAll(originalMenuImage);
        } else {
            for (int i = 0; i < originalMenuFoodName.size(); i++) {
                String foodName = originalMenuFoodName.get(i).toLowerCase();
                if (foodName.contains(query)) {
                    filteredMenuFoodName.add(originalMenuFoodName.get(i));
                    filteredMenuItemPrice.add(originalMenuItemPrice.get(i));
                    filteredMenuImage.add(originalMenuImage.get(i));
                }
            }
        }

        adapter.notifyDataSetChanged();
    }


}
