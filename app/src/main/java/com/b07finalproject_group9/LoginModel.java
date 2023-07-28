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
        /* Writes a new StoreOwner User to the database
         */
        StoreOwnerUser user = new StoreOwnerUser(storename, username, password, "TODO make a function that creates this");
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        db.child(username).setValue(user.createMap());
    }

    private void createNewShopperUser(String username, String password){
        /* Writes a new Shopper User to the database
         */
        ShopperUser user = new ShopperUser(username, password,"TODO make a function that creates");
        DatabaseReference db = fdb.getReference("Shopper-UserList");
        db.child(username).setValue(user.createMap());
    }

    public void signUpShopperUser(String username, String password, int[] signal){
        /*  Creates a new SHOPPER user iff there is NOT an existing SHOPPER user
            with the same username, changes signal[0] to 0 if it does successfully
            create a new user, -1 otherwise.
         */
        DatabaseReference query = fdb.getReference("Shopper-UserList").child("");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(username)){
                    //Login message to say "username" is already used
                    signal[0] = -1;
                } else{
                    createNewShopperUser(username, password);
                    signal[0] = 1;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                    //Error message to say error occured
            }
        });

    }
    public void signUpStoreOwner(String storename, String username, String password, int[] signal) {
        /*  Creates a new STOREOWNER user iff there is NOT an existing STOREOWNER user
            with the same username OR storename, changes signal[0] to 0 if it does successfully
            create a new user, -1 otherwise.
         */
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
