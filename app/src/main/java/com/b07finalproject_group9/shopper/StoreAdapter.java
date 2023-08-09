package com.b07finalproject_group9.shopper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder>{
    Context context;

    ArrayList<Store> storeName;

    public StoreAdapter(Context context, ArrayList<Store> storeName) {
        this.context = context;
        this.storeName = storeName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.store_display,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Store store = storeName.get(position);
        holder.storeName.setText(store.getStoreName());
    }

    @Override
    public int getItemCount() {
        return storeName.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView storeName;
        public MyViewHolder(@NonNull View productView){
            super(productView);
            storeName = productView.findViewById(R.id.storename_shopper_dashboard);
        }
    }
}
