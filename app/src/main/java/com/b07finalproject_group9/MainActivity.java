package com.b07finalproject_group9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        LoginModel lm = new LoginModel();

//        Log.i("Information", "Nike shopper?: " + lm.checkExistingShopperUser("NikeJustDoIt"));
//        Log.i("Information", "elvis shopper?: " + lm.checkExistingShopperUser("elvis") );
//
        Log.i("Information", "Nike store?: " + lm.checkExistingStoreOwnerUser("NikeJustDoIt"));
//        Log.i("Information", "elvis store?: " + lm.checkExistingStoreOwnerUser("elvis") );

        setContentView(R.layout.main_activity);
    }

}