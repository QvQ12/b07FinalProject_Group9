package com.b07finalproject_group9.shopper.cart;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.Cart;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;
import com.b07finalproject_group9.shopper.dashboard.ShopperDashboardFragment;


public class ShoppingCart extends Fragment {

    private RecyclerView shoppingCartRecyclerView;
    Button edit;
    CartAdapter cartAdapter;
    ArrayList<ProductInfo> productList;



    private void processCart(Cart cart){
        for(String store : cart.CartContent.keySet()){
            for(String productID : cart.CartContent.get(store).keySet()){
                processItem(store, productID, cart.CartContent.get(store).get(productID));
            }
        }
        shoppingCartRecyclerView.setAdapter(cartAdapter);
    }

    private void processItem(String storename, String productID, int quantity){
        StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();
        sm.getSpecificProduct(productID, storename).thenAccept(res -> productList
                            .add(new ProductInfo(res,res.get("ProductID"))));

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        Button returnToMainButton = view.findViewById(R.id.button);

        shoppingCartRecyclerView = view.findViewById(R.id.shoppingCartRecyclerView);
        shoppingCartRecyclerView.setHasFixedSize(true);
        shoppingCartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        productList = new ArrayList<>();

        CartModel cm = new CartModel();
        cm.getUserCart(MainActivity.currUser.getUsername()).thenAccept(res -> processCart(res));

        cartAdapter = new CartAdapter(getContext(), productList,
                getActivity().getSupportFragmentManager());

        returnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new ShopperDashboardFragment();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        Button payOrderButton = view.findViewById(R.id.payOrderButton);
        payOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new ShopperDashboardFragment();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();;
            }
        });
        return view;
    }

    // Assuming you have the Product and ItemProductAdapter classes somewhere either in separate files or in this file.
}
