package com.b07finalproject_group9;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.objects.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class OrderModel extends DatabaseModel{

    void setOrderStatusByStore(String orderKey, String storename, Boolean status){
        DatabaseReference db = fdb.getReference();
        db.child("Global-OrderList").child(orderKey).
                child(storename).child("STATUS").setValue(status);
    }

     CompletableFuture<Boolean> getOrderStatusForShopper(String orderKey){
        /* RETURNS TRUE if all  store statuses are TRUE in Global-OrderList/orderKey  */
        DatabaseReference db = fdb.getReference("Global-OrderList");
        CompletableFuture<Boolean> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot store : snapshot.getChildren()){
                    if(!((Boolean) (store.child("STATUS").getValue()))){
                        res.complete(false);
                        return;
                    }
                    res.complete(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(false);
            }
        });
        return res;
    }

}
