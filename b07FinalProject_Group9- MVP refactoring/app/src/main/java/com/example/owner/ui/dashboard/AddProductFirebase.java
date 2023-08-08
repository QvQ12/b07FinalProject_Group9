package com.example.owner.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.b07finalproject_group9.R;

public class AddProductFirebase extends Fragment {

    public AddProductFirebase() {
        // Required empty public constructor
    }

    /* to be edited based on firebase database */

    private void performAddProduct(String name, int quantity,Double price, String description){
        ProductModel pm = new ProductModel();
        pm.createNewProduct(name, quantity, price, description);
//                .thenAccept(success -> {
//                    if (success) {
//                        Fragment f = new DashboardFragment();
//                        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
//                        ft.replace(R.id.main_login_redirect, f).commit();
//                    } else {
//                        Toast.makeText(getActivity(), "Signup Unsuccessful",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_product_firebase, container, false);
    }
}