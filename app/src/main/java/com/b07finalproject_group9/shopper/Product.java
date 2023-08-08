package com.b07finalproject_group9.shopper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Product {

    private String productID;
    private String description;
    private double price;
    private String productName;
    private int quantity;

    private static final FirebaseDatabase database = FirebaseDatabase.getInstance("https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com");

    // Default constructor for Firebase
    public Product() {
    }

    // Constructor with parameters
    public Product(String productID, String description, double price, String productName, int quantity) {
        this.productID = productID;
        this.description = description;
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
    }

    // Get product details from Firebase for a specific product ID in a specific store
    public void getProductDetails(String storeName, String productID) {
        DatabaseReference databaseReference = database.getReference("StoreOwner-UserList")
                .child(storeName).child("Inventory").child(productID);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Assign the retrieved values
                Product product = dataSnapshot.getValue(Product.class);
                if (product != null) {
                    setProductID(product.getProductID());
                    setDescription(product.getDescription());
                    setPrice(product.getPrice());
                    setProductName(product.getProductName());
                    setQuantity(product.getQuantity());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle errors here
            }
        });
    }

    // Static method to fetch all products across all stores
    public static void getAllProducts(ValueEventListener listener) {
        DatabaseReference databaseReference = database.getReference("StoreOwner-UserList");
        databaseReference.addListenerForSingleValueEvent(listener);
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
