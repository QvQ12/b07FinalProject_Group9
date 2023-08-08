package com.b07finalproject_group9.objects;

import java.util.HashMap;
import java.util.Map;

public class StoreOwnerUser extends User{

    String storename;


    public StoreOwnerUser(String storename, String username,
                          String password){
        super(username, password);
        this.storename = storename;
    }

    public Map<String,String> createMap(){
        Map<String, String> storeInfo = new HashMap<>();
        storeInfo.put("username", getUsername());
        storeInfo.put("password", getPassword());
        storeInfo.put("storename", storename);
        return storeInfo;
    }


}
