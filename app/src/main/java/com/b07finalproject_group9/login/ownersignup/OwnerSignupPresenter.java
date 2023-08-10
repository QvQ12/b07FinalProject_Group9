package com.b07finalproject_group9.login.ownersignup;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.login.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;

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
