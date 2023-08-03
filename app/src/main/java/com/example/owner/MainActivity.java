package com.example.owner;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.b07finalproject_group9.databinding.ActivityMainBinding;
import com.example.owner.ui.dashboard.DashboardFragment;
import com.example.owner.ui.home.HomeFragment;
import com.example.owner.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.b07finalproject_group9.R;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    BottomNavigationView bot_nav_view;

    HomeFragment homeFragment = new HomeFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bot_nav_view = findViewById(R.id.nav_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main,
                homeFragment).commit();

        bot_nav_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navigation_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, homeFragment).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_dashboard) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, dashboardFragment).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_notifications){
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, notificationsFragment).commit();
                    return true;
                }
                return false;
            }
        });


    }

}