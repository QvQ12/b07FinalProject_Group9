package com.b07finalproject_group9.shopper;

import com.b07finalproject_group9.R;

public class ItemTshirts {

    private String productID;
    private String description;
    private double price;
    private String productName;
    private int quantity;
    private int imageResource; // Local drawable resource

    // Default constructor for Firebase
    public ItemTshirts() {
        this.imageResource = R.drawable.tshirts;
    }

    // Constructor with parameters
    public ItemTshirts(String productID, String description, double price, String productName, int quantity) {
        this.productID = productID;
        this.description = description;
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
        this.imageResource = R.drawable.tshirts;
    }

    // Getter and Setter for productID
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter and Setter for imageResource
    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    @Override
    public String toString() {
        return "ItemTshirts{" +
                "productID='" + productID + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", imageResource=" + imageResource +
                '}';
    }
}
