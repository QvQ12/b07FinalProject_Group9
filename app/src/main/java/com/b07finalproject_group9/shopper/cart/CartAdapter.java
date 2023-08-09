package com.b07finalproject_group9.shopper.cart;

import android.content.Context;
import android.util.Log;
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
import com.b07finalproject_group9.objects.Cart;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.shopper.ShopperModel;
import com.b07finalproject_group9.shopper.dashboard.ProductShopperAdapter;
import com.b07finalproject_group9.shopper.dashboard.ShopperProductPage;

import java.util.ArrayList;

public class CartAdapter extends  RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    static FragmentManager fragmentManager;
    Context context;
    ArrayList<ProductInfo> productList;

    public CartAdapter(Context context, ArrayList<ProductInfo> productList, FragmentManager fragmentManager) {
        this.context = context;
        this.productList = productList;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cart_display,parent,false);
        return new MyViewHolder(v);
    }


    private void addToCart(String res, ProductInfo product){
        Fragment someFragment = new AddProductToCart(res, product.getProductId());
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_login_redirect, someFragment).commit();
        transaction.addToBackStack(null);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProductInfo product = productList.get(position);
        holder.ProductName.setText(product.getProductName());
        holder.ProductQuantity.setText(product.getProductQuantity());
        holder.ProductPrice.setText(product.getProductPrice());

        holder.itemView.findViewById(R.id.cartEditButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopperModel sm = new ShopperModel();
                sm.getStoreBasedOnProductID(product.productId)
                        .thenAccept(res->addToCart(res, product));

            }
        });

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ProductName, ProductPrice, ProductQuantity, ProductDescription, ProductId;
        public MyViewHolder(@NonNull View productView){

            super(productView);
            ProductName = productView.findViewById(R.id.cartProductName);
            ProductQuantity = productView.findViewById(R.id.cartProductQuantity);
            ProductPrice = productView.findViewById(R.id.cartProductPrice);

        }

    }

}
