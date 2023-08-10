package com.b07finalproject_group9.owner.ui.notifications;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.b07finalproject_group9.R;
import java.util.ArrayList;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.b07finalproject_group9.OrderModel;
import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.owner.OwnerDashboardFragment;
import com.b07finalproject_group9.shopper.dashboard.ShopperDashboardFragment;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.b07finalproject_group9.databinding.FragmentNotificationsBinding;
import com.b07finalproject_group9.shopper.order.OrderAdapter;

public class NotificationsFragment extends Fragment {

    RecyclerView recyclerView;
    NotificationAdapter notificationAdapter;
    ArrayList<String> notificationsList;
    OrderModel om = new OrderModel();

    private void processKey(ArrayList<String> res){
        for(int i=0;i<res.size();i++){
            notificationsList.add(res.get(i));
        }
        recyclerView.setAdapter(notificationAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView = view.findViewById(R.id.notificationPageRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        notificationsList = new ArrayList<>(); // Initialize the list
        // Fetch order keys for the logged-in store owner
        notificationAdapter = new NotificationAdapter((getContext()),notificationsList,getActivity().getSupportFragmentManager());
        om.getOrderKeysFromStoreOwner(MainActivity.currUser.getUsername()).thenAccept(res -> processKey(res));

        Button returnToMainButton = view.findViewById(R.id.notificationsReturnButton);
        returnToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new OwnerDashboardFragment();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });



        return view;
    }
}