package com.b07finalproject_group9.objects;

import java.util.HashMap;
import java.util.Map;

public class ShopperUser {
    String username;
    String password;
    String userOrderID;

    public ShopperUser(String username, String password, String userOrderID){
        this.username = username;
        this.password = password;
        this.userOrderID = userOrderID;
        //The idea is to link the userOrderID with a list of Orders,

    }

    public Map<String,String> createMap(){
        Map<String, String> storeInfo = new HashMap<>();
        storeInfo.put("username", username);
        storeInfo.put("password", password);
        storeInfo.put("userOrderID", userOrderID);
        return storeInfo;
    }


}
