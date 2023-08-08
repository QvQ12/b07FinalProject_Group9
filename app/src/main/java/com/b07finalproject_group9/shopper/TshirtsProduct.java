package com.b07finalproject_group9.shopper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.b07finalproject_group9.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class TshirtsProduct extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tshirts_product, container, false);

        recyclerView = view.findViewById(R.id.tshirts_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        fetchProductsFromFirebase();

        return view;
    }

    private void fetchProductsFromFirebase() {
        DatabaseReference rootReference = FirebaseDatabase.getInstance("https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com")
                .getReference("StoreOwner-UserList");

        rootReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                productList.clear();

                // Loop through each user
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {

                    // Access the 'inventory' of each user
                    DataSnapshot inventorySnapshot = userSnapshot.child("inventory");

                    // Loop through products under this 'inventory'
                    for (DataSnapshot productSnapshot : inventorySnapshot.child("products").getChildren()) {
                        Product product = productSnapshot.getValue(Product.class);
                        if (product != null) {
                            productList.add(product);
                        }
                    }
                }

                // Now, update the adapter and RecyclerView outside the user loop
                productAdapter = new ProductAdapter(productList);
                recyclerView.setAdapter(productAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors here
            }
        });
    }
}

