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
import com.b07finalproject_group9.owner.OwnerDashboardFragment;
import com.b07finalproject_group9.owner.StoreOwnerInventoryModel;

public class EditProduct extends Fragment {

    Button ConfirmEdit;
    private EditText product_name_editText, quantity_editText, price_editText, description_editText;

    public  String key;

    public EditProduct(String productId) {
        this.key = productId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_product, container, false);
        product_name_editText = view.findViewById(R.id.name_editText);
        quantity_editText = view.findViewById(R.id.quantity_editText);
        price_editText = view.findViewById(R.id.price_editText);
        description_editText = view.findViewById(R.id.description_editText);
        ConfirmEdit = view.findViewById(R.id.confirm_edit);

        StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();

        // Fetch the product details
        sm.getSpecificProduct(key, MainActivity.currUser.getUsername()).thenAccept(productDetails -> {
            product_name_editText.setText(productDetails.get("product_name"));
            quantity_editText.setText(productDetails.get("quantity"));
            price_editText.setText(productDetails.get("price"));
            description_editText.setText(productDetails.get("description"));
        });

        ConfirmEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sm.editProductInventory(MainActivity.currUser.getUsername(), key,
                        product_name_editText.getText().toString(),
                        Double.parseDouble(price_editText.getText().toString()),
                        Integer.parseInt(quantity_editText.getText().toString()),
                        description_editText.getText().toString());
                Toast.makeText(getActivity(), "Product successfully edited: ", Toast.LENGTH_SHORT).show();
            }
        });

        Button back = view.findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Fragment f = new DashboardFragment();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.main_login_redirect, f).commit();
            }
        });
        return view;
    }
}