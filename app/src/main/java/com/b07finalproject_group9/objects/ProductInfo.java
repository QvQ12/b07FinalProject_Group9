package com.b07finalproject_group9.objects;

import java.util.HashMap;

public class ProductInfo {

    String productName;
    String productQuantity;
    String productPrice;
    String productDescription;

    public ProductInfo(HashMap<String, String> map){
        productName = map.get("product_name");
        productQuantity = map.get("quantity");
        productPrice = map.get("price");
        productDescription = map.get("description");

    }


    public String getProductName() {
        return productName;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }




}
