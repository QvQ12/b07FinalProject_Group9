package com.b07finalproject_group9.owner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.b07finalproject_group9.R;
import com.example.owner.ui.dashboard.DashboardFragment;
import com.example.owner.ui.home.HomeFragment;
import com.example.owner.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class OwnerDashboardFragment extends Fragment {

    HomeFragment homeFragment = new HomeFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);

        BottomNavigationView bot_nav_view = view.findViewById(R.id.nav_view);

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main,
                homeFragment).commit();

        bot_nav_view.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navigation_home) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, homeFragment).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_dashboard) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, dashboardFragment).commit();
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_notifications){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, notificationsFragment).commit();
                    return true;
                }
                return false;
            }
        });

        return view;
    }
}