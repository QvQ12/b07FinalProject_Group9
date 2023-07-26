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
        db.storeSignUp("a","b");
        setContentView(R.layout.main_activity);
    }
}