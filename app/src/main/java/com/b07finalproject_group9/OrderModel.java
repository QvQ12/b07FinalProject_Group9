package com.b07finalproject_group9;

import android.provider.ContactsContract;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.objects.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.snapshot.BooleanNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class OrderModel extends DatabaseModel{

    public CompletableFuture<ArrayList<String>> getOrderKeysFromShopper(String username){
        DatabaseReference db = fdb.getReference("Shopper-UserList").child(username)
                .child("orders");
        CompletableFuture<ArrayList<String>> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {

            ArrayList<String> list = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!snapshot.exists()){
                    res.complete(null);
                    return;
                }

                for(DataSnapshot child : snapshot.getChildren()){
                    list.add(child.getKey());
                }
                res.complete(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });
        return res;
    }

    public CompletableFuture<ArrayList<String>> getOrderKeysFromStoreOwner(String username){
        DatabaseReference db = fdb.getReference("StoreOwner-UserList")
                .child(username).child("orders");
        CompletableFuture<ArrayList<String>> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {

            ArrayList<String> list = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(!snapshot.exists()){
                    res.complete(null);
                    return;
                }

                for(DataSnapshot child : snapshot.getChildren()){
                    list.add(child.getKey());
                }
                res.complete(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });
        return res;
    }


    void setOrderStatusByStore(String orderKey, String storename, Boolean status){
        DatabaseReference db = fdb.getReference();
        db.child("Global-OrderList").child(orderKey).
                child(storename).child("STATUS").setValue(status);
    }

    public CompletableFuture<Boolean> getOrderStatusForShopper(String orderKey){
        /* RETURNS TRUE if all  store statuses are TRUE in Global-OrderList/orderKey  */
        DatabaseReference db = fdb.getReference("Global-OrderList").child(orderKey);
        CompletableFuture<Boolean> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot store : snapshot.getChildren()){
                    String storeStatus = store.child("STATUS").getValue().toString();
                    Log.i("completed", storeStatus);
                    if(storeStatus.equals("0")) {
                        res.complete(false);
                        return;
                    }
                }
                res.complete(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(false);
            }
        });
        return res;
    }

    public void setStatusOwner(String orderID, String owner, String msg){
        // Writes msg to STATUS
        DatabaseReference db = fdb.getReference();
        CompletableFuture<Boolean> res = new CompletableFuture<>();
        db.child("StoreOwner-UserList").child(owner)
                .child("orders").child(orderID).setValue(msg);

        db.child("Global-OrderList").child(orderID).child(owner)
                .child("STATUS").setValue(msg);


    }


    public CompletableFuture<Boolean> getStatusOwner(String orderID, String owner){
        // Returns true if StoreOwner-List/orderID/STATUS is 1
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        CompletableFuture<Boolean> res = new CompletableFuture<>();

        db.child(owner).child("orders").child(orderID).child("STATUS")
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    if(snapshot.getValue().toString().equals("1")){
                        Log.i("COMPLETED", snapshot.getValue().toString());
                        res.complete(true);
                    }
                    return;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(false);
            }
        });
        return res;
    }

    public CompletableFuture<ArrayList<String>> getProductIDOrderStoreOwner(String orderID,
                                                                               String store){
        CompletableFuture<ArrayList<String>> res = new CompletableFuture<>();

        DatabaseReference db = fdb.getReference("Global-OrderList").child(orderID).child(store);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> arr = new ArrayList<>();
                for(DataSnapshot productID : snapshot.getChildren()){
                    if(!productID.getKey().toString().equals("STATUS")) {
                        arr.add(productID.getKey().toString());
                    }
                }
                res.complete(arr);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });

        return res;
    }

    public CompletableFuture<ArrayList<String>> getProductIDbyOrder(String orderID){
        CompletableFuture<ArrayList<String>> res = new CompletableFuture<>();

        DatabaseReference db = fdb.getReference("Global-OrderList").child(orderID);
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<String> list = new ArrayList<>();

                for(DataSnapshot child : snapshot.getChildren()){
                    for(DataSnapshot ID : child.getChildren()){
                        if(!ID.getKey().equals("STATUS")){
                            list.add(ID.getKey());
                        }
                    }
                }
                res.complete(list);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });

        return res;
    }



}
