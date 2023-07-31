package com.b07finalproject_group9.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.b07finalproject_group9.LoginModel;
import com.b07finalproject_group9.R;
import com.tempfragments.ShopperDashboard;

public class OwnerSignUpFragment extends Fragment {

    private void performOwnerSignUp(String username, String password){
        LoginModel lm = new LoginModel();
        lm.signUpStoreOwner("add another edittext", username, password)
                .thenAccept(success -> {
                    if (success) {
                        Fragment f = new ShopperDashboard();
                        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                        ft.replace(R.id.main_login_redirect, f).commit();
                    } else {
                        Toast.makeText(getActivity(), "Signup Unsuccessful",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ownersignup, container, false);
        Button btnSignUp = view.findViewById(R.id.owner_signup_button);
        EditText username_editText = view.findViewById(R.id.owner_username_editText);
        EditText password_editText = view.findViewById(R.id.owner_password_editText);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_editText.getText().toString();
                String password = password_editText.getText().toString();
                performOwnerSignUp(username, password);
            }
        });

        return view;
    }
}