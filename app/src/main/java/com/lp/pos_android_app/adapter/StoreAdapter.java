package com.lp.pos_android_app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lp.pos_android_app.R;
import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreHolder> {



    @NonNull
    @Override
    public StoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoreHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class StoreHolder extends RecyclerView.ViewHolder {
         private TextView title , poids , price_food;
         private ImageView image;
        public StoreHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.food_title);
            poids = itemView.findViewById(R.id.poids);
            price_food = itemView.findViewById(R.id.price_food);
            image = itemView.findViewById(R.id.food_image);
        }
    }
}
