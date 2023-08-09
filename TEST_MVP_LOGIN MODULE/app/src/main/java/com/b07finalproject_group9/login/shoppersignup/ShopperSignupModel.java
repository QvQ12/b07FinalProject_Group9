package com.b07finalproject_group9.login.shoppersignup;

import static com.b07finalproject_group9.DatabaseModel.fdb;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.login.mvpbase.BaseModel;
import com.b07finalproject_group9.objects.ShopperUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class ShopperSignupModel extends BaseModel<ShopperSignupPresenter> {
    public ShopperSignupModel(ShopperSignupPresenter mPresenter) {
        super(mPresenter);
    }

    private void createNewShopperUser(String username, String password){
        /* Writes a new Shopper User to the database
         */
        ShopperUser user = new ShopperUser(username,
                password);
        DatabaseReference db = fdb.getReference("Shopper-UserList");
        db.child(username).setValue(user.createMap());
    }

    public CompletableFuture<Boolean> signUpShopperUser(String username, String password){
        /*  Creates a new SHOPPER user iff there is NOT an existing SHOPPER user
            with the same username, returns a completeablefuture which gives true if completed
            or false otherwise.
         */
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        DatabaseReference query = fdb.getReference("Shopper-UserList").child("");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(username)){
                    completableFuture.complete(false);
                } else{
                    createNewShopperUser(username, password);
                    completableFuture.complete(true);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                completableFuture.complete(false);
            }
        });
        return completableFuture;
    }
}
