package com.b07finalproject_group9;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DatabaseModel {
    private String ACTIVITY_KEY = "https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com/";
    FirebaseDatabase fdb = FirebaseDatabase.getInstance(ACTIVITY_KEY);
    DatabaseReference db = fdb.getReference();


    public void storeSignUp(String username, String password){
        db.child("user1").setValue("John");
    }
    public void shopperSignUp(String username, String password){

    }
    public void addProduct(String name, String brand, double price, int quantity){
    }
    public void addOrder(String id, int quantity) {
    }





}