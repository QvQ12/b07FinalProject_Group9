package com.b07finalproject_group9.owner;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class StoreOwnerInventoryModel extends StoreOwnerModel{
    public void addProductInventory( String store_username, String product_name,
                                     double price, int quantity){
        /* Writes a new product to StoreOwner-UserList/store_username/Inventory */

        DatabaseReference db = fdb.getReference("StoreOwner-UserList/"
                + store_username +"/Inventory");
        String productID = db.push().getKey();
        HashMap<String, Object> productInfo = new HashMap<>();
        productInfo.put("ProductID", productID);
        productInfo.put("product_name", product_name);
        productInfo.put("price", price);
        productInfo.put("quantity", quantity);
        db.child(productID).setValue(productInfo);
    }


    public void editProductInventory(String store_username, String productID,
                                     String new_product_name, double new_price, int new_quantity){
        /* Replaces values in an existing product in
            StoreOwner-UserList/store_username/Inventory/productID          */

        DatabaseReference db = fdb.getReference("StoreOwner-UserList/"
                + store_username +"/Inventory/" + productID);

        db.child("product_name").setValue(new_product_name);
        db.child("price").setValue(Double.toString(new_price));
        db.child("quantity").setValue(Integer.toString(new_quantity));

    }

    public CompletableFuture<List<String>> getProductInventory(String store_username){
        /* Returns a CompleteableFuture holding a List of all products in store_username */
        DatabaseReference db = fdb.getReference("StoreOwner-UserList/" + store_username
                + "/Inventory");
        CompletableFuture<List<String>> result;


        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.i("Check", "onChildAdded:" + snapshot.getKey());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.i("Check", "onChildChanged:" + snapshot.getKey());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                Log.i("Check", "onChildRemoved:" + snapshot.getKey());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Log.i("Check", "onChildMoved:" + snapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.i("Check", "onCancelled", error.toException());

            }
        });



        return null;


    }


}
