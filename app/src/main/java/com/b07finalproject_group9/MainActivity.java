package com.b07finalproject_group9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.b07finalproject_group9.databinding.MainActivityBinding;
import com.b07finalproject_group9.login.ownerlogin.OwnerLoginFragment;
import com.b07finalproject_group9.login.ownersignup.OwnerSignupFragment;
import com.b07finalproject_group9.login.shopperlogin.ShopperLoginFragment;
import com.b07finalproject_group9.login.shoppersignup.ShopperSignupFragment;
import com.b07finalproject_group9.objects.User;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    public static MainActivityBinding binding;
    public static User currUser; //Use this to track the current user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        FirebaseApp.initializeApp(this);

        Button btn_ownerlogin;
        Button btn_shopperlogin;
        Button btn_ownersignup;
        Button btn_shoppersignup;
        btn_ownerlogin = findViewById(R.id.ownerlogin_button);
        btn_shopperlogin = findViewById(R.id.shopperlogin_button);
        btn_ownersignup = findViewById(R.id.ownersignup_button);
        btn_shoppersignup = findViewById(R.id.shoppersignup_button);

        btn_ownerlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new OwnerLoginFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        btn_shopperlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new ShopperLoginFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        btn_shoppersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new ShopperSignupFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });

        btn_ownersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new OwnerSignupFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });


    }

}