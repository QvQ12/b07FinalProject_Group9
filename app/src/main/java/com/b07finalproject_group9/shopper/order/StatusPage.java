package com.b07finalproject_group9.shopper.order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b07finalproject_group9.OrderModel;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;
import com.b07finalproject_group9.shopper.ShopperModel;
import com.b07finalproject_group9.shopper.dashboard.ProductShopperAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class StatusPage extends Fragment {
    RecyclerView recyclerView;
    private String key;
    private StatusAdapter statusAdapter;
    private ArrayList<ProductInfo> productList = new ArrayList<>();
    private OrderModel om = new OrderModel();
    private ShopperModel shm = new ShopperModel();
    private StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();

    public StatusPage() { }

    public StatusPage(String key){
        this.key = key;
    }


    private void processProductID(String prodID, String store){
        sm.getSpecificProduct(prodID, store).thenAccept(map -> addToProductList(map, prodID));
    }
    private void addToProductList(HashMap<String, String> map, String prodID){
        ProductInfo p = new ProductInfo(map, prodID);
        productList.add(p);
        recyclerView.setAdapter(statusAdapter);
    }
    private void processListOfProductID(ArrayList<String> list){
        if(list == null) return;
        for(int i = 0; i < list.size(); i++){
            String prodID = list.get(i);
            shm.getStoreBasedOnProductID(list.get(i))
                    .thenAccept(store->processProductID(prodID, store));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_status_page, container, false);
        recyclerView = view.findViewById(R.id.orderProductDisplay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        productList = new ArrayList<>();
        statusAdapter = new StatusAdapter(getContext(), productList,getActivity().getSupportFragmentManager());
        om.getProductIDbyOrder(key).thenAccept(res -> processListOfProductID(res));
        return view;
    }
}