package com.b07finalproject_group9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.b07finalproject_group9.login.ShopperLoginFragment;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        FirebaseApp.initializeApp(this);
        Button btn_ownerlogin;
        Button btn_shopperlogin;
        btn_ownerlogin = findViewById(R.id.btnOwnerRedirect);
        btn_shopperlogin = findViewById(R.id.btnShopperRedirect);

        btn_ownerlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    }

}