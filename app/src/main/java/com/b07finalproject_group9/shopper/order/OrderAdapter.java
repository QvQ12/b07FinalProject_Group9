package com.b07finalproject_group9.shopper.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.shopper.cart.CartAdapter;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    ArrayList<String> orderKeys;
    Context context;

    public OrderAdapter(Context context, ArrayList<String> orderKeys){
        this.context = context;
        this.orderKeys=orderKeys;
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
