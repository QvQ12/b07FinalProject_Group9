package com.b07finalproject_group9.objects;

import java.util.HashMap;

public class Cart {
    public HashMap<String, HashMap<String, Integer>> CartContent;

    public Cart(HashMap<String, HashMap<String, Integer>> CartContent){
        this.CartContent = CartContent;
    }


}
