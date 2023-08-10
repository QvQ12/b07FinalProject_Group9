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

public class AddNewProduct extends Fragment {

    Button confirmAdd;
    private EditText name, quantity, price, description;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_new_product, container, false);

        EditText product_name_editText = view.findViewById(R.id.name_editText);
        EditText quantity_editText = view.findViewById(R.id.quantity_editText);
        EditText price_editText = view.findViewById(R.id.price_editText);
        EditText description_editText = view.findViewById(R.id.description_editText);

        confirmAdd = view.findViewById(R.id.confirmAdd);

        confirmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    StoreOwnerInventoryModel sm = new StoreOwnerInventoryModel();
                    String username = MainActivity.currUser.getUsername();
                    String prod_name = String.valueOf(product_name_editText.getText()).trim();

                    if (prod_name.isEmpty() || quantity_editText.getText().toString().trim().isEmpty()
                            || price_editText.getText().toString().trim().isEmpty() || description_editText.getText().toString().trim().isEmpty()) {
                        Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    int quantity = Integer.parseInt(quantity_editText.getText().toString().trim());
                    double price = Double.parseDouble(price_editText.getText().toString().trim());
                    String description = String.valueOf(description_editText.getText()).trim();

                    String key = sm.addProductInventory(username, prod_name, price, quantity, description);
                    Toast.makeText(getActivity(), "Product successfully added with key: " + key, Toast.LENGTH_SHORT).show();

                    // Navigate to DashboardFragment
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.addNewProduct, new DashboardFragment()); // Assuming 'container' is the ID of your fragment container
                    transaction.commit();

                } catch (NumberFormatException e) {
                    Toast.makeText(getActivity(), "Invalid number format", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}
