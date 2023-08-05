package com.example.owner.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b07finalproject_group9.DatabaseModel;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.objects.ShopperUser;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.b07finalproject_group9.objects.StoreProduct;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class ProductModel extends DatabaseModel {

    /* to be edited*/

    public void createNewProduct(String name, int quantity, Double price, String description) {
        /* Writes a new Product to the database
         */
        StoreProduct p = new StoreProduct(name, quantity, price, description);
        DatabaseReference db = fdb.getReference("TO BE CHANGED");
//        TO BE CHANGED: db.child(username).setValue(user.createMap());
    }

    public CompletableFuture<Boolean> addNewProduct(String name, int quantity, double price, String description) {
        /*  Creates a new StoreProduct user iff there is NOT an existing product
            with the same productname, returns a completeablefuture which returns
            true if successful false otherwise.
         */
        DatabaseReference query = fdb.getReference("TO BE CHANGED");
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.hasChild(username)) {
//                    completableFuture.complete(false);

//                } else {
//                    createNewProduct(name, quantity, price, description);
//                    completableFuture.complete(true);

//                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                completableFuture.complete(false);
            }
        });
        return completableFuture;
    }
}
