package com.b07finalproject_group9;

import android.os.Bundle;

import com.b07finalproject_group9.databinding.ActivityProductDetailsBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class ProductDetailsActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityProductDetailsBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Retrieve the product details from the intent extras
        String productName = getIntent().getStringExtra("productName");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0.0); // Default value is 0.0
        String productDescription = getIntent().getStringExtra("productDescription");

        // Now you can populate the UI elements with the product details
        TextView productNameTextView = findViewById(R.id.productNameTextView);
        TextView productPriceTextView = findViewById(R.id.productPriceTextView);
        TextView productDescriptionTextView = findViewById(R.id.productDescriptionTextView);

        productNameTextView.setText(productName);
        productPriceTextView.setText(String.valueOf(productPrice));
        productDescriptionTextView.setText(productDescription);
    }
}