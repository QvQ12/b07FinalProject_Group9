package com.example.owner.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.b07finalproject_group9.R;

public class AddExistingProduct extends Fragment {

    Button confirmAdd;
    private EditText name, quantity, price, description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_existing_product, container, false);
        confirmAdd = view.findViewById(R.id.confirmAdd);

        confirmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //once click confirm add, should
                // 1. check if the product already exists
                // 2. if yes, add quantity to firebase
                // 3. if not, redirect to add_new_product
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}