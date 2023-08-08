package com.b07finalproject_group9.shopper;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.b07finalproject_group9.R;

public class ItemProduct extends Fragment {

    private ImageView productImage;
    private TextView productName;
    private Button minusButton;
    private Button plusButton;
    private TextView quantityTextView;
    private int quantity = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_product, container, false);

        productImage = view.findViewById(R.id.productImage);
        productName = view.findViewById(R.id.productName);
        minusButton = view.findViewById(R.id.minusButton);
        plusButton = view.findViewById(R.id.plusButton);
        quantityTextView = view.findViewById(R.id.quantityTextView);

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseQuantity();
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseQuantity();
            }
        });

        return view;
    }

    private void updateQuantityDisplay() {
        if (quantity <= 0) {
            // Remove the product or hide it
            getView().setVisibility(View.GONE);
        } else {
            quantityTextView.setText(String.valueOf(quantity));
        }
    }

    private void decreaseQuantity() {
        quantity--;
        updateQuantityDisplay();
    }

    private void increaseQuantity() {
        quantity++;
        updateQuantityDisplay();
    }
}
