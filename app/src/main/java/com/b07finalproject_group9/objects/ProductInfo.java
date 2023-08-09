package com.b07finalproject_group9.objects;

import java.util.HashMap;

public class ProductInfo {

    public String productName;
    public String productQuantity;
    public String productPrice;
    public String productDescription;
    public String productId;

    public ProductInfo(String productName, String productQuantity,
                       String productPrice, String productDescription, String productId) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productId = productId;
    }



    public ProductInfo(HashMap<String, String> map, String id){
        productName = map.get("product_name");
        productQuantity = map.get("quantity");
        productPrice = map.get("price");
        productDescription = map.get("description");
        productId = id;

    }

    public ProductInfo(HashMap<String, String> map) {
        productName = map.get("product_name");
        productQuantity = map.get("quantity");
        productPrice = map.get("price");
        productDescription = map.get("description");
        productId = map.get("ProductID");
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
