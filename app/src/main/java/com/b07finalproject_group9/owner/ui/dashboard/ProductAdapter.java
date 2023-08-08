package com.b07finalproject_group9.owner.ui.dashboard;

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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{

    Context context;

    ArrayList<ProductInfo> inventory;

    public ProductAdapter(Context context, ArrayList<ProductInfo> inventory) {
        this.context = context;
        this.inventory = inventory;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.product_display,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductInfo product = inventory.get(position);
        holder.ProductName.setText(product.getProductName());
        holder.ProductQuantity.setText(product.getProductQuantity());
        holder.ProductPrice.setText(product.getProductPrice());
        holder.ProductDescription.setText(product.getProductDescription());


    }

    @Override
    public int getItemCount() {
        return inventory.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ProductName, ProductPrice, ProductQuantity, ProductDescription;
        public MyViewHolder(@NonNull View productView){
            super(productView);

            ProductName = productView.findViewById(R.id.productName);
            ProductQuantity = productView.findViewById(R.id.productQuantity);
            ProductPrice = productView.findViewById(R.id.productPrice);
            ProductDescription = productView.findViewById(R.id.productDescription);
        }
    }
}
