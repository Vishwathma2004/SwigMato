package com.example.food_ordering_app.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.interfaces.ItemClickListener;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.example.food_ordering_app.MenuBottomSheetFragment;
import com.example.food_ordering_app.R;
import com.example.food_ordering_app.adapter.PopularAdapter;
import com.example.food_ordering_app.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;



    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.viewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MenuBottomSheetFragment bottomSheetDialog = new MenuBottomSheetFragment();
                bottomSheetDialog.show(getParentFragmentManager(), "Test");

            }
        });

        // Image Slider
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.banner1, "Burger Bonanza", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner2, "Pizza Fiesta", ScaleTypes.FIT));
        imageList.add(new SlideModel(R.drawable.banner3, "Dessert Delights", ScaleTypes.FIT));

        binding.imageSlider.setImageList(imageList, ScaleTypes.FIT);

        binding.imageSlider.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemSelected(int position) {
                String itemTitle = imageList.get(position).getTitle();
                Toast.makeText(requireContext(), "Selected: " + itemTitle, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void doubleClick(int position) {
                String itemTitle = imageList.get(position).getTitle();
                Toast.makeText(requireContext(), "Double Clicked: " + itemTitle, Toast.LENGTH_SHORT).show();
            }
        });

        // RecyclerView - Popular Items
        List<String> foodName = List.of("Paneer-Special", "Poori", "Mango-Sundae", "Mangalore Biriyani");
        List<String> price = List.of("$5", "$7", "$6", "$10");
        List<Integer> popularFoodImages = List.of(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu4,
                R.drawable.menu5
        );

        PopularAdapter adapter = new PopularAdapter(foodName, popularFoodImages, price);
        binding.popularRecycleView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.popularRecycleView.setAdapter(adapter);

        return binding.getRoot();
    }

}
