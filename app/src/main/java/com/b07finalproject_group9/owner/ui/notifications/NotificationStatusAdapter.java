package com.b07finalproject_group9.owner.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.shopper.order.StatusAdapter;

import java.util.List;

public class NotificationStatusAdapter extends RecyclerView.Adapter<NotificationStatusAdapter.MyViewHolder> {

    Context context;
    List<ProductInfo> inventory;
    FragmentManager fragmentManager;

    public NotificationStatusAdapter(Context context, List<ProductInfo> inventory, FragmentManager fragmentManager){
        this.context = context;
        this.inventory = inventory;
        this.fragmentManager = fragmentManager;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.owner_order_display, parent, false);
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

    public class MyViewHolder extends RecyclerView.ViewHolder{

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
