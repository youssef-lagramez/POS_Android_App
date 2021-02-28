package com.lp.pos_android_app.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lp.pos_android_app.R;
import com.lp.pos_android_app.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private ArrayList <Category> list_Category;

    public CategoryAdapter(ArrayList<Category> list_Category) {
        this.list_Category = list_Category;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = list_Category.get(position);
        holder.category_Photo.setImageURI(Uri.parse(category.getNameCat()));
    }

    @Override
    public int getItemCount() {
        return list_Category.size();
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder {
        private ImageView category_Photo;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            category_Photo = itemView.findViewById(R.id.category_Photo);
        }
    }
}
