package com.b07finalproject_group9.shopper.cart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.shopper.dashboard.ShopperDashboardFragment;
import com.b07finalproject_group9.shopper.dashboard.ShopperProductPage;


public class AddProductToCart extends Fragment {

    String storeName, productID;

    public AddProductToCart(String storeName, String productID){
        this.storeName = storeName;
        this.productID = productID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_product_to_cart, container, false);
        Button AddToCart = view.findViewById(R.id.AddToCart);
        EditText quantity = view.findViewById(R.id.cartQuantityEditText);
        String currStoreName = ShopperProductPage.storeName;
        CartModel cm = new CartModel();

        AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                int quant = Integer.parseInt(quantity.getText().toString());
//                cm.writeCartItem(MainActivity.currUser.getUsername(), storeName, productID, quant);
//                Fragment someFragment = new ShoppingCart();
//                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
//                transaction.replace(R.id.main_login_redirect, someFragment).commit();
//                transaction.addToBackStack(null);
                String input = quantity.getText().toString().trim();

                if (input.isEmpty()) {
                    // Empty input, show a warning
                    quantity.setError("Please enter a quantity");
                    return;
                }

                try {
                    int quant = Integer.parseInt(input);
                    // Input is a valid number
                    cm.writeCartItem(MainActivity.currUser.getUsername(), storeName, productID, quant);
                    Fragment someFragment = new ShoppingCart();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_login_redirect, someFragment).commit();
                    transaction.addToBackStack(null);
                } catch (NumberFormatException e) {
                    // Input is not a valid number, show a warning
                    quantity.setError("Please enter a valid quantity");
                }
            }
        });

        Button cancel = view.findViewById(R.id.back_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new ShopperDashboardFragment();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });


        return view;
    }
}