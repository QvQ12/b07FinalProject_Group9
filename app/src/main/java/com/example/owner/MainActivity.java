package com.example.owner;

import android.os.Bundle;

import com.b07finalproject_group9.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.b07finalproject_group9.R;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the NavController associated with the NavHostFragment
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Set up the ActionBar with the NavController
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // If you have a BottomNavigationView, set it up with the NavController
        BottomNavigationView bottomNavView = findViewById(R.id.nav_view);
//        NavigationUI.setupWithNavController(bottomNavView, navController);
    }

}