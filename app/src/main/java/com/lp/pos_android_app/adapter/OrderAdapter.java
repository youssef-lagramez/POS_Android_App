package com.lp.pos_android_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lp.pos_android_app.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder> {

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class OrderHolder extends RecyclerView.ViewHolder {
        private TextView food_name,Quantity,food_price;
        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            food_name = itemView.findViewById(R.id.food_name);
            Quantity = itemView.findViewById(R.id.Quantity);
            food_price = itemView.findViewById(R.id.food_price);
        }
    }
}
