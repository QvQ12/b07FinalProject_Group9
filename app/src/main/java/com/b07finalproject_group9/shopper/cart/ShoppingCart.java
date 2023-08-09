package com.b07finalproject_group9.shopper.cart;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
    private CartModel cm = new CartModel();
    private StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();



    private void processCart(Cart cart){
        for(String store : cart.CartContent.keySet()){
            for(String productID : cart.CartContent.get(store).keySet()){
                processItem(store, productID, cart.CartContent.get(store).get(productID));
            }
        }
        cm.validateCart(cart, MainActivity.currUser.getUsername());
    }

    private void processItem(String storename, String productID, int quantity){
        sm.getSpecificProduct(productID, storename)
                .thenAccept(res -> addNewProductToList(res, quantity));

    }

    private void addNewProductToList(HashMap<String, String> res, int quantity){
        String productID = res.get("ProductID");
        String productQuantity = Integer.toString(quantity);
        String productPrice = res.get("price");
        String productName = res.get("product_name");
        String productDescription = res.get("description");
        ProductInfo p = new ProductInfo(productName, productQuantity,
                productPrice, productDescription, productID);
        productList.add(p);
        shoppingCartRecyclerView.setAdapter(cartAdapter);
    }



    private void switchPagePushCartSuccess(){
        cm.pushCartToOrderList(MainActivity.currUser.getUsername());
        Fragment f = new ShopperDashboardFragment();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
        Toast.makeText(getContext() , "Your order has been placed!",
                Toast.LENGTH_SHORT).show();
    }

    private void switchPagePushCartFailure(){
        Fragment f = new ShoppingCart();
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.replace(R.id.main_login_redirect, f).commit();
        Toast.makeText(getContext(), "You have more items in your cart, than the store has..",
                Toast.LENGTH_SHORT).show();
    }

    private void convertCartToOrder(Cart cart){
        for(String store : cart.CartContent.keySet()){
            for(String item : cart.CartContent.get(store).keySet()){
                int wanted_amount = cart.CartContent.get(store).get(item);
                sm.getSpecificProduct(item, store)
                            .thenAccept(map -> cartDecision(cart, map, store));
            }
        }
    }

    private void cartDecision(Cart cart, HashMap<String, String> map, String store){
        if(Integer.parseInt(map.get("quantity"))
                <  cart.CartContent.get(store).get(map.get("ProductID"))){
            switchPagePushCartFailure();
            return;
        }
        switchPagePushCartSuccess();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        Button returnToMainButton = view.findViewById(R.id.button);

        shoppingCartRecyclerView = view.findViewById(R.id.shoppingCartRecyclerView);
        shoppingCartRecyclerView.setHasFixedSize(true);
        shoppingCartRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        productList = new ArrayList<>();
        cartAdapter = new CartAdapter(getContext(), productList,
                getActivity().getSupportFragmentManager());


        cm.getUserCart(MainActivity.currUser.getUsername()).thenAccept(res -> processCart(res));


        returnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new ShopperDashboardFragment();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        Button payOrderButton = view.findViewById(R.id.orderNowButton);
        payOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.getUserCart(MainActivity.currUser.getUsername()).thenAccept(res ->
                        convertCartToOrder(res));
            }
        });
        return view;
    }
    // Assuming you have the Product and ItemProductAdapter classes somewhere either in separate files or in this file.
}
