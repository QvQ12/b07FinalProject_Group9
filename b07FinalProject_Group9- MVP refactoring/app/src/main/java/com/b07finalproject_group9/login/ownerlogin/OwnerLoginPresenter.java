package com.b07finalproject_group9.login.ownerlogin;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.mvpbase.BasePresenter;
import com.b07finalproject_group9.objects.User;
import com.b07finalproject_group9.owner.OwnerDashboardFragment;

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
