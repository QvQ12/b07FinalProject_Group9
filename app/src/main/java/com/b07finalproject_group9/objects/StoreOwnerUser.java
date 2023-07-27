package com.b07finalproject_group9.objects;

import com.b07finalproject_group9.DatabaseModel;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class StoreOwnerUser extends DatabaseModel {
    String StoreUser;
    String password;
//    public StoreOwnerUser(String username, String password){
//        StoreUser = username;
//        this.password = password;
//    }
//    public void storeSignUp(String username, String password){
//        DatabaseReference storeRef = db.child("StoreOwnerList");
//        HashMap<String, String> userData = new HashMap<>();
//        userData.put("password", password);
//        storeRef.child(username).setValue(userData);
//    }
}
