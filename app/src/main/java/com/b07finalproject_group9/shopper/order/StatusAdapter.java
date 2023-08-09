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
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.shopper.cart.AddProductToCart;
import com.b07finalproject_group9.shopper.dashboard.ShopperProductPage;

import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {
    Context context;
    FragmentManager fragmentManager;
    ArrayList<ProductInfo> orderList;

    public StatusAdapter(Context context, ArrayList<ProductInfo> orderList, FragmentManager fragmentManager) {
        this.context = context;
        this.orderList = orderList;
        this.fragmentManager = fragmentManager;
    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.order_product_display,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductInfo product = orderList.get(position);
        holder.orderName.setText(product.getProductName());
        holder.orderQuantity.setText(product.getProductQuantity());
        holder.orderPrice.setText(product.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView orderName, orderPrice, orderQuantity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            orderName = itemView.findViewById(R.id.orderProductName);
            orderQuantity = itemView.findViewById(R.id.orderProductQuantity);
            orderPrice = itemView.findViewById(R.id.orderProductPrice);

        }

    }
}
