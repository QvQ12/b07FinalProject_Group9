package com.b07finalproject_group9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        LoginModel lm = new LoginModel();

        lm.checkExistingShopperUser("NikeJustDoIt");
        lm.checkExistingShopperUser("elvis");
        lm.checkExistingShopperUser("johndoe123");
        lm.checkExistingStoreOwnerUser("johndoe123");
        lm.checkExistingStoreOwnerUser("NikeJustDoIt");



        setContentView(R.layout.main_activity);
    }

}