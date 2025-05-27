package com.example.food_ordering_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.DetailsActivity;
import com.example.food_ordering_app.databinding.MenuItemBinding;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<String> menuItems;
    private final List<String> menuItemPrices;
    private final List<Integer> menuImages;
    private final Context context;

    public MenuAdapter(Context context, List<String> menuItems, List<String> menuItemPrices, List<Integer> menuImages) {
        this.context = context;
        this.menuItems = menuItems;
        this.menuItemPrices = menuItemPrices;
        this.menuImages = menuImages;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MenuItemBinding binding = MenuItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MenuViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(menuItems.get(position), menuItemPrices.get(position), menuImages.get(position));
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder {

        private final MenuItemBinding binding;

        public MenuViewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String name, String price, int imageResId) {
            binding.menuFoodName.setText(name);
            binding.menuItemPrice.setText(price);
            binding.menuImage.setImageResource(imageResId);

            // Launch DetailsActivity on item click
            binding.getRoot().setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("MenuItemName", name);
                intent.putExtra("price", price);
                intent.putExtra("imageResId", imageResId);
                context.startActivity(intent);
            });

            // Add to cart logic placeholder
            binding.addToCartBtn.setOnClickListener(v -> {
                // TODO: Add to cart functionality here
            });
        }
    }
}
