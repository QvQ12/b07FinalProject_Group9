package com.b07finalproject_group9;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Objects;


public class DatabaseModel {
    private String ACTIVITY_KEY = "https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com/";
    FirebaseDatabase fdb = FirebaseDatabase.getInstance(ACTIVITY_KEY);
    DatabaseReference db = fdb.getReference();


    public void storeSignUp(String username, String password){
        DatabaseReference storeRef = db.child("StoreOwnerList");
        HashMap<String, String> ownerInfo = new HashMap<>();
        ownerInfo.put("storeId", username);
        ownerInfo.put("password", password);
        storeRef.child(username).setValue(ownerInfo);
    }
    public void shopperSignUp(String username, String password){
        DatabaseReference shopperRef = db.child("ShopperList");
        HashMap<String, String> shopperInfo = new HashMap<>();
        shopperInfo.put("ShopperId", username);
        shopperInfo.put("password", password);
        shopperRef.child(username).setValue(shopperInfo);
    }
    public void addProduct(String name, String store, double price, int quantity){
        String productId;
        DatabaseReference productRef = db.child("ProductList");
        productId = FirebaseDatabase.getInstance().getReference().child("ProductList").push().getKey();
        HashMap<String, Object> productInfo = new HashMap<>();
        productInfo.put("ProductID", productId);
        productInfo.put("name", name);
        productInfo.put("store", store);
        productInfo.put("price", price);
        productInfo.put("quantity", quantity);
        productRef.child(productId).setValue(productInfo);
    }
    public void addOrder(String store, int quantity) {
        String orderId;
        DatabaseReference shopperRef = db.child("OrderList");
        orderId = FirebaseDatabase.getInstance().getReference().child("OrderList").push().getKey();
        HashMap<String, Object> orderInfo = new HashMap<>();
        orderInfo.put("OrderId", orderId);
        orderInfo.put("store", store);
        orderInfo.put("quantity", quantity);
        shopperRef.child(orderId).setValue(orderInfo);
    }
}