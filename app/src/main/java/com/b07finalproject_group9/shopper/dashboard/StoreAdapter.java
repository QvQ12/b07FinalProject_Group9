package com.b07finalproject_group9.shopper.dashboard;

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
import com.b07finalproject_group9.objects.Store;

import java.util.ArrayList;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.MyViewHolder>{
    Context context;
    static FragmentManager fragmentManager;
    ArrayList<Store> storeName;

    public StoreAdapter(Context context, ArrayList<Store> storeName,  FragmentManager fragmentManager) {
        this.context = context;
        this.storeName = storeName;
        this.fragmentManager = fragmentManager;
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
//        ShopperProductPage.storeName = store.getStoreName();

        holder.itemView.findViewById(R.id.Productbutton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment someFragment = new ShopperProductPage(store.getStoreName());
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.main_login_redirect, someFragment).commit();
                    transaction.addToBackStack(null);
                }
            });
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
//            itemView.findViewById(R.id.Productbutton).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Fragment someFragment = new ShopperProductPage();
//                    FragmentTransaction transaction = fragmentManager.beginTransaction();
//                    transaction.replace(R.id.main_login_redirect, someFragment).commit();
//                    transaction.addToBackStack(null);
//                }
//            });
        }
    }
}
