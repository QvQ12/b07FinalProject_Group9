package com.b07finalproject_group9.objects;

import java.util.HashMap;
import java.util.Map;

public class ShopperUser extends User{


    public ShopperUser(String username, String password){
        super(username, password);
        //The idea is to link the userOrderID with a list of Orders,

    }

    public Map<String,String> createMap(){
        Map<String, String> storeInfo = new HashMap<>();
        storeInfo.put("username", getUsername());
        storeInfo.put("password", getPassword());
        return storeInfo;
    }


}
