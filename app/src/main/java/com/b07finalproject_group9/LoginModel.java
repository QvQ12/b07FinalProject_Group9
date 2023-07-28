package com.b07finalproject_group9;

import com.b07finalproject_group9.objects.ShopperUser;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class LoginModel extends DatabaseModel{

    public void createNewStoreOwnerUser(String storename, String username, String password){
        StoreOwnerUser user = new StoreOwnerUser(storename, username, password, "TODO make a function that creates this");
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        db.child(username).setValue(user.createMap());
    }


    public void createNewShopperUser(String username, String password){
        ShopperUser user = new ShopperUser(username, password,"TODO make a function that creates");
        DatabaseReference db = fdb.getReference("Shopper-UserList");
        db.child(username).setValue(user.createMap());
    }

    public boolean checkExistingShopperUser(String username){
        final boolean[] exists = new boolean[1];
        DatabaseReference db = fdb.getReference();
        DatabaseReference query = db.child("Shopper-UserList").child(username);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                exists[0] = snapshot.exists();
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
//        fdb.getReference().child("LoginModel").child("ShopperTest").child(username).setValue(exists[0]);

        return exists[0];
    }

    public boolean checkExistingStoreOwnerUser(String username){
        final boolean[] exists = new boolean[1];
        DatabaseReference db = fdb.getReference();
        DatabaseReference query = db.child("StoreOwner-UserList").child(username);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                exists[0] = snapshot.exists();
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });

//        fdb.getReference().child("LoginModel").child("StoreTest").child(username).setValue(exists[0]);

        return exists[0];
    }

}
