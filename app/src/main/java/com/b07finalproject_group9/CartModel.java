package com.b07finalproject_group9;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.objects.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

public class CartModel extends DatabaseModel{
    public void writeCartItem(String shoppername, String storename,
                   String prod_key, int quantity){
        /* Writes a product key to cart with a quantity quantity. */

        DatabaseReference db = fdb.getReference("Shopper-UserList/" + shoppername
            + "/cart/" + storename + "/" + prod_key);
        db.setValue(quantity);
    }

    public void removeCartItem(String shoppername, String storename,
                       String prod_key){
        /* Removes a product key to cart with a quantity quantity. */
        DatabaseReference db = fdb.getReference("Shopper-UserList/" + shoppername
                + "/cart/" + storename + "/" + prod_key);
        db.removeValue();
    }


    public CompletableFuture<Cart> getUserCart(String shoppername){
        /* Returns a CompletableFuture for a Cart corresponding to the specified user's cart */
        DatabaseReference db = fdb.getReference("Shopper-UserList" + shoppername + "/cart");
        CompletableFuture<Cart> res = new CompletableFuture<>();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                HashMap<String, HashMap<String, Integer>> h = new HashMap<>();

                if(!snapshot.exists()){
                    res.complete(null);
                    return;
                }
                for(DataSnapshot store : snapshot.getChildren()){
                    HashMap<String, Integer> products = new HashMap<>();
                    for(DataSnapshot item : store.getChildren()){
                        products.put(item.getKey(), (Integer) item.getValue());
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

    public void pushCartToOrderList(String shoppername, Cart cart){
        DatabaseReference db = fdb.getReference("Global-OrderList");
        String productID = db.push().getKey();
        db.child(productID).setValue(cart.CartContent);

    }


}
