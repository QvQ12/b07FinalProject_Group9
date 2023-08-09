package com.b07finalproject_group9.login.ownerlogin;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.login.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;

public class OwnerLoginPresenter extends BasePresenter<OwnerLoginFragment,OwnerLoginModel> {
    @Override
    public OwnerLoginModel getmModelInstance() {
        return new OwnerLoginModel(this);
    }
    public void performOwnerLogin(String username, String password){
        mModel.loginOwner(username, password)
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
