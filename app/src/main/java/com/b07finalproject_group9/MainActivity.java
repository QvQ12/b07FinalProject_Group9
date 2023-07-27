package com.b07finalproject_group9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);
        DatabaseModel db = new DatabaseModel();
        db.storeSignUp("Nike","123");
        db.shopperSignUp("Johnny","456s");
        db.addProduct("Air Force 1", "NIke", 200, 5);
        db.addOrder("Nike", 1);
        setContentView(R.layout.main_activity);
    }
}