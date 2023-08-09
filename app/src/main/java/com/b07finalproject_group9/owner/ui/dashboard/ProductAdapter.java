package com.b07finalproject_group9.owner.ui.dashboard;



import static android.app.PendingIntent.getActivity;

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

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{
    static FragmentManager fragmentManager;
    Context context;
    ArrayList<ProductInfo> inventory;
    public ProductAdapter(Context context, ArrayList<ProductInfo> inventory, FragmentManager fragmentManager) {
        this.context = context;
        this.inventory = inventory;
        this.fragmentManager = fragmentManager;
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
        holder.ProductId.setText(product.getProductId());
        EditProduct.key = product.getProductId();
    }


    @Override
    public int getItemCount() {
        return inventory.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ProductName, ProductPrice, ProductQuantity, ProductDescription, ProductId;
        public MyViewHolder(@NonNull View productView){
            super(productView);
            ProductName = productView.findViewById(R.id.productName);
            ProductQuantity = productView.findViewById(R.id.productQuantity);
            ProductPrice = productView.findViewById(R.id.productPrice);
            ProductDescription = productView.findViewById(R.id.productDescription);
            ProductId = productView.findViewById(R.id.ProductId);
            itemView.findViewById(R.id.editButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment someFragment = new EditProduct();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_container_view, someFragment).commit();
                    transaction.addToBackStack(null);
                }
            });
        }

    }


}
