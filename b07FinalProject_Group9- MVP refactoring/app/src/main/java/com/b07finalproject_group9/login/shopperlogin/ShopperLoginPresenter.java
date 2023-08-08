package com.b07finalproject_group9.login.shopperlogin;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;
import com.tempfragments.ShopperDashboard;

public class ShopperLoginPresenter extends BasePresenter<ShopperLoginFragment,ShopperLoginModel> {
    @Override
    public ShopperLoginModel getmModelInstance() {
        return new ShopperLoginModel(this);
    }
    public void performShopperLogin(String username, String password){
        mModel.loginShopper(username, password)
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
