package com.example.food_ordering_app.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.collection.MutableIntList;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_ordering_app.databinding.CartItemBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
    class CartViewHolder(ArrayList<String> cartItems, MutableIntList<String>, ArrayList CartItemPrice<String>,MutableIntList<Integer> cartImage) extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{
        CartItemBinding binding = CartItemBinding.bind()
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemBinding binding = CartItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CartViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return cart;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

    }
}
