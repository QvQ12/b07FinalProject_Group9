package com.b07finalproject_group9.shopper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;

import com.b07finalproject_group9.R;


public class ShoppingCart extends Fragment {

    private RecyclerView shoppingCartRecyclerView;
    private ItemProductAdapter adapter;
    private List<Product> products = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        Button returnToMainButton = view.findViewById(R.id.button);

        shoppingCartRecyclerView = view.findViewById(R.id.shoppingCartRecyclerView);

        adapter = new ItemProductAdapter(products);
        shoppingCartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        shoppingCartRecyclerView.setAdapter(adapter);

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
