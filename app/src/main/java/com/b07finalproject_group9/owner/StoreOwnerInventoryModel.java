package com.b07finalproject_group9.owner;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.b07finalproject_group9.DatabaseModel;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class StoreOwnerInventoryModel extends DatabaseModel {
    public String addProductInventory( String store_username, String product_name,
                                     double price, int quantity, String description){
        /* Writes a new product to StoreOwner-UserList/store_username/Inventory then
         * returns a productID*/

        DatabaseReference db = fdb.getReference("StoreOwner-UserList/"
                + store_username +"/Inventory");
        String productID = db.push().getKey();
        HashMap<String, Object> productInfo = new HashMap<>();
        productInfo.put("ProductID", productID);
        productInfo.put("product_name", product_name);
        productInfo.put("price", price);
        productInfo.put("quantity", quantity);

        productInfo.put("description", description);
        db.child(productID).setValue(productInfo);

        return productID;
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

    public CompletableFuture<ArrayList<String>> getProductInventory(String store_username){
        /* Returns a CompleteableFuture holding an ArrayList of all products in store_username */
        DatabaseReference db = fdb.getReference("StoreOwner-UserList/" + store_username
                + "/Inventory/");
        CompletableFuture<ArrayList<String>> result = new CompletableFuture<>();


        db.addValueEventListener(new ValueEventListener() {
            ArrayList<String> KEYS = new ArrayList<>();

            @Override
            public void onDataChange(DataSnapshot snapshot){
                for(DataSnapshot childSnapshot : snapshot.getChildren()){
                    String key = childSnapshot.getKey();
                    KEYS.add(key);
                }
                result.complete(KEYS);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Throw error message to log
            }
        });

        return result;
    }

    public CompletableFuture<HashMap<String, String>> getSpecificProduct(String productID,
                                                                         String store_name){
        /* Returns a CompletableFuture holding a Hashmap with the details of a product.
         */
        CompletableFuture<HashMap<String,String>> result = new CompletableFuture<>();
        DatabaseReference db = fdb.getReference("StoreOwner-UserList/" + store_name +
                                                    "/Inventory/" + productID);
        db.addValueEventListener(new ValueEventListener() {
            HashMap<String, String> product = new HashMap<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot childSnapshot : snapshot.getChildren()){
                    String key = childSnapshot.getKey();
                    product.put(key, childSnapshot.getValue().toString());
                }
                result.complete(product);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Throw error message
                result.complete(product);
            }
        });

        return result;
    }


}
