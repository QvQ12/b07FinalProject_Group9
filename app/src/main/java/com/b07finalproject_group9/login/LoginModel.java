package com.b07finalproject_group9.login;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.DatabaseModel;
import com.b07finalproject_group9.objects.ShopperUser;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class LoginModel extends DatabaseModel {

    private void createNewStoreOwnerUser(String storename, String username, String password){
        /* Writes a new StoreOwner User to the database
         */
        StoreOwnerUser user = new StoreOwnerUser(storename, username, password);
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        db.child(username).setValue(user.createMap());
    }

    private void createNewShopperUser(String username, String password){
        /* Writes a new Shopper User to the database
         */
        ShopperUser user = new ShopperUser(username,
                password);
        DatabaseReference db = fdb.getReference("Shopper-UserList");
        db.child(username).setValue(user.createMap());
    }
    public CompletableFuture<Boolean> signUpShopperUser(String username, String password){
        /*  Creates a new SHOPPER user iff there is NOT an existing SHOPPER user
            with the same username, returns a completeablefuture which gives true if completed
            or false otherwise.
         */
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        DatabaseReference query = fdb.getReference("Shopper-UserList").child("");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(username)){
                    completableFuture.complete(false);
                } else{
                    createNewShopperUser(username, password);
                    completableFuture.complete(true);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                completableFuture.complete(false);
            }
        });
        return completableFuture;
    }
    public CompletableFuture<Boolean> signUpStoreOwner(String storename,
                                                       String username, String password) {
        /*  Creates a new STOREOWNER user iff there is NOT an existing STOREOWNER user
            with the same username OR storename, returns a completeablefuture which returns
            true if successful false otherwise.
         */
        DatabaseReference query = fdb.getReference("StoreOwner-UserList");
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(username) || snapshot.hasChild(storename)) {
                    completableFuture.complete(false);

                } else {
                    createNewStoreOwnerUser(storename, username, password);
                    completableFuture.complete(true);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                completableFuture.complete(false);
            }
        });
        return completableFuture;
    }

    public CompletableFuture<Boolean> loginShopper(String username, String password) {
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        DatabaseReference query = (FirebaseDatabase.getInstance().
                getReference("Shopper-UserList/"));

        query.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                boolean result = false;
                if (task.isSuccessful()) {
                    DataSnapshot ds = task.getResult();
                    String passwordFromDb = String.valueOf(ds.child("password").getValue());
                    result = passwordFromDb.equals(password);
                }
                completableFuture.complete(result);
            }
        });

        return completableFuture;
    }

    public CompletableFuture<Boolean> loginOwner(String username, String password) {
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        DatabaseReference query = (FirebaseDatabase.getInstance().
                getReference("StoreOwner-UserList/"));

        query.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                boolean result = false;
                if (task.isSuccessful()) {
                    DataSnapshot ds = task.getResult();
                    String passwordFromDb = String.valueOf(ds.child("password").getValue());
                    result = passwordFromDb.equals(password);
                }
                completableFuture.complete(result);
            }
        });

        return completableFuture;
    }


}
