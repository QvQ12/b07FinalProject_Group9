package com.b07finalproject_group9;
import com.b07finalproject_group9.objects.ShopperUser;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class DatabaseModel {

    private static String ACTIVITY_KEY = "https://b07finalprojectgroup9-42c62-default-rtdb.firebaseio.com/";
    public static FirebaseDatabase fdb = FirebaseDatabase.getInstance(ACTIVITY_KEY);

}