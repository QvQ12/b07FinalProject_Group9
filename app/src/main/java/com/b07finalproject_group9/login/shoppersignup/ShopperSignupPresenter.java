package com.b07finalproject_group9.login.shoppersignup;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.login.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;

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
