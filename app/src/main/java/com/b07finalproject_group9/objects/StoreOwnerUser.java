package com.b07finalproject_group9.objects;

import java.util.HashMap;
import java.util.Map;

public class StoreOwnerUser {
    String username;
    String password;
    String storename;
    String inventoryID;

    public StoreOwnerUser(String storename, String username,
                          String password, String inventoryID){
        this.storename = storename;
        this.username = username;
        this.password = password;
        this.inventoryID = inventoryID;
    }

    public Map<String,String> createMap(){
        Map<String, String> storeInfo = new HashMap<>();
        storeInfo.put("username", username);
        storeInfo.put("password", password);
        storeInfo.put("storename", storename);
        storeInfo.put("inventoryID", inventoryID);
        return storeInfo;
    }


}
