package com.example.food_ordering_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.food_ordering_app.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String foodName = intent.getStringExtra("MenuItemName");
        String price = intent.getStringExtra("price");
        int foodImage = intent.getIntExtra("imageResId", 0);
        binding.detailFoodImage.setImageResource(foodImage);
        binding.detailFoodName.setText(foodName);

    }
}