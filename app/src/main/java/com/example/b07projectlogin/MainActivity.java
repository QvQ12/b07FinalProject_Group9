package com.example.b07projectlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.b07projectlogin.R;
import com.example.b07projectlogin.ShopperLoginFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button btn_ownerlogin;
        Button btn_shopperlogin;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
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