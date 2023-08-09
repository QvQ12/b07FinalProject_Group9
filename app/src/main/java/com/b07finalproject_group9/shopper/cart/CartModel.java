package com.b07finalproject_group9.shopper.cart;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.b07finalproject_group9.DatabaseModel;
import com.b07finalproject_group9.objects.Cart;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.color.utilities.DislikeAnalyzer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class CartModel extends DatabaseModel {
    public void writeCartItem(String shoppername, String storename,
                   String prod_key, int quantity){
        /* Writes a product key to cart with a quantity quantity. */

        DatabaseReference db = fdb.getReference("Shopper-UserList/" + shoppername
            + "/cart/" + storename + "/" + prod_key);
        db.setValue(quantity);

        getUserCart(shoppername).thenAccept(res->validateCart(res, shoppername));
    }


    public CompletableFuture<Cart> getUserCart(String shoppername){
        /* Returns a CompletableFuture for a Cart corresponding to the specified user's cart */
        DatabaseReference db = fdb.getReference("Shopper-UserList/" + shoppername + "/cart");
        CompletableFuture<Cart> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, HashMap<String, Integer>> h = new HashMap<>();
                for(DataSnapshot store : snapshot.getChildren()){
                    HashMap<String, Integer> products = new HashMap<>();
                    for(DataSnapshot item : store.getChildren()){
                        products.put(item.getKey(), Integer.parseInt(item.getValue().toString()));
                    }
                    h.put(store.getKey(), products);
                }
                Cart cart = new Cart(h);
                res.complete(cart);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                res.complete(null);
            }
        });
        return res;
    }


    private void validateCart(Cart cart, String shopper){
        for(String store : cart.CartContent.keySet()){
            for(String item : cart.CartContent.get(store).keySet()){
                if(cart.CartContent.get(store).get(item) < 1){
                    DatabaseReference db = fdb.getReference("StoreOwner-UserList");
                    db.child(shopper).child("cart").child(store).child(item).removeValue();
                }
            }
        }
    }



    private void processCartThenPush(String shopper, Cart cart, String orderID, DatabaseReference db){
        //Copy cart to global orders list
        for(String store : cart.CartContent.keySet()){
            cart.CartContent.get(store).put("STATUS", 0);
            //Give order reference to each store mentioned in the keyset.
            db.child("StoreOwner-UserList").child(store).child("orders")
                    .child(orderID).setValue(0);
        }
        db.child("Global-OrderList").child(orderID).setValue(cart.CartContent);

        //delete cart from shopper
        db.child("Shopper-UserList").child(shopper).child("cart").setValue(null);


    }
    public void pushCartToOrderList(String shoppername){
        DatabaseReference db = fdb.getReference();
        String orderID = db.push().getKey();
        getUserCart(shoppername).thenAccept(res->
                processCartThenPush(shoppername, res, orderID, db));

        //Give reference to order to shopper
        db.child("Shopper-UserList").child(shoppername)
                .child("orders").child(orderID).setValue(0);

    }


}
