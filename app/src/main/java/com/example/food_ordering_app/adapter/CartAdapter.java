package com.example.food_ordering_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.databinding.CartItemBinding;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final ArrayList<String> cartItems;
    private final ArrayList<String> cartItemPrices;
    private final ArrayList<Integer> cartImages;
    private final ArrayList<Integer> itemQuantities;  // Changed to ArrayList<Integer>

    public CartAdapter(ArrayList<String> cartItems, ArrayList<String> cartItemPrices, ArrayList<Integer> cartImages) {
        this.cartItems = cartItems;
        this.cartItemPrices = cartItemPrices;
        this.cartImages = cartImages;
        this.itemQuantities = new ArrayList<>();
        for (int i = 0; i < cartItems.size(); i++) {
            itemQuantities.add(1);
        }
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        CartItemBinding binding;

        public CartViewHolder(@NonNull CartItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.binding.cartFoodName.setText(cartItems.get(position));
        holder.binding.cartFoodPrice.setText(cartItemPrices.get(position));
        holder.binding.cartItemImage.setImageResource(cartImages.get(position));
        holder.binding.cartItemQuantity.setText(String.valueOf(itemQuantities.get(position)));

        holder.binding.plusButton.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                int currentQty = itemQuantities.get(currentPosition);
                if (currentQty < 100) {
                    itemQuantities.set(currentPosition, currentQty + 1);
                    notifyItemChanged(currentPosition);
                }
            }
        });

        holder.binding.minusButton.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                int currentQty = itemQuantities.get(currentPosition);
                if (currentQty > 1) {
                    itemQuantities.set(currentPosition, currentQty - 1);
                    notifyItemChanged(currentPosition);
                }
            }
        });

        holder.binding.deleteButton.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                cartItems.remove(currentPosition);
                cartItemPrices.remove(currentPosition);
                cartImages.remove(currentPosition);
                itemQuantities.remove(currentPosition);
                notifyItemRemoved(currentPosition);
                notifyItemRangeChanged(currentPosition, cartItems.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}
