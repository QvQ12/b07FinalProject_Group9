package com.b07finalproject_group9.objects;

import com.b07finalproject_group9.shopper.Product;

import java.util.HashMap;

public class ProductInfo {

    String productName;
    String productQuantity;
    String productPrice;
    String productDescription;
    String productId;


    public ProductInfo(HashMap<String, String> map, String id){
        productName = map.get("product_name");
        productQuantity = map.get("quantity");
        productPrice = map.get("price");
        productDescription = map.get("description");
        productId = id;

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

    public String getProductId() {
        return productId;
    }
}
