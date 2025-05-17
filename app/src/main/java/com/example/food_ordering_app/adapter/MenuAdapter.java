package com.example.food_ordering_app.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.databinding.MenuItemBinding;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private final List<String> menuItems;
    private final List<String> menuItemPrices;
    private final List<Integer> menuImages; // Drawable resource IDs

    public MenuAdapter(List<String> menuItems, List<String> menuItemPrices, List<Integer> menuImages) {
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

    static class MenuViewHolder extends RecyclerView.ViewHolder {

        private final MenuItemBinding binding;

        public MenuViewHolder(@NonNull MenuItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String name, String price, int imageResId) {
            binding.menuFoodName.setText(name);
            binding.menuItemPrice.setText(price);
            binding.menuImage.setImageResource(imageResId);

            // Optional: Add onClickListener for "Add to Cart" button
            binding.addToCartBtn.setOnClickListener(v -> {
            });
        }
    }
}
