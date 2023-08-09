package com.b07finalproject_group9.shopper;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.DatabaseModel;
import com.b07finalproject_group9.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class ShopperModel extends DatabaseModel {

    public CompletableFuture<String> getStoreBasedOnProductID(String productID){
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        CompletableFuture<String> res = new CompletableFuture<>();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot store : snapshot.getChildren()){
                    if(store.child("Inventory").exists() &&
                            store.child("Inventory").hasChild(productID)){
                        res.complete(store.getKey());
                        return;
                    }
                }
                res.complete(null);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });



        return res;
    }
    public CompletableFuture<ArrayList<String>> getStoreNames(){
        /* Returns a CompletableFuture for An arraylist holding all the store names in GlobalList.
         */
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        CompletableFuture<ArrayList<String>> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> names = new ArrayList<>();
                for(DataSnapshot store : snapshot.getChildren()){
                    names.add(store.getKey());
                }
                res.complete(names);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });

        return res;
    }

}
