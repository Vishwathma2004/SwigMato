package com.example.food_ordering_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.food_ordering_app.adapter.NotificationAdapter;
import com.example.food_ordering_app.databinding.FragmentNotificationBottomBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class notification_bottom extends BottomSheetDialogFragment {
    private FragmentNotificationBottomBinding binding;

    public notification_bottom() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationBottomBinding.inflate(inflater, container, false);

        ArrayList<String> notificationText = new ArrayList<>(Arrays.asList(
                "Your order has been cancelled successfully",
                "Order has been taken by the driver",
                "Order is placed"
        ));

        ArrayList<Integer> notificationImages = new ArrayList<>(Arrays.asList(
                R.drawable.sad,
                R.drawable.truck,
                R.drawable.confirm_icon
        ));

        NotificationAdapter adapter = new NotificationAdapter(notificationText, notificationImages);
        binding.notificationRecyclerView.setAdapter(adapter);
        binding.notificationRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        return binding.getRoot();
    }
}
