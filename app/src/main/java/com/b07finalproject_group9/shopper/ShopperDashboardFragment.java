package com.b07finalproject_group9.shopper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;  // Import for the Menu button
import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.b07finalproject_group9.R;

import com.b07finalproject_group9.login.ShopperLoginFragment;
import com.b07finalproject_group9.shopper.ProductExample;
import com.b07finalproject_group9.shopper.ShopperOrder;
import com.b07finalproject_group9.shopper.ShoppingCart;

public class ShopperDashboardFragment extends Fragment {

    private ImageView tShirtsImage;
    private ImageView shoppingCartImage;
    private ImageView readyForPickUpImage;
//    private Button menuButton;  // Declaration for the Menu button

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopper_dashboard, container, false);


        tShirtsImage = view.findViewById(R.id.t_shirts); //categories
        shoppingCartImage = view.findViewById(R.id.shopping_cart); //cart
        readyForPickUpImage = view.findViewById(R.id.ready_for_pick_up); //orders
//        menuButton = view.findViewById(R.id.button);  // Initialization for the Menu button.

        tShirtsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ProductExample fragment when tShirtsImage is clicked
                Fragment f = new ProductExample();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        shoppingCartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ShoppingCart fragment when shoppingCartImage is clicked
                Fragment f = new ShoppingCart();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        readyForPickUpImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the ShopperOrder activity when readyForPickUpImage is clicked
                Fragment f = new ShopperOrder();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        // Set the onClick listener for the Menu button to open MainActivity
//        menuButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment f = new ShopperLoginFragment();
//                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                ft.replace(R.id.main_login_redirect, f).commit();
//            }
//        });

        return view;
    }
}