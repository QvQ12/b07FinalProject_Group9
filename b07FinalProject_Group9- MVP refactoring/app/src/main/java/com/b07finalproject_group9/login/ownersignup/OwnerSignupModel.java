package com.b07finalproject_group9.login.ownersignup;

import static com.b07finalproject_group9.DatabaseModel.fdb;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.mvpbase.BaseModel;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.CompletableFuture;

public class OwnerSignupModel extends BaseModel<OwnerSignupPresenter> {
    public OwnerSignupModel(OwnerSignupPresenter mPresenter) {
        super(mPresenter);
    }

    private void createNewStoreOwnerUser(String storename, String username, String password){
        /* Writes a new StoreOwner User to the database
         */
        StoreOwnerUser user = new StoreOwnerUser(storename, username, password);
        DatabaseReference db = fdb.getReference("StoreOwner-UserList");
        db.child(username).setValue(user.createMap());
    }

    public CompletableFuture<Boolean> signUpStoreOwner(String storename,
                                                       String username, String password) {
        /*  Creates a new STOREOWNER user iff there is NOT an existing STOREOWNER user
            with the same username OR storename, returns a completeablefuture which returns
            true if successful false otherwise.
         */
        DatabaseReference query = fdb.getReference("StoreOwner-UserList");
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(username) || snapshot.hasChild(storename)) {
                    completableFuture.complete(false);

                } else {
                    createNewStoreOwnerUser(storename, username, password);
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
