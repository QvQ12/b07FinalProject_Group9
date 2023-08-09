package com.b07finalproject_group9.shopper.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.b07finalproject_group9.databinding.FragmentDashboardBinding;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.Store;
import com.b07finalproject_group9.owner.ui.dashboard.AddNewProduct;
import com.b07finalproject_group9.shopper.ShopperModel;
import com.b07finalproject_group9.shopper.cart.ShoppingCart;
import com.b07finalproject_group9.shopper.dashboard.StoreAdapter;
import com.b07finalproject_group9.shopper.order.OrderDashboard;


import java.util.ArrayList;

public class ShopperDashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    Button cartPage;
    Button orderPage;
    RecyclerView recyclerView;
    com.b07finalproject_group9.shopper.dashboard.StoreAdapter StoreAdapter; //create a new adapter for that later
    ArrayList<Store> storeNames;//make the class store, jsut a store name
    public ShopperDashboardFragment(){}
    private void processStoreNames(ArrayList<String> stores){
        for(int i = 0; i < stores.size(); i++){
            storeNames.add(new Store(stores.get(i)));
        }
        recyclerView.setAdapter(StoreAdapter);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopper_dashboard, container, false);
        recyclerView = view.findViewById(R.id.storeList);
        recyclerView.setHasFixedSize(true);
        storeNames = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        StoreAdapter = new StoreAdapter(getContext(), storeNames, getActivity().getSupportFragmentManager());
        ShopperModel sm = new ShopperModel();
        sm.getStoreNames().thenAccept(res-> processStoreNames(res));

        cartPage = view.findViewById(R.id.CartButton);
        cartPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment someFragment = new ShoppingCart();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_login_redirect, someFragment).commit();
                transaction.addToBackStack(null);
                Toast.makeText(getActivity(), "going to cart : ",Toast.LENGTH_SHORT).show();
            }
        });
        orderPage = view.findViewById(R.id.OrderPageButton);
        orderPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment someFragment = new OrderDashboard();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_login_redirect, someFragment).commit();
                transaction.addToBackStack(null);
                Toast.makeText(getActivity(), "going to orders edited: ",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}