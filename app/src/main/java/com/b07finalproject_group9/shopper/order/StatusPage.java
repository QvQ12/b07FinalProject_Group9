package com.b07finalproject_group9.shopper.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.shopper.dashboard.ProductShopperAdapter;

import java.util.ArrayList;

public class StatusPage extends Fragment {
    RecyclerView recyclerView;

    private ProductShopperAdapter productAdapter;
    private ArrayList<ProductInfo> productList = new ArrayList<>();
    public StatusPage() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_status_page, container, false);
        recyclerView = view.findViewById(R.id.orderProductDisplay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        productList = new ArrayList<>();
        productAdapter = new ProductShopperAdapter(getContext(), productList,getActivity().getSupportFragmentManager());
        sm.getProductInventory(storeName).
                thenAccept(res-> processInventory(res));
        return view;
    }
}