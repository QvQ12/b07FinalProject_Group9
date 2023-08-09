package com.b07finalproject_group9.shopper.order;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.MyViewHolder> {

    private Context context;
    private List<ProductInfo> inventory;
    private FragmentManager fragmentManager;

    public StatusAdapter(Context context, List<ProductInfo> inventory, FragmentManager fragmentManager) {
        this.context = context;
        this.inventory = inventory;
        this.fragmentManager = fragmentManager;
        Log.i("INVENTORY", inventory.toString());
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_product_display, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductInfo product = inventory.get(position);
        holder.productName.setText(product.getProductName());
        holder.productQuantity.setText(product.getProductQuantity());
        holder.productPrice.setText(product.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return inventory.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView productName;
        private TextView productPrice;
        private TextView productQuantity;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.orderProductName);
            productQuantity = itemView.findViewById(R.id.orderProductQuantity);
            productPrice = itemView.findViewById(R.id.orderProductPrice);
        }


    }
}
