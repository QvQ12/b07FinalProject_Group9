package com.b07finalproject_group9.shopper;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.databinding.FragmentDashboardBinding;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ProductInfo;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

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
            Log.i("SHOW STORE", stores.get(i));
        }

        recyclerView.setAdapter(StoreAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopper_dashboard, container, false);

//        //RECYCLER VIEW
        recyclerView = view.findViewById(R.id.storeList); // fix
        recyclerView.setHasFixedSize(true);
        storeNames = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        StoreAdapter = new StoreAdapter(getContext(), storeNames);

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