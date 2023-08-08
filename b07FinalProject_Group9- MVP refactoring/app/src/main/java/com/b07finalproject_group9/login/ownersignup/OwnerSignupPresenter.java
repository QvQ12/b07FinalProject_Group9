package com.b07finalproject_group9.login.ownersignup;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;
import com.tempfragments.ShopperDashboard;

public class OwnerSignupPresenter extends BasePresenter<OwnerSignupFragment,OwnerSignupModel> {
    @Override
    public OwnerSignupModel getmModelInstance() {
        return new OwnerSignupModel(this);
    }
    public void performOwnerSignUp(String storename, String username, String password){
        mModel.signUpStoreOwner(storename, username, password)
                .thenAccept(success -> {
                    if (success) {
                        MainActivity.currUser = new User(username);
                        mView.successView();
                    } else {
                        mView.unsuccessView();
                    }
                });
    }
}
