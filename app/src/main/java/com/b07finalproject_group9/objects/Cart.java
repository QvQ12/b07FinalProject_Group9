package com.b07finalproject_group9.objects;

import java.util.HashMap;

public class Cart {

    String storeName;
    String productName;
    String Quantity;
    String Price;
    String Description;
    String productId;


    public HashMap<String, HashMap<String, Integer>> CartContent;

    public Cart(HashMap<String, HashMap<String, Integer>> CartContent){
        this.CartContent = CartContent;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public String getPrice() {
        return Price;
    }

    public String getDescription() {
        return Description;
    }

    public String getProductId() {
        return productId;
    }
}
