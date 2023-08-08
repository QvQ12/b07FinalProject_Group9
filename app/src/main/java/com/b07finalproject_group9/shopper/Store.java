package com.b07finalproject_group9.shopper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Store {
    private String storeName;

    public Store(String name){
        storeName = name;
    }

    public String getStoreName() {
        return storeName;
    }
}
