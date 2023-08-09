package com.b07finalproject_group9.shopper.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;
import com.b07finalproject_group9.shopper.dashboard.ProductShopperAdapter;

import java.util.ArrayList;

public class ShopperProductPage extends Fragment {
    public static String storeName;
    StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();
    private RecyclerView recyclerView;
    private ProductShopperAdapter productAdapter;
    private ArrayList<ProductInfo> productList = new ArrayList<>();

    public ShopperProductPage(){}
    public ShopperProductPage(String storeName){
        this.storeName = storeName;
    }

    private void processInventory(ArrayList<String> res){
        for(int i = 0; i < res.size(); i++){
            String productId = res.get(i);
            sm.getSpecificProduct(productId, storeName).
                    thenAccept(prod -> addItemToLocalInventory(productList,
                            new ProductInfo(prod, productId)));
        }
    }
    private void addItemToLocalInventory(ArrayList<ProductInfo> inventory, ProductInfo prod){
        inventory.add(prod);
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopper_product_page, container, false);
        recyclerView = view.findViewById(R.id.productListShopper);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        productList = new ArrayList<>();
        productAdapter = new ProductShopperAdapter(getContext(), productList,getActivity().getSupportFragmentManager());
        sm.getProductInventory(storeName).
                thenAccept(res-> processInventory(res));
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Object binding = null;
    }


}

