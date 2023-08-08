package com.b07finalproject_group9.login.shoppersignup;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;
import com.tempfragments.ShopperDashboard;

public class ShopperSignupPresenter extends BasePresenter<ShopperSignupFragment,ShopperSignupModel> {
    @Override
    public ShopperSignupModel getmModelInstance() {
        return new ShopperSignupModel(this);
    }
    public void performShopperSignUp(String username, String password){
        mModel.signUpShopperUser(username, password)
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
