package com.b07finalproject_group9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.b07finalproject_group9.databinding.ActivityStoreOwnerBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

//import com.example.b07finalproject_group9.databinding.ActivityStoreOwnerBinding;

public class StoreOwner extends AppCompatActivity {

    private ActivityStoreOwnerBinding binding;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityStoreOwnerBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_products, R.id.navigation_orders)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_store_owner);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
//    }

    private ImageView tShirts, sportsTShirts, femaleDresses, sweaters;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandFree, Laptops, watches, mobilePhones;
    private ImageView books, socks, shorts, gloves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_products);


        tShirts = (ImageView) findViewById(R.id.tshirts);
        sportsTShirts = (ImageView) findViewById(R.id.sports);
        femaleDresses = (ImageView) findViewById(R.id.female_dresses);
        sweaters = (ImageView) findViewById(R.id.sweater);

        glasses = (ImageView) findViewById(R.id.glasses);
        hatsCaps = (ImageView) findViewById(R.id.hats);
        walletsBagsPurses = (ImageView) findViewById(R.id.bags);
        shoes = (ImageView) findViewById(R.id.shoes);

        headPhonesHandFree = (ImageView) findViewById(R.id.headphones_handfree);
        Laptops = (ImageView) findViewById(R.id.laptop_pc);
        watches = (ImageView) findViewById(R.id.watches);
        mobilePhones = (ImageView) findViewById(R.id.mobilephones);

        books = (ImageView) findViewById(R.id.books);
        socks = (ImageView) findViewById(R.id.socks);
        shorts = (ImageView) findViewById(R.id.shorts);
        gloves = (ImageView) findViewById(R.id.gloves);


        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the intent to start the ProductDetailsActivity
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);

                // Put the product details as intent extras
                String productName = "T-Shirt";
                double productPrice = 19.99;
                String productDescription = "This is a cool T-shirt!"; // Replace this with the actual product description

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);

                // Start the ProductDetailsActivity
                startActivity(intent);
            }
        });

        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                // Put the product details as intent extras
                String productName = "Sports-Shirt";
                double productPrice = 24.99;
                String productDescription = "This is a nice sports shirt!"; // Replace this with the actual product description

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);

                startActivity(intent);
            }
        });


        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                // Put the product details as intent extras
                String productName = "Dress";
                double productPrice = 29.99;
                String productDescription = "This is a cute dress!"; // Replace this with the actual product description

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        sweaters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Sweater";
                double productPrice = 29.99;
                String productDescription = "This is a cute sweater!"; // Replace this with the actual product description

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Glasses";
                double productPrice = 19.99;
                String productDescription = "This is a pair of cute glasses!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Hats";
                double productPrice = 9.99;
                String productDescription = "This is a nice hat!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Bags";
                double productPrice = 9.99;
                String productDescription = "This is a nice purse!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Shoes";
                double productPrice = 29.99;
                String productDescription = "This is a nice pair of shoes!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Headphones";
                double productPrice = 39.99;
                String productDescription = "Set your hands free!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Laptops";
                double productPrice = 899.99;
                String productDescription = "This is a fast laptop!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Watch";
                double productPrice = 599.99;
                String productDescription = "This is a waterproof watch!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });


        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Phone";
                double productPrice = 799.99;
                String productDescription = "This is the new phone!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Books";
                double productPrice = 99.99;
                String productDescription = "This is the textbook for B07!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });
        socks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Socks";
                double productPrice = 9.99;
                String productDescription = "This is winter socks!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });
        shorts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Shorts";
                double productPrice = 19.99;
                String productDescription = "This is a nice shorts!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });

        gloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StoreOwner.this, ProductDetailsActivity.class);
                String productName = "Gloves";
                double productPrice = 19.99;
                String productDescription = "This is warm gloves!";

                intent.putExtra("productName", productName);
                intent.putExtra("productPrice", productPrice);
                intent.putExtra("productDescription", productDescription);
                startActivity(intent);
            }
        });
    }


}