package com.b07finalproject_group9.shopper.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.OrderModel;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.Store;

import java.util.ArrayList;


public class OrderDashboard extends Fragment {

    RecyclerView recyclerView;
    OrderAdapter orderAdapter;
    ArrayList<String> orderKey;
    OrderModel om = new OrderModel();

    private void processKey(ArrayList<String> res){
        for(int i=0;i<res.size();i++){
            orderKey.add(res.get(i));
        }
        recyclerView.setAdapter(orderAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_dashboard, container, false);
        recyclerView = view.findViewById(R.id.orderPageRecyclerView); // fix
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        orderKey = new ArrayList<String>();
        orderAdapter = new OrderAdapter((getContext()),orderKey);
        om.getOrderKeysFromShopper(MainActivity.currUser.getUsername()).thenAccept(res-> processKey(res));

        return view;
    }
}