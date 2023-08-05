package com.example.owner.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.b07finalproject_group9.DatabaseModel;
import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.databinding.ActivityMainBinding;
import com.b07finalproject_group9.databinding.FragmentHomeBinding;
import com.b07finalproject_group9.login.OwnerLoginFragment;
import com.b07finalproject_group9.objects.StoreOwnerUser;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.acl.Owner;

public class HomeFragment extends Fragment {
        private FragmentHomeBinding binding; // Remove unnecessary ViewModel-related code
        private TextView textView;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = FragmentHomeBinding.inflate(inflater, container, false);
            View root = binding.getRoot();

            textView = root.findViewById(R.id.textView3); // Initialize textView correctly

            DatabaseReference query = FirebaseDatabase.getInstance().getReference("Shopper-UserList");


            textView.setText(MainActivity.currUser.getPassword());

            return root;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;
        }
    }