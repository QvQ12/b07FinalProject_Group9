package com.b07finalproject_group9.shopper;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.b07finalproject_group9.databinding.FragmentDashboardBinding;
import com.b07finalproject_group9.R;


import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopperDashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    RecyclerView recyclerView;
    StoreAdapter StoreAdapter; //create a new adapter for that later
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
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}