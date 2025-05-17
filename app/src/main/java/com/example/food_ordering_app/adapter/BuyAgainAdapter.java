package com.example.food_ordering_app.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.databinding.BuyAgainItemBinding;

import java.util.List;

public class BuyAgainAdapter extends RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder> {

    private final List<String> buyAgainFoodName;
    private final List<String> buyAgainFoodPrice;
    private final List<Integer> buyAgainFoodImage;

    public BuyAgainAdapter(List<String> buyAgainFoodName, List<String> buyAgainFoodPrice, List<Integer> buyAgainFoodImage) {
        this.buyAgainFoodName = buyAgainFoodName;
        this.buyAgainFoodPrice = buyAgainFoodPrice;
        this.buyAgainFoodImage = buyAgainFoodImage;
    }

    @NonNull
    @Override
    public BuyAgainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BuyAgainItemBinding binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BuyAgainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BuyAgainViewHolder holder, int position) {
        holder.binding.buyAgainFoodName.setText(buyAgainFoodName.get(position));
        holder.binding.buyAgainFoodPrice.setText(buyAgainFoodPrice.get(position));
        holder.binding.buyAgainFoodImage.setImageResource(buyAgainFoodImage.get(position));
    }

    @Override
    public int getItemCount() {
        return buyAgainFoodName.size();
    }

    static class BuyAgainViewHolder extends RecyclerView.ViewHolder {
        BuyAgainItemBinding binding;

        public BuyAgainViewHolder(BuyAgainItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
