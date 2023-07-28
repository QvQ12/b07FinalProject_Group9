package com.b07finalproject_group9;

import android.util.Log;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.objects.ShopperUser;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class LoginModel extends DatabaseModel{

    private void createNewStoreOwnerUser(String storename, String username, String password){
        StoreOwnerUser user = new StoreOwnerUser(storename, username, password, "TODO make a function that creates this");
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        db.child(username).setValue(user.createMap());
    }

    private void createNewShopperUser(String username, String password){
        ShopperUser user = new ShopperUser(username, password,"TODO make a function that creates");
        DatabaseReference db = fdb.getReference("Shopper-UserList");
        db.child(username).setValue(user.createMap());
    }

    public void signUpShopperUser(String username, String password){
        DatabaseReference query = fdb.getReference("Shopper-UserList").child("");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(username)){
                    //Login message to say "username" is already used
                } else{
                    createNewShopperUser(username, password);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                    //Error message to say error occured
            }
        });

    }
    public void signUpStoreOwner(String storename, String username, String password) {
        DatabaseReference query = fdb.getReference("StoreOwner-UserList");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(username) || snapshot.hasChild(storename)) {
                    //Login message to say "username" is already used
                } else {
                    createNewStoreOwnerUser(storename, username, password);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                //Error message to say error occured
            }
        });
    }



}
