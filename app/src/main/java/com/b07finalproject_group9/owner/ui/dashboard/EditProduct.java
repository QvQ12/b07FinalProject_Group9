package com.b07finalproject_group9.owner.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.b07finalproject_group9.MainActivity;
import com.b07finalproject_group9.R;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;

public class EditProduct extends Fragment {

    Button ConfirmEdit;

    private EditText name, quantity, price, description;

    public static String key;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_product, container, false);

        EditText product_name_editText = view.findViewById(R.id.name_editText);
        EditText quantity_editText = view.findViewById(R.id.quantity_editText);
        EditText price_editText = view.findViewById(R.id.price_editText);
        EditText description_editText = view.findViewById(R.id.description_editText);

        ConfirmEdit = view.findViewById(R.id.confirm_edit);

        ConfirmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();
                sm.editProductInventory(MainActivity.currUser.getUsername(), key ,
                        product_name_editText.getText().toString(), Double.parseDouble(price_editText.getText().toString()),
                        Integer.parseInt(quantity_editText.getText().toString()) ,description_editText.getText().toString());
                Toast.makeText(getActivity(), "Product successfully edited: ",Toast.LENGTH_SHORT).show();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}