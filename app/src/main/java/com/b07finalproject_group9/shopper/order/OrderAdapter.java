package com.b07finalproject_group9.shopper.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.shopper.cart.CartAdapter;
import com.b07finalproject_group9.shopper.dashboard.ShopperProductPage;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    ArrayList<String> orderKeys;
    Context context;
    static FragmentManager fragmentManager;

    public OrderAdapter(Context context, ArrayList<String> orderKeys, FragmentManager fragmentManager){
        this.context = context;
        this.orderKeys=orderKeys;
        this.fragmentManager =fragmentManager;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.order_display,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String key = orderKeys.get(position);
        holder.OrderId.setText(key);
        holder.itemView.findViewById(R.id.ViewOrderButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment someFragment = new ShopperProductPage(key);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.main_login_redirect, someFragment).commit();
                transaction.addToBackStack(null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderKeys.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView OrderId;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            OrderId = itemView.findViewById(R.id.OrderId);
        }
    }
}
