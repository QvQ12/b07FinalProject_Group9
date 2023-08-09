package com.b07finalproject_group9.owner.ui.notifications;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.b07finalproject_group9.OrderModel;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;
import com.b07finalproject_group9.shopper.ShopperModel;
import com.b07finalproject_group9.shopper.dashboard.ProductShopperAdapter;
import com.b07finalproject_group9.shopper.dashboard.ShopperDashboardFragment;
import com.b07finalproject_group9.shopper.order.OrderDashboard;
import com.b07finalproject_group9.shopper.order.StatusAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class NotificationStatusPage extends Fragment {
    RecyclerView recyclerView;
    private String key;
    private NotificationStatusAdapter notificationStatusAdapter;
    private ArrayList<ProductInfo> productList = new ArrayList<>();
    private OrderModel om = new OrderModel();
    private ShopperModel shm = new ShopperModel();
    private StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();

    public NotificationStatusPage() { }

    public NotificationStatusPage(String key){
        this.key = key;
    }
    private void processProductID(String prodID, String store){
        sm.getSpecificProduct(prodID, store).thenAccept(map -> addToProductList(map, prodID));

    }
    private void addToProductList(HashMap<String, String> map, String prodID){
        ProductInfo p = new ProductInfo(map, prodID);
        productList.add(p);
        recyclerView.setAdapter(notificationStatusAdapter);
    }
    private void processListOfProductID(ArrayList<String> list){
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
        View view =  inflater.inflate(R.layout.fragment_notification_status_page, container, false);
        recyclerView = view.findViewById(R.id.ownerOrderDisplay);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        productList = new ArrayList<>();
        notificationStatusAdapter = new NotificationStatusAdapter(getContext(), productList, getActivity().getSupportFragmentManager());
        om.getProductIDbyOrder(key).thenAccept(res -> processListOfProductID(res));

        Button back = view.findViewById(R.id.back_button1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new OrderDashboard();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });
        return view;
    }
}