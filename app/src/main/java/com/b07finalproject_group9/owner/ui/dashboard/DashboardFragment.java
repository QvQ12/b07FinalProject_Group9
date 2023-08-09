package com.b07finalproject_group9.owner.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    Button add;
    RecyclerView recyclerView;
    StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();
    ProductAdapter productAdapter;
    ArrayList<ProductInfo> storeInventory;
    public DashboardFragment(){}

    private void processInventory(ArrayList<String> res){
        for(int i = 0; i < res.size(); i++){
            String productId = res.get(i);
            sm.getSpecificProduct(productId, MainActivity.currUser.getUsername()).
                    thenAccept(prod -> addItemToLocalInventory(storeInventory,
                                                                new ProductInfo(prod, productId)));

        }
    }

    private void addItemToLocalInventory(ArrayList<ProductInfo> inventory, ProductInfo prod){

        inventory.add(prod);
        recyclerView.setAdapter(productAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        add = view.findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment someFragment = new AddNewProduct();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, someFragment).commit();
                transaction.addToBackStack(null);
            }
        });
//        //RECYCLER VIEW
        recyclerView = view.findViewById(R.id.productList); // fix
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        storeInventory = new ArrayList<>();
        productAdapter = new ProductAdapter(getContext(), storeInventory,getActivity().getSupportFragmentManager());


        sm.getProductInventory(MainActivity.currUser.getUsername()).
                thenAccept(res-> processInventory(res));

        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}