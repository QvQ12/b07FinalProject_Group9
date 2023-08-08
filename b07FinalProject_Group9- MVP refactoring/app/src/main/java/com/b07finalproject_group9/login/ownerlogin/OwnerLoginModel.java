package com.b07finalproject_group9.login.ownerlogin;

import static com.b07finalproject_group9.DatabaseModel.fdb;

import androidx.annotation.NonNull;

import com.b07finalproject_group9.mvpbase.BaseModel;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.CompletableFuture;

public class OwnerLoginModel extends BaseModel<OwnerLoginPresenter> {
    public OwnerLoginModel(OwnerLoginPresenter mPresenter) {
        super(mPresenter);
    }

    public CompletableFuture<Boolean> loginOwner(String username, String password) {
        CompletableFuture<Boolean> completableFuture = new CompletableFuture<>();
        DatabaseReference query = (FirebaseDatabase.getInstance().
                getReference("StoreOwner-UserList/"));

        query.child(username).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                boolean result = false;
                if (task.isSuccessful()) {
                    DataSnapshot ds = task.getResult();
                    String passwordFromDb = String.valueOf(ds.child("password").getValue());
                    result = passwordFromDb.equals(password);
                }
                completableFuture.complete(result);
            }
        });
        StoreOwnerUser thisUser = new StoreOwnerUser("", username, password);
//        DatabaseModel.currentOwner = thisUser;

        return completableFuture;
    }


}
